package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtilityFile {
	
	
	
	
	public int togetRandonNumber() {
		Random ran=new Random();
		int r = ran.nextInt(1000);
		return r;
	}
	
	
	
	
	public String togetCurrentDate() {
		
		Date date = new Date();
		SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
		String currentdate = format.format(date);
		return currentdate;
						
	}
	
	
	
	public String togetExpectedCloseDate(int days) {
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	format.format(date);
Calendar cal = format.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,days);
String datereq = format.format(cal.getTime());
return datereq;

	
		
		
		
		
	}

}
