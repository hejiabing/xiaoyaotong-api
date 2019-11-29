package com.xiaoyaotong.api.company.mapper;

import com.xiaoyaotong.api.company.entity.Company;

import org.springframework.stereotype.Repository;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/19 9:44
 */
@Repository
public interface CompanyMapper {
    Company findByCompanyId(Integer id);

	int updateHeartBeat(Integer companyId);

}
