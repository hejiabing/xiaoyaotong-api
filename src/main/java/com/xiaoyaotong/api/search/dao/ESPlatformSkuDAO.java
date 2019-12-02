package com.xiaoyaotong.api.search.dao;

import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.entity.ESPlatformSku;
import org.springframework.data.repository.CrudRepository;

public interface ESPlatformSkuDAO extends CrudRepository<ESPlatformSku, String> {
}
