package practicetest;

import java.util.Date;

public class CaptureTimestamp 
{
	public static void main(String[] args) 
	{
		String time = new Date().toString().replace(" ","_" ).replace(":", "_");
		//complete info we can't pass special character on file path 
		System.out.println(time);
	}

}
