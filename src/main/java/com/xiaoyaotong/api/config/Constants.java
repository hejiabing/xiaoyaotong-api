package com.xiaoyaotong.api.config;

public interface Constants {


    public final static String ES_SYNC_BEGIN = "BEBIN";

    public final static String ES_SYNC_DOING = "DOING";

    public final static String ES_SYNC_FINISHED = "FINISHED";

    /**
     * ES 全量同步SPU的标记
     */
    public final static String ES_ALL_SPU_SYNC = "spu_all_sync";


    /**
     * ES 增量同步SPU的标记
     */
    public final static String ES_INCREMENT_SPU_SYNC = "spu_increment_sync";
    public final static String ES_INCREMENT_SPU_SYNC_MAXID = "spu_increment_spu_sync_maxid";

    /**
     * ES 全量同步SKU的标记
     */
    public final static String ES_ALL_SKU_SYNC = "spu_all_sync";


    /**
     * ES 增量同步SKU的标记
     */
    public final static String ES_INCREMENT_SKU_SYNC = "sku_increment_sync";
    public final static String ES_INCREMENT_SKU_SYNC_MAXID = "spu_increment_sku_sync_maxid";

}
