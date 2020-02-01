package com.xiaoyaotong.api.companyitem.serviceImpl;

import java.util.Date;
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
    	companySku.setStatus(-1);
    	companySku.setCreateUser("syncJob");
    	companySku.setUpdateUser("syncJob");
    	companySku.setCreateTime(new Date());
        int result = companySkuMapper.insertCompanySku(companySku);
        return result;
    }

    @Override
    public int deleteCompanySku(CompanySku sku){
        int result = companySkuMapper.deleteCompanySku(sku.getCompanyId(),sku.getCompanySkuCode());
        return result;
    }


    @Override
    public List<CompanySku> getSkuByCompanyIdAndSkuCode(int companyId, String skuCode,int matched) {
        return companySkuMapper.selectSkuByCompanyIdAndSkuCode(companyId,skuCode,matched);
    }

    @Override
    public List<CompanySku> getCompanySkuList(int itemBegin, int itemNum) {
        return companySkuMapper.selectCompanySkuList(itemBegin,itemNum);
    }

    @Override
    public List<CompanySku> getSkuByCompanyId(int companyId,int matched) {
        return companySkuMapper.selectSkuByCompanyId(companyId,matched);
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
	public int updateCompanySkuById(CompanySku csku) {
		return companySkuMapper.updateCompanySkuById(csku);
	}
	
	@Override
	public int updateByCompanyIdAndSkuCode(CompanySku csku) {
		return companySkuMapper.updateByCompanyIdAndskuCode(csku);
	}

	@Override
	public int insertCompanySkuBySelective(CompanySku companySku) {
		companySku.setStatus(-1);
    	companySku.setCreateUser("syncJob");
    	companySku.setUpdateUser("syncJob");
    	companySku.setCreateTime(new Date());
        int result = companySkuMapper.insertCompanySkuBySelective(companySku);
        return result;
	}

    @Override
    public int getCompanyItemCount(int matched) {
        return companySkuMapper.getCompanyItemCount(matched);
    }

    @Override
    public int getIncrementCompanyItemCount(String beginTime) {
        return companySkuMapper.getChangedCompanyItemCount(beginTime);
    }

    @Override
    public List<CompanySku> getUnmatchedCompanyItems() {
        return companySkuMapper.getUnmatchedCompanyItems(200);
    }

    @Override
    public List<CompanySku> getIncrementCompanyItemList(String beginTime, int beginPage, int pageSize) {
        return companySkuMapper.getChangedCompanyItemList(beginTime,beginPage,pageSize);
    }
}
