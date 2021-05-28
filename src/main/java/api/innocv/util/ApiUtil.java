package api.innocv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ApiUtil {

	public static Date formatDate(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFormatted = formatter.parse(day + "/" + month + "/" + year);
		return dateFormatted;
	}
}
