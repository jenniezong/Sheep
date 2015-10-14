package concurrency.dateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilLocalVar {

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static Date parse(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(strDate);
	}
}
