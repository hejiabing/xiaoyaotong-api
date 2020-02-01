package com.xiaoyaotong.api.skumatch.serviceimpl;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySpuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyaotong.api.skumatch.service.SkuMatchService;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2020/1/31 7:53 PM
 */
@Service
public class SkuMatchServiceImpl implements SkuMatchService {
    private static Logger log = LoggerFactory.getLogger(SkuMatchServiceImpl.class);

    @Autowired
    EsSpuSearchService esSpuSearchService;

    @Autowired
    private CompanySkuService companySkuService;

    @Override
    public void matchSku() {
        //读取没有匹配的companyItem
        List<CompanySku> skus = companySkuService.getUnmatchedCompanyItems();

        for(CompanySku iter: skus){

            String approvalCode = iter.getApprovalCode();//获取国药准字
            String skuSpec = iter.getSpec();//获取规格

            //根据国药准字搜索获取SPU
            List<EsMedicineSpu> spus = this.matchByApprovalCode(approvalCode);

            //第3步，根据规格匹配，从国药准字匹配过来的数据里面挑选
            for(EsMedicineSpu spu:spus){
                String spuSpec = spu.getSpec();
                Boolean result = matchSpec(skuSpec,spuSpec);
                if(result == true){
                    //匹配上以后，打标&设置
                    iter.setSpuCode(spu.getSpuCode());
                    iter.setMatched(1);
                    companySkuService.updateCompanySkuById(iter);
                    return;
                }
            }
        }
    }

    @Override
    public List<EsMedicineSpu> matchByApprovalCode(String approvalCode) {
        QuerySpuVO vo = new QuerySpuVO();
        vo.setApprovalCode(approvalCode);
        vo.setStartPage(0);
        vo.setPageSize(10);
        List<EsMedicineSpu> spus = esSpuSearchService.searchSpuList(vo);
        return spus;

    }

    @Override
    public void matchBySpec() {

    }

    //匹配2个字符串是否是同一规格
    private boolean matchSpec(String skuSpec,String spuSpec){
        //完全相等的情况
        if(skuSpec.equals(spuSpec)){
            return true;
        }
        return false;
    }
}
