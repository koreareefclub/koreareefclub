package module3;


import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class test {
	public static void main(String arg[])
    {
		int year= 2018;
		int month= 2;
		Calendar cal = new GregorianCalendar();
		
		// set its date to the first day of the month/year given by user
        cal.clear();
        cal.set(year, month - 1, 1);
        
        System.out.println(cal.getDisplayName(Calendar.MONTH, Calendar.LONG) + " " + cal.get(Calendar.YEAR));
	}}