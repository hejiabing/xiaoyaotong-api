package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsSkuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySkuVO;
import com.xiaoyaotong.api.search.vo.ReturnSkuVO;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ReturnSkuVO searchSkuList(QuerySkuVO querySkuVO) {
        String commonName = querySkuVO.getCommonName();//通用名
        String approvalCode = querySkuVO.getApprovalCode();//批准文号
        String barCode = querySkuVO.getBarCode();//条形码
        String factoryName = querySkuVO.getFactoryName();//生产厂家
        String companyName = querySkuVO.getCompanyName();// 商家名字
        Integer companyId = querySkuVO.getCompanyId();
        Integer status = querySkuVO.getStatus();//上下家状态

        Integer startPage = querySkuVO.getStartPage();
        Integer pageSize = querySkuVO.getPageSize();

        if(startPage==null){
            startPage = 0;
        }

        if(pageSize==null) {pageSize = 10;}

        ReturnSkuVO returnSkuVO = new ReturnSkuVO();

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//布尔查询

        if (querySkuVO != null){
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

            if(status!=null){
                bqb.must(QueryBuilders.matchPhraseQuery("status",status));
            }
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("sku").withTypes("sku")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(startPage,pageSize))
                .build();

        long count = elasticsearchTemplate.count(searchQuery);

        List<EsPlatformSku> skus = elasticsearchTemplate.queryForList(searchQuery , EsPlatformSku.class);
        returnSkuVO.setCount(count);
        returnSkuVO.setSkus(skus);

        return returnSkuVO;
    }
}
