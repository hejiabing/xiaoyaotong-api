package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.ESMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
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
 * @date ：2019/12/8 11:36 PM
 */
@Service
public class EsSpuSearchServiceImpl implements EsSpuSearchService {
    @Autowired
    ESMedicineSpuDao esMedicineSpuDao;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<ESMedicineSpu> searchSpuList(ESMedicineSpu esMedicineSpu) {
        String commonName = esMedicineSpu.getCommonName();//通用名
        String approvalCode = esMedicineSpu.getApprovalCode();//批准文号
        String barCode = esMedicineSpu.getBarCode();//条形码

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//布尔查询

        if (esMedicineSpu != null){
            if(commonName!=null && commonName !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("commonName",commonName));
            }

            if(approvalCode!=null && approvalCode !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("approvalCode",approvalCode));
            }

            if(barCode!=null && barCode !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("barCode",barCode));
            }
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("spu").withTypes("spu")
                .withSearchType(SearchType.DEFAULT)
                .build();

        List<ESMedicineSpu> spus = elasticsearchTemplate.queryForList(searchQuery , ESMedicineSpu.class);
        return spus;
    }
}
