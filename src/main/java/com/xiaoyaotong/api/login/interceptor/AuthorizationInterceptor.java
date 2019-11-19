package com.xiaoyaotong.api.login.interceptor;

import com.xiaoyaotong.api.company.entity.Company;
import com.xiaoyaotong.api.company.service.CompanyService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.login.config.Constants;
import com.xiaoyaotong.api.login.manager.TokenManager;
import com.xiaoyaotong.api.login.model.TokenModel;
import com.xiaoyaotong.api.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;


@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager manager;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();


        //方法不需要验证
        if (method.getAnnotation(Authorization.class) == null ){
            return true;
        }
        Authorization auth = method.getAnnotation(Authorization.class);

        //根据password进行验证
        if(Constants.PASSWORD_AUTHORIZATION.equals(auth.way())){
            //从header中得到token
            String authorization = request.getHeader(Constants.AUTHORIZATION);

            //需要验证，并authorization为空，直接返回
            if (method.getAnnotation(Authorization.class) != null && null == authorization ){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            //验证token
            TokenModel model = manager.getToken(authorization);
            if (manager.checkToken(model)) {
                //如果token验证成功，将token对应的用户id存在request中，便于之后注入
                request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
                return true;
            }
            //如果验证token失败，并且方法注明了Authorization，返回401错误
            if (method.getAnnotation(Authorization.class) != null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }
        //根据发送的KEY MD5的方式验证
        else if(Constants.KEY_AUTHORIZATION.equals(auth.way())){
            //获取加密的字符串
            String fromSign = request.getHeader(Constants.SIGN);
            //获取公司id
            String companyId = request.getHeader(Constants.COMPANY_ID);
            //获取公司配置的key
            Company company = companyService.getCompanyById(Integer.valueOf(companyId));
            String key = company.getSign();
            if (null == key || "".equals(key)|| "0".equals(key)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }else{
                HashMap hashMap = new HashMap();
                hashMap.put("from",fromSign);
                hashMap.put("companyId",companyId);
                hashMap.put("key",key);
                request.setAttribute("signWay",hashMap);
                return true;
            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
