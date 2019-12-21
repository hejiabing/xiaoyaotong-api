package com.xiaoyaotong.api.search.service;

import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.search.dto.CompanyItemDTO;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.vo.QueryCompanyItemVO;
import com.xiaoyaotong.api.search.vo.QuerySkuVO;
import com.xiaoyaotong.api.search.vo.ReturnSkuVO;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 6:19 PM
 */
public interface EsCompanyItemSearchService {
    public CompanyItemDTO searchCompanyItemList(QueryCompanyItemVO queryCompanyItemVO);
}
