package com.h2h.configs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

//import com.google.gson.Gson;

public class EntityUtil {
	
	public BigInteger convertObjectToBigInteger(Object obj) {
		
		if(obj instanceof Long) {
			Long lng = (Long) obj;			
			return new BigInteger(new Long(lng).toString());
		} else if (obj instanceof BigInteger) {			
			return (BigInteger) obj;
		} else if (obj instanceof String) {			
			String str = (String) obj;
			return new BigInteger(str);
		} else if (obj instanceof Integer) {			
		Integer intg = (Integer) obj;
		return new BigInteger(intg.toString());
		}
		
		return new BigInteger("0");
	}
	
	public BigDecimal convertObjectToBigDecimal(Object obj) {
		
		if(obj instanceof Long) {
			Long lng = (Long) obj;			
			return new BigDecimal(new Long(lng).toString());
		} else if (obj instanceof BigDecimal) {			
			return (BigDecimal) obj;
		} else if (obj instanceof String) {			
			String str = (String) obj;
			return new BigDecimal(str);
		} else if (obj instanceof Integer) {			
		Integer intg = (Integer) obj;
		return new BigDecimal(intg.toString());
		}
		
		return new BigDecimal("0");
	}
	
	public Date convertObjectToDate(Object obj) throws ParseException {
		String strObj = (String) obj;
		
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.parse(strObj);
		
	}
	
	public Date convertObjectToDateOnly(Object obj) throws ParseException {
		String strObj = (String) obj;
		
		String pattern = "yyyy-MM-dd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.parse(strObj);
		
	}
	
//	public String convertMapToStringJSON(Map map) {
//		Gson gson = new Gson(); 
//		return gson.toJson(map); 
//	}
//	
//	public Object convertStringJSONToObject(Class cls, String strJson) {
//		Gson g = new Gson();
//		return g.fromJson(strJson, cls);		
//	}

	public Date convertObjectToDate2(Object obj) throws ParseException {
		String strObj = (String) obj;
		
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.parse(strObj);
	}
}
