package com.xiaoyaotong.api.search.service;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 8:37 PM
 */
public interface EsCompanyItemSynService {

    //全量同步
    public void synAllCompanyItem();

    //增量同步
    public void synIncrementCompanyItem();
}
