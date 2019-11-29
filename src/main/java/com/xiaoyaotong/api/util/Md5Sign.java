package com.xiaoyaotong.api.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/13 17:25
 */
public class Md5Sign {

    public static String getMD5String(String str,String key) {
    	MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			return  byte2hex(md.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
    }
    
	/**
	* 二进制转字符串
	*/
	private static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
	         hs.append(stmp);
		}
		return hs.toString();
	}
}
