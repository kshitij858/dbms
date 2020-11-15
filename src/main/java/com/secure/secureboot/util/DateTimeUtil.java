package com.secure.secureboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DateTimeUtil {
	
	public String getCurrentDateTime(String format) {
        SimpleDateFormat localDateTimeFormat = new SimpleDateFormat(format);
        localDateTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String dateTime = localDateTimeFormat.format(new Date());
        return dateTime;
    }

	public DateTimeUtil() {
		// TODO Auto-generated constructor stub
	}

}
