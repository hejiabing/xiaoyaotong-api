package com.xiaoyaotong.api.login.config;

/**
 * 常量
 * @author billHe
 * @date 2019-11-06
 */
public class Constants {

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "authorization";


    //使用key的方式进行验证
    public static final String KEY_AUTHORIZATION = "sign";

    //使用password的方式进行验证
    public static final String PASSWORD_AUTHORIZATION = "password";

    public static final String SIGN = "sign";

    public static final String USER_ID = "userid";

    public static final String COMPANY_ID = "companyid";

}
