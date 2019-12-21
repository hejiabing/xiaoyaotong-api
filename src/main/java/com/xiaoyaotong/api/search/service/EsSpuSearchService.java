package com.xiaoyaotong.api.search.service;

import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.vo.QuerySpuVO;

import java.util.List;

/**
 * @author ：billHe
 * @description：通过es搜索SPU的服务
 * @date ：2019/12/8 11:34 PM
 */
public interface EsSpuSearchService {
    public List<EsMedicineSpu> searchSpuList(QuerySpuVO querySpuVO);
}
