package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.search.dto.CompanyItemDTO;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsCompanyItemSearchService;
import com.xiaoyaotong.api.search.vo.QueryCompanyItemVO;
import com.xiaoyaotong.api.search.vo.ReturnSkuVO;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 6:27 PM
 */
@Service
public class EsCompanyItemSearchServiceImpl implements EsCompanyItemSearchService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public CompanyItemDTO searchCompanyItemList(QueryCompanyItemVO queryCompanyItemVO) {
        CompanyItemDTO companyItemDTO = new CompanyItemDTO();
        String commonName = queryCompanyItemVO.getCommonName();//通用名
        String companySkuCode = queryCompanyItemVO.getCompanySkuCode();//公司skuid
        int companyId = queryCompanyItemVO.getCompanyId();//公司id
        Integer matched = queryCompanyItemVO.getMatached();//


        Integer startPage = queryCompanyItemVO.getStartPage();
        Integer pageSize = queryCompanyItemVO.getPageSize();

        if(startPage==null){
            startPage = 0;
        }

        if(pageSize == null) {pageSize = 10;}


        BoolQueryBuilder bqb = QueryBuilders.boolQuery();//布尔查询

        if (queryCompanyItemVO != null){

            if(companyId<1){
                return null;
            }else{
                bqb.must(QueryBuilders.matchPhraseQuery("companyId",companyId));
            }

            if(commonName!=null && commonName !=""){
                //bqb.must(QueryBuilders.matchPhraseQuery("commonName",commonName));
                bqb.must(QueryBuilders.multiMatchQuery(commonName,"commonName","companySkuCode","approvalCode"));
            }

            if(companySkuCode!=null && companySkuCode !=""){
                bqb.must(QueryBuilders.matchPhraseQuery("companySkuCode",companySkuCode));
            }

            if(matched!=null){
                bqb.must(QueryBuilders.matchPhraseQuery("matched",matched));
            }
        }

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(bqb)
                .withIndices("companyitem").withTypes("companyitem")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(startPage,pageSize))
                .build();

        long count = elasticsearchTemplate.count(searchQuery);
        List<EsCompanyItem> skus = elasticsearchTemplate.queryForList(searchQuery , EsCompanyItem.class);
        companyItemDTO.setItems(skus);
        companyItemDTO.setStartPage(queryCompanyItemVO.getStartPage());
        companyItemDTO.setPageSize(queryCompanyItemVO.getPageSize());
        companyItemDTO.setCount(count);
        return companyItemDTO;
    }
}
