package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySpuVO;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/8 11:36 PM
 */
@Service
public class EsSpuSearchServiceImpl implements EsSpuSearchService {
    @Autowired
    EsMedicineSpuDao esMedicineSpuDao;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    RestHighLevelClient client;


    @Override
    public List<EsMedicineSpu> searchSpuList(QuerySpuVO querySpuVO) {

        List<EsMedicineSpu> spus = new ArrayList<>();
        String commonName = querySpuVO.getCommonName();//通用名
        String approvalCode = querySpuVO.getApprovalCode();//批准文号
        String barCode = querySpuVO.getBarCode();//条形码
        int startPage = querySpuVO.getStartPage();
        int pageSize = querySpuVO.getPageSize();


        if (querySpuVO != null){
            if(commonName!=null && commonName !=""){
                MultiMatchQueryBuilder mqb = QueryBuilders
                        .multiMatchQuery(commonName,
                                "commonName",
                                "approvalCode",
                                "barCode");//多字段查询

                SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(mqb)
                        .withIndices("spu").withTypes("spu")
                        .withSearchType(SearchType.DEFAULT)
                        .withPageable(PageRequest.of(startPage,pageSize))
                        .build();

                spus = elasticsearchTemplate.queryForList(searchQuery , EsMedicineSpu.class);

            }
        }
        return spus;
    }

    //根据每个filed进行精准搜索，用于产品批量对码
    @Override
    public List<EsMedicineSpu> searchSpuListByFileds(QuerySpuVO querySpuVO) {
        String commonName = querySpuVO.getCommonName();//通用名
        String approvalCode = querySpuVO.getApprovalCode();//批准文号
        String barCode = querySpuVO.getBarCode();//条形码
        int startPage = querySpuVO.getStartPage();
        int pageSize = querySpuVO.getPageSize();

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//布尔查询

        if (querySpuVO != null){
            if(commonName!=null && commonName !=""){
                bqb.must(QueryBuilders.matchQuery("commonName",commonName));
            }

            if(approvalCode!=null && approvalCode !=""){
                bqb.must(QueryBuilders.matchQuery("approvalCode",approvalCode));
            }

            if(barCode!=null && barCode !=""){
                bqb.must(QueryBuilders.matchQuery("barCode",barCode));
            }
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("spu").withTypes("spu")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(startPage,pageSize))
                .build();

        List<EsMedicineSpu> spus = elasticsearchTemplate.queryForList(searchQuery , EsMedicineSpu.class);
        return spus;
    }
}
