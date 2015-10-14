package concurrency.dateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilSync {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static String format(Date date) {
		synchronized (date) {
			return sdf.format(date);
		} 
	}
	
	public static Date parse(String strDate) throws ParseException {
		synchronized (sdf) {
			return sdf.parse(strDate);
		}
	}
	
}
