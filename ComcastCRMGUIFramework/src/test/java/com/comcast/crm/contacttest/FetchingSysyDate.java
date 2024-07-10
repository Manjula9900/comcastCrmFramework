package com.comcast.crm.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FetchingSysyDate 
{
	public static void main(String[] args) {
		Date dateObj = new Date();
		//date format what we want
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String actdate=sim.format(dateObj);
		System.out.println(actdate);
	    Calendar	cal =sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH, 30); // before date -30
	    String daterequires= sim.format(cal.getTime());
		System.out.println(daterequires);
		
		
	}

}
