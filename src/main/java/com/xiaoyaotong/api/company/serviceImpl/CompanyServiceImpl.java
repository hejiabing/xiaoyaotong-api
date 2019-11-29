package com.xiaoyaotong.api.company.serviceImpl;

import com.xiaoyaotong.api.company.entity.Company;
import com.xiaoyaotong.api.company.mapper.CompanyMapper;
import com.xiaoyaotong.api.company.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/19 9:54
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public Company getCompanyByCompanyId(Integer companyId) {
        return companyMapper.findByCompanyId(companyId);
    }
	@Override
	public int updateHeartBeat(Integer companyId) {
		return companyMapper.updateHeartBeat(companyId);
	}
}
