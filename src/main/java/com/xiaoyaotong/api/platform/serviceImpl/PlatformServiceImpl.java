package com.xiaoyaotong.api.platform.serviceImpl;

import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.mapper.PlatformSkuMapper;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/1 7:40 PM
 */
public class PlatformServiceImpl implements PlatformSkuService {

    @Autowired
    private PlatformSkuMapper platformSkuMapper;

    @Override
    public PlatformSku getSkuBySkuId() {
        return null;
    }

    @Override
    public List<PlatformSku> getSkuByCompanyId(int companyId) {
        return null;
    }

    @Override
    public int insertPlatformSku(PlatformSku platformSku) {
        return 0;
    }

    @Override
    public int updatePlatformSku(PlatformSku platformSku) {
        return 0;
    }

    @Override
    public int deletePlatformSku(String skuId) {
        return 0;
    }
}
