package com.comcast.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtlity 
{
	public int getRandomNumber()
	{
		Random random = new Random();
	    int randomNumber	=random.nextInt(5000);
	    return randomNumber;	
	}
	public String getSytemDateYYYYDDMM()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DAY_OF_MONTH, days);
	        return sdf.format(cal.getTime());	
	}

}
