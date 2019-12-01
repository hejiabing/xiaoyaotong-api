package com.xiaoyaotong.api.companyitem.mapper;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:00
 */
@Repository
public interface CompanySkuMapper {

    public int insertCompanySku(CompanySku companySku);

    public int deleteCompanySku(int companyId,String erpId);

    public int updateByCompanyIdAndSkuCode(CompanySku companySku);

    public CompanySku selectCompanySkuByid(int companyId, String erpId);

    public List<CompanySku> selectCompanySkuList(int itemBegin, int itemNum);

	public Integer getCompanySkuId(@Param("companyId")  int companyId,@Param("productCode") String productCode);

	public int updateCompanySkuById(CompanySku csku);
}
