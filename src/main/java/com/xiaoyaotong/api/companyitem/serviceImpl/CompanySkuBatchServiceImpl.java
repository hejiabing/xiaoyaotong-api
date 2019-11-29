package com.xiaoyaotong.api.companyitem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuBatch;
import com.xiaoyaotong.api.companyitem.mapper.CompanySkuBatchMapper;
import com.xiaoyaotong.api.companyitem.service.CompanySkuBatchService;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:34
 */
@Service
public class CompanySkuBatchServiceImpl implements CompanySkuBatchService {

    @Autowired
    private CompanySkuBatchMapper companySkuBatchMapper;

    public int insertCompanySkuBatch(CompanySkuBatch companySkuBatch){
    	companySkuBatch.setCreateTime(new Date());
    	companySkuBatch.setCreateUser("sysSync");
    	return companySkuBatchMapper.insertSelective(companySkuBatch);
    }
 

    /**
     * 前期简单的通过循环调用来进行批量插入，后续再进行优化
     * @param skus
     * @return
     */
    @Override
    public int addCompanySkuBatchList(List<CompanySkuBatch> skus) {
        int addSuccessNum = 0;
        for (CompanySkuBatch sku : skus){
            int result = this.insertCompanySkuBatch(sku);
            if(result>0) addSuccessNum++;
        }
        return addSuccessNum;
    }

	@Override
	public Integer getCompanySkuBatchId(CompanySkuBatch csku) {
		return companySkuBatchMapper.getCompanySkuBatchId(csku);
	}

	@Override
	public int updateCompanySkuBatchById(CompanySkuBatch csku) {
		return companySkuBatchMapper.updateCompanySkuBatchById(csku);
	}
	
	@Override
	public int updateByCompanyIdAndProductCode(CompanySkuBatch csku) {
		return companySkuBatchMapper.updateByCompanyIdAndProductCode(csku);
	}

}
