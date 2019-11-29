package com.xiaoyaotong.api.company.service;

import com.xiaoyaotong.api.company.entity.Company;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/19 9:54
 */
public interface CompanyService {
    public Company getCompanyByCompanyId(Integer id);

	public int updateHeartBeat(Integer companyId);
}
