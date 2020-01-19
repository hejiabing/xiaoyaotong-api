package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySpuVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
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
    private static Log log = LogFactory.getLog(EsSpuSynServiceImpl.class);

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

        //
        if(pageSize<2){pageSize=10;}

        if (querySpuVO != null){
            if(commonName!=null && commonName !=""){

                BoolQueryBuilder bqb =
                        QueryBuilders.boolQuery()
                                /*查询通用名，分词*/
                                .should(QueryBuilders.matchPhraseQuery("commonName",commonName))
                                /*查询国药准字，不分词，分词查询*/
                                .should(QueryBuilders.matchPhraseQuery("approvalCode", commonName))
                                /*查询spu*/
                                .should(QueryBuilders.matchPhraseQuery("spuCode",commonName))
                                /*查询barCode*/
                                .should(QueryBuilders.matchPhraseQuery("barCode",commonName));
                ;

                SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                        .withIndices("spu").withTypes("spu")
                        .withSearchType(SearchType.DEFAULT)
                        .withPageable(PageRequest.of(startPage,pageSize))
                        .build();


                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                searchSourceBuilder.query(searchQuery.getQuery());
                log.info("拼接的查询请求======");
                log.info(searchSourceBuilder.toString());

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
