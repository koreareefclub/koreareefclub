package module6;

public class Date {
	private int month; 
    private int day;
    private int year;
    public Date() 
    {
        month = 0; 
        year = 0;
        day = 0;
    }
    public int setDay( int dayOfMonth, int monthOfYear, int whichYear ) 
    {
    	if ((dayOfMonth > 31) || (dayOfMonth <1))
    	{
    		throw new RuntimeException("Invalid day");
    	}
        day = dayOfMonth;
    
    	if ((monthOfYear > 12) || (monthOfYear <1))
    	{
    		throw new RuntimeException("Invalid day");
    	}
        month = monthOfYear;
    
    	if ((whichYear > 2020) || (whichYear <1900))
    	{
    		throw new RuntimeException("Invalid year");
    	}
        year = whichYear;
        
        int date = 10000 * year + 100 * month + day;
        return date;
    }

}
