package no.machina.utils;

import org.apache.commons.lang.time.FastDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
public class DateUtils {

	private static FastDateFormat df = FastDateFormat.getInstance("dd-MM-yyyy");
	private static SimpleDateFormat dp = new SimpleDateFormat("dd-MM-yyyy");

	public String format(Date date){
		return df.format(date);
	}


	public synchronized Date parse(String str) throws java.text.ParseException{
		return dp.parse(str);
	}

}
