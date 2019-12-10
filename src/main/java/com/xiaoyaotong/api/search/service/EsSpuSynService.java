package com.xiaoyaotong.api.search.service;

import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：同步SPU数据到ES
 * @date ：2019/12/3 10:38 PM
 */
public interface EsSpuSynService {

    //全量同步
    public void synAllSpu();

    //增量同步
    public void synIncrementSpu();


}
