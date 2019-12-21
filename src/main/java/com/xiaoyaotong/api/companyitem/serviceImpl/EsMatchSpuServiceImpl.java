package com.xiaoyaotong.api.companyitem.serviceImpl;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.MatchSpuService;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

/**
 * @author ：billHe
 * @description：采用
 * @date ：2019/12/21 3:45 PM
 */
public class EsMatchSpuServiceImpl implements MatchSpuService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<EsMedicineSpu> matchSpuWithBarCode(CompanySku companySku) {
        String barCode = companySku.getBarCode();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("barCode",barCode);

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQueryBuilder)
                .withIndices("spu").withTypes("spu")
                .withSearchType(SearchType.DEFAULT)
                .withPageable(PageRequest.of(0,10))
                .build();

        List<EsMedicineSpu> spus = elasticsearchTemplate.queryForList(searchQuery , EsMedicineSpu.class);

        return spus;
    }

    @Override
    public boolean matchSpuWithAll(CompanySku companySku) {
        return false;
    }

    @Override
    public boolean matchSpuWithApprovalCodeAndSpec(CompanySku companySku) {
        return false;
    }

    @Override
    public boolean matchSpuWithExistData(CompanySku companySku) {
        return false;
    }
}
