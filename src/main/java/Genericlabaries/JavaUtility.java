package Genericlabaries;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber(){
		
		Random random=new Random();
		   int randomNumber=random.nextInt(5000);
		   return randomNumber;
	}
	
	public String getSystemdateYYYDDMM() {
		
		Date dateobj=new Date();
		SimpleDateFormat sat=new SimpleDateFormat("yyy-MM-DD");
	String	date=sat.format(dateobj);
	 return date;
	}
	
	
	public String getDateMMDDYYYY( int number,String date   ) {
		
		LocalDate localDate=LocalDate.now();
		LocalDate formatdate=localDate.plusDays(number);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern(date);
		String futuredate=formatdate.format(formatter);
		return futuredate;
		
	}
	
  public String getRequriedDateyyyDDMM() {
	  SimpleDateFormat sim=new SimpleDateFormat("yyy-MM-dd");
	 
	 
	 Calendar cal=sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH,30);
	 String endDate=sim.format(cal.getTime());
	 return endDate;
	  }

public String getRequriedDateYYDDMM() {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
