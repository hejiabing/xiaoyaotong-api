package com.xiaoyaotong.api.platform.vo;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/14 4:40 PM
 */
public class OnsalePlatformSkuVO {

	private Integer companyId;
	
    private List<String> skuCodes; //skuCode

    private List<String> companySkuCodes;
    
    private int status; // 状态


    public List<String> getSkuCodes() {
        return skuCodes;
    }

    public void setSkuCodes(List<String> skuCodes) {
        this.skuCodes = skuCodes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public List<String> getCompanySkuCodes() {
		return companySkuCodes;
	}

	public void setCompanySkuCodes(List<String> companySkuCodes) {
		this.companySkuCodes = companySkuCodes;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
