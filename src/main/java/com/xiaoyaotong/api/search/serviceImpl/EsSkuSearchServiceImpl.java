package com.xiaoyaotong.api.search.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsSkuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySkuVO;
import com.xiaoyaotong.api.search.vo.ReturnSkuVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
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
 * @description：搜索sku类
 * @date ：2019/12/10 11:18 PM
 */
@Service
public class EsSkuSearchServiceImpl implements EsSkuSearchService {
    private static Log log = LogFactory.getLog(EsSkuSearchServiceImpl.class);

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public ReturnSkuVO searchSkuList(QuerySkuVO querySkuVO) {
        log.debug(JSON.toJSONString(querySkuVO));

        String commonName = querySkuVO.getCommonName();//通用名
        String approvalCode = querySkuVO.getApprovalCode();//批准文号
        String barCode = querySkuVO.getBarCode();//条形码
        String factoryName = querySkuVO.getFactoryName();//生产厂家
        String companyName = querySkuVO.getCompanyName();// 商家名字
        Integer companyId = querySkuVO.getCompanyId();
        Integer status = querySkuVO.getStatus();//上下家状态

        Integer startPage = querySkuVO.getStartPage();
        Integer pageSize = querySkuVO.getPageSize();

        if(startPage==null){//防呆，如果为空，则置为0
            startPage = 0;
        }

        if(pageSize == null) {//防呆，如果为空，则置为10
            pageSize = 10;
        }else if(pageSize < 1){//防呆，如果小于1，则置为10
            pageSize = 10;
        }

        ReturnSkuVO returnSkuVO = new ReturnSkuVO();

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//最上层的布尔查询

        if (querySkuVO != null){ //判断不为空
            if(companyId != null && companyId > 0){ //公司的编码不能为空，且要大于0
                bqb.filter(QueryBuilders.termQuery("companyId",companyId));//公司编码作为filter过滤
            }

            if(status != null){//是否匹配，通过filter过滤
                bqb.filter(QueryBuilders.termQuery("status",status));
            }

            BoolQueryBuilder keybqb = QueryBuilders.boolQuery();//第二次布尔查询，用于关键字的搜索


            if(commonName != null && commonName != ""){
                //bqb.must(QueryBuilders.matchPhraseQuery("commonName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("commonName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("companySkuCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("barCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("factoryName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("approvalCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("spuCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("skuCode",commonName));
            }

            bqb.must(keybqb);
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("sku").withTypes("sku")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(startPage,pageSize))
                .build();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(searchQuery.getQuery());
        log.debug("sku拼接的查询请求======");
        log.debug(searchSourceBuilder.toString());

        long count = elasticsearchTemplate.count(searchQuery);

        log.debug("搜索到的结果：" + count);

        List<EsPlatformSku> skus = elasticsearchTemplate.queryForList(searchQuery , EsPlatformSku.class);
        returnSkuVO.setCount(count);
        returnSkuVO.setSkus(skus);

        return returnSkuVO;
    }
}
