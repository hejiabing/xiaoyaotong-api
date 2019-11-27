package com.xiaoyaotong.api.companyitem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.mapper.CompanySkuMapper;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:34
 */
@Service
public class CompanySkuServiceImpl implements CompanySkuService {

    @Autowired
    private CompanySkuMapper companySkuMapper;

    public int insertCompanySku(CompanySku companySku){
        int result = companySkuMapper.insertCompanySku(companySku);
        return result;
    }

    @Override
    public int deleteCompanySku(CompanySku sku){
        int result = companySkuMapper.deleteCompanySku(sku.getCompayId(),sku.getErpId());
        return result;
    }

    @Override
    public CompanySku getCompanySkuById(int companyId, String erpId) {
        return companySkuMapper.selectCompanySkuByid(companyId,erpId);
    }

    @Override
    public List<CompanySku> getCompanySkuList(int itemBegin, int itemNum) {
        return companySkuMapper.selectCompanySkuList(itemBegin,itemNum);
    }

    /**
     * 前期简单的通过循环调用来进行批量插入，后续再进行优化
     * @param skus
     * @return
     */
    @Override
    public int addCompanySkuList(List<CompanySku> skus) {
        int addSuccessNum = 0;
        for (CompanySku sku : skus){
            int result = this.insertCompanySku(sku);
            if(result>0) addSuccessNum++;
        }
        return addSuccessNum;
    }

	@Override
	public Integer getCompanySkuId(int companyId, String productCode) {
		return companySkuMapper.getCompanySkuId(companyId,productCode);
	}

	@Override
	public int updateCompanySkuById(CompanySku csku) {
		return companySkuMapper.updateCompanySkuById(csku);
	}
	
	@Override
	public int updateByCompanyIdAndProductCode(CompanySku csku) {
		return companySkuMapper.updateByCompanyIdAndProductCode(csku);
	}
}
