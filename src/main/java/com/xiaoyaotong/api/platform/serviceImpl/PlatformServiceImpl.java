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
    public int getAllPlatformSkuCount() {
        return platformSkuMapper.getAllPlatformSkuCount();
    }

    @Override
    public PlatformSku getSkuBySkuCode(String skuCode) {
        return platformSkuMapper.getPlatformBySkuCode(skuCode);
    }

    @Override
    public List<PlatformSku> getSkuByCompanyId(int companyId) {
        return platformSkuMapper.getPlatformSkuByCompanyId(companyId);
    }

    @Override
    public List<PlatformSku> getPlatformSkuList(int beginPage, int pageSize) {
        return platformSkuMapper.getPlatformSkuList(beginPage,pageSize);
    }

    @Override
    public List<PlatformSku> getPlatformSkuByCompanyIdAndCompanySkuCode(int companyId, String companySkuCode) {
        return platformSkuMapper.getPlatformSkuByCompanyIdAndCompanySkuCode(companyId,companySkuCode);
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

	@Override
	public int updatePlatformSkuById(PlatformSku platSku) {
		return platformSkuMapper.updatePlatformSkuById(platSku);
	}

	@Override
	public List<PlatformSku> getPlatformSkuBySelective(PlatformSku platformSku) {
		return platformSkuMapper.getPlatformSkuBySelective(platformSku);
	}
}
