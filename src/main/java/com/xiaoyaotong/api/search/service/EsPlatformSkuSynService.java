package com.xiaoyaotong.api.search.service;

/**
 * @author ：billHe
 * @description：同步SPU数据到ES
 * @date ：2019/12/3 10:38 PM
 */
public interface EsPlatformSkuSynService {

    //全量同步
    public void synAllSku();

    //增量同步
    public void synIncrementSku();

}
