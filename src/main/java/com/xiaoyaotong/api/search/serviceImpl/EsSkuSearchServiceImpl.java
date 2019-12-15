package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsSkuSearchService;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/10 11:18 PM
 */
@Service
public class EsSkuSearchServiceImpl implements EsSkuSearchService {



    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<EsPlatformSku> searchSkuList(EsPlatformSku esPlatformSku) {
        String commonName = esPlatformSku.getCommonName();//通用名
        String approvalCode = esPlatformSku.getApprovalCode();//批准文号
        String barCode = esPlatformSku.getBarCode();//条形码
        String factoryName = esPlatformSku.getFactoryName();//生产厂家
        String companyName = esPlatformSku.getCompanyName();// 商家名字

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//布尔查询

        if (esPlatformSku != null){
            if(commonName!=null && commonName !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("commonName",commonName));
            }

            if(approvalCode!=null && approvalCode !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("approvalCode",approvalCode));
            }

            if(barCode!=null && barCode !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("barCode",barCode));
            }

            if(factoryName!=null && factoryName !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("factoryName",factoryName));
            }

            if(companyName!=null && companyName !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("companyName",companyName));
            }
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("sku").withTypes("sku")
                .withSearchType(SearchType.DEFAULT)
                .build();

        List<EsPlatformSku> spus = elasticsearchTemplate.queryForList(searchQuery , EsPlatformSku.class);
        return spus;
    }
}
