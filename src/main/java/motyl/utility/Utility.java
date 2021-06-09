package motyl.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utility {

	/* ********************************************************************************* *
	 *                                                                                   *
	 * ********************************************************************************* */
	public static boolean containsAnEmptyValue(String... values)
	{
		for(String value:values)
		{
			if(value == null || value.trim().isEmpty())
			{
				return true;
			}
		}
		return false;
		
	}
	
	/* ********************************************************************************* *
	 *                                                                                   *
	 * ********************************************************************************* */
	public static String upperCaseFirstLetter(String string) {
		
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}

	
	/* ********************************************************************************* *
	 *                                                                                   *
	 * ********************************************************************************* */
	public static int daysBetweenTwoDates(Date initDate, Date endDate) {
		
	    long diff = endDate.getTime() - initDate.getTime();
	    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		return Math.toIntExact(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		
	}


	/* ********************************************************************************* *
	 *                                                                                   *
	 * ********************************************************************************* */
	public static String formmatingDate(Date date) {
		
		return new SimpleDateFormat("dd MMM yyyy").format(date);
		
	}
	
}
