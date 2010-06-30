/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

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
