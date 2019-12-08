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

    public int updateByCompanyIdAndskuCode(CompanySku companySku);

    //根据公司id和公司sku编码
    public List<CompanySku> selectSkuByCompanyIdAndSkuCode(@Param("companyId") int companyId, @Param("companySkucode")String companySkucode);

    //根据公司id查询
    public List<CompanySku> selectSkuByCompanyId(int companyId);


    public List<CompanySku>  updateSpuCodeByCompanyIdAndskuCode(int companyId, String companySkucode);

    public List<CompanySku> selectCompanySkuList(int itemBegin, int itemNum);

	public Integer getCompanySkuId(@Param("companyId")  int companyId,@Param("companySkucode") String companySkucode);

	public int updateCompanySkuById(CompanySku csku);
}
