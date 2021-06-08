package motyl.utility;


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

	
}
