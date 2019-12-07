package com.xiaoyaotong.api.platform.serviceImpl;

import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.mapper.PlatformSkuMapper;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：platformserice的方法实现
 * @date ：2019/12/1 7:40 PM
 */
@Service
public class PlatformServiceImpl implements PlatformSkuService {

    @Autowired
    private PlatformSkuMapper platformSkuMapper;

    @Override
    public PlatformSku getSkuBySkuId(String skuId) {
        return platformSkuMapper.getPlatformSkuById(skuId);
    }

    @Override
    public List<PlatformSku> getSkuByCompanyId(int companyId) {
        return platformSkuMapper.getPlatformSkyByCompanyId(companyId);
    }

    @Override
    public List<PlatformSku> getSkuByCompanyIdAndSkuCode(int companyId, String companySkucode) {
        return platformSkuMapper.getPlatformSkyByCompanyIdAndSkuCode(companyId,companySkucode);
    }

    @Override
    public int insertPlatformSku(PlatformSku platformSku) {
        return platformSkuMapper.insertPlatformSku(platformSku);
    }

    @Override
    public int updatePlatformSku(PlatformSku platformSku) {
        return platformSkuMapper.updatePlatformSku(platformSku);
    }

    @Override
    public int deletePlatformSku(String skuId) {
        return  platformSkuMapper.deletePlatformSku(skuId);
    }
}
