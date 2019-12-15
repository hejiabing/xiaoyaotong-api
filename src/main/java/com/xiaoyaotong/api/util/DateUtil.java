package com.xiaoyaotong.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 */
public class DateUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
			
    /**
     * 获取当前日期是星期几<br>
     * @param dt
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return w;
    }

    /**
     * 获取当前日期是星期几<br>
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate() {
        return DateUtil.getWeekOfDate(new Date());
    }

    /**
     *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     */
    public static String strToDateFormat(String date){
        if(!StringUtils.isEmpty(date)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            formatter.setLenient(false);
            Date newDate= null;
            try {
                newDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(newDate);
        }else{
            return "";
        }
    }
    /**
     *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     */
    public static Date dateToDateFormat(String date){
        if(!StringUtils.isEmpty(date)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            formatter.setLenient(false);
            Date newDate= null;
            try {
                newDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newDate;
        }else{
           return null;
        }
    }

    /**
     * 字符串格式的日期转为日期
     * @param date 日期字符串
     * @param format 日期格式
     * @return 日期
     */
	public static String strDateToFormat(String date, String format) {
		if (!StringUtils.isEmpty(date)) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			Date newDate = null;
			try {
				newDate = formatter.parse(date);
			} catch (ParseException e) {
				logger.debug("字符串日期格式化异常：" + date + " : " + format + " " + e.getMessage());
			}
			return formatter.format(newDate);
		} else {
			return "";
		}
	}

    public static Date strToDate(String date){
        if(!StringUtils.isEmpty(date)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false);
            Date newDate= null;
            try {
                newDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newDate;
        }else{
            return null;
        }
    }

    public static String dateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        String str=null;
        try {
            str= sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    public static String dateToStrHh(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String str=null;
        try {
            str= sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    public static Date strToDateHh(String date){
        if(!StringUtils.isEmpty(date)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatter.setLenient(false);
            Date newDate= null;
            try {
                newDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newDate;
        }else{
            return null;
        }
    }
    
    /** 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    
    /** 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
    /**
     * 当前时间往后移一年
     * @param s
     * @return
     */
    public static String addOneYear(String s){
    	Calendar calendar = Calendar.getInstance();
    	
    	if(!StringUtils.isEmpty(s)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatter.setLenient(false);
            Date newDate= null;
            try {
                newDate = formatter.parse(s);
                calendar.setTime(newDate);
                calendar.add(Calendar.YEAR, 1);
                
                return formatter.format(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    	return "";
    }

    /**
     * 当前时间加一年
     * @param date
     * @return
     */
    public static Date addOneYear(Date date){
        Calendar calendar = Calendar.getInstance();
        if(date==null){
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    public static Date currentDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY , 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    

	// 有效期兼容多种格式,将字符串转化为日期
	public static Date stringToDate(String str){
		if (StringUtils.isEmpty(str) || str.length()<5) {
			return null;
		}
		str = str.trim();
		String format = new String("yyyy-MM-dd");
		if (str.indexOf("-") > 0){
			if (str.length() == 7 || str.length() == 6){
				format = "yyyy-MM";
			} else {
				format = "yyyy-MM-dd";
			}
		} else if (str.indexOf("/") > 0){
			if (str.length() == 7 || str.length() == 6){
				format = "yyyy/MM";
			} else {
				format = "yyyy/MM/dd";
			}
		} else if (str.indexOf(".") > 0){
			if (str.length() == 7 || str.length() == 6){
				format = "yyyy.MM";
			} else {
				format = "yyyy.MM.dd";
			}
		} else {
			if (str.length() == 6 || str.length() == 5){
				format = "yyyyMM";
			} else {
				format = "yyyyMMdd";
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			logger.error("时间转换出错"+e.getMessage());
		}
		return date;
	}

	public static Integer getOffsetMonth(String deadLine) {
		Date deadDate = stringToDate(deadLine);
		Long month = (deadDate.getTime()- new Date().getTime())/1000/3600/24/30;
		return month.intValue();
	}
}
