package com.xiaoyaotong.api.companyitem.mapper;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.vo.CompanySkuInfo;
import com.xiaoyaotong.api.companyitem.vo.QueryCompanySkuVO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    public List<CompanySku> selectSkuByCompanyIdAndSkuCode(@Param("companyId") int companyId, @Param("companySkuCode")String companySkuCode,@Param("matched") int matched);

    //根据公司id查询
    public List<CompanySku> selectSkuByCompanyId(@Param("companyId")int companyId,@Param("matched") int matched);


    public List<CompanySku>  updateSpuCodeByCompanyIdAndskuCode(@Param("companyId")  int companyId,@Param("companySkuCode") String companySkuCode);

    public List<CompanySku> selectCompanySkuList(@Param("itemBegin")int itemBegin, @Param("itemNum")int itemNum);

	public Integer getCompanySkuId(@Param("companyId")  int companyId,@Param("companySkuCode") String companySkuCode);

	public int updateCompanySkuById(CompanySku csku);

	public int insertCompanySkuBySelective(CompanySku companySku);

	public int getCompanyItemCount(int onShelf);

	public int getChangedCompanyItemCount(String beginTime);

	public List<CompanySku> getUnmatchedCompanyItems(int size);

	public List<CompanySku> getChangedCompanyItemList(@Param("beginTime")String beginTime,
                                                      @Param("beginPage") int beginPage,
                                                      @Param("pageSize") int pageSize);

	public List<CompanySkuInfo> getCompanySkuInfoList(
			QueryCompanySkuVO queryCompanySkuVO);
}
