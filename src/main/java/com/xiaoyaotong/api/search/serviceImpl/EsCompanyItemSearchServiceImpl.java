package com.xiaoyaotong.api.search.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.xiaoyaotong.api.search.dto.CompanyItemDTO;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.service.EsCompanyItemSearchService;
import com.xiaoyaotong.api.search.vo.QueryCompanyItemVO;
import com.xiaoyaotong.api.util.JsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：商家的商品的搜索类
 * @date ：2019/12/21 6:27 PM
 */
@Service
public class EsCompanyItemSearchServiceImpl implements EsCompanyItemSearchService {
    private static Log log = LogFactory.getLog(EsCompanyItemSearchServiceImpl.class);

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public CompanyItemDTO searchCompanyItemList(QueryCompanyItemVO queryCompanyItemVO) {
        log.debug(JSON.toJSONString(queryCompanyItemVO));

        CompanyItemDTO companyItemDTO = new CompanyItemDTO();
        String commonName = queryCompanyItemVO.getCommonName();//通用名
        String companySkuCode = queryCompanyItemVO.getCompanySkuCode();//公司skuid
        int companyId = queryCompanyItemVO.getCompanyId();//公司id
        Integer matched = queryCompanyItemVO.getMatached();//是否匹配过标品库

        Integer startPage = queryCompanyItemVO.getStartPage();//分页的起始页
        Integer pageSize = queryCompanyItemVO.getPageSize();//每页的条数

        if(startPage==null){//防呆，如果为空，则置为0
            startPage = 0;
        }

        if(pageSize == null) {//防呆，如果为空，则置为10
            pageSize = 10;
        }else if(pageSize < 1){//防呆，如果小于1，则置为10
            pageSize = 10;
        }

        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//最上层的布尔查询

        if (queryCompanyItemVO != null){ //判断不为空

            if(companyId < 1){ //公司的编码不能为空，且要大于0
                return null; //公司编码不对直接返回
            }else{
                bqb.filter(QueryBuilders.termQuery("companyId",companyId));//公司编码作为filter过滤
            }

            if(matched!=null){//是否匹配，通过filter过滤
                bqb.filter(QueryBuilders.termQuery("matched",matched));
            }

            BoolQueryBuilder keybqb = QueryBuilders.boolQuery();//第二次布尔查询，用于关键字的搜索


            if(commonName != null && commonName != ""){
                //bqb.must(QueryBuilders.matchPhraseQuery("commonName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("commonName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("companySkuCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("barCode",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("factoryName",commonName));
                keybqb.should(QueryBuilders.matchPhraseQuery("approvalCode",commonName));
            }

            if(companySkuCode!=null && companySkuCode !=""){
                keybqb.should(QueryBuilders.matchPhraseQuery("companySkuCode",companySkuCode));
            }

            bqb.must(keybqb);
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("companyitem").withTypes("companyitem")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(startPage,pageSize))
                .build();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(searchQuery.getQuery());
        log.debug("CompanyItem拼接的查询请求======");
        log.debug(searchSourceBuilder.toString());

        long count = elasticsearchTemplate.count(searchQuery);
        log.debug("搜索到的数量为：" + count);
        List<EsCompanyItem> skus = elasticsearchTemplate.queryForList(searchQuery , EsCompanyItem.class);
        companyItemDTO.setItems(skus);
        companyItemDTO.setStartPage(queryCompanyItemVO.getStartPage());
        companyItemDTO.setPageSize(queryCompanyItemVO.getPageSize());
        companyItemDTO.setCount(count);
        return companyItemDTO;
    }
}
