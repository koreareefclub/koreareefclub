 /****
    The method getStartDay() implements Zeller's Algorithm for determining the
    day of the week the first day of a month is. The method adjusts Zeller's
    numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform
    to a day of week number that corresponds to ISO conventions (i.e.,
    1=Monday, ..., 7=Sunday)
  
  Pre-Conditions: The month value, m,  is 1-12
                  The year value, y, is the full year (e.g., 2012)
                  
  Post-Conditions: A value of 1-7 is returned, representing the first day of
  the month: 1 = Monday, ..., 7 = Sunday
****/

package module4;
import java.util.Scanner;

public class Assignment4_dlok85 {
	public static void main(String arg[])
    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Year?");
		int year = sc.nextInt();
		System.out.println("Month?");
		int month = sc.nextInt();
		sc.close();
		
		printMonthCalendar(month, year );
		
		
    }

/////////////////////////////////////////////////////////////
	public static boolean isLeapYear (int year) {
		if ((year % 4) == 0)
        {
           if ((year % 100) == 0)
           {
              if ((year % 400) == 0)
                 return true;
              else
                 return false;
           }
           else
              return true;
        }
        return false;
	}

/////////////////////////////////////////////////////////////
	public static int getNumDaysInMonth(int month, int year) {
		int number_Of_DaysInMonth;
		
		switch (month) {
	        case 1:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 2:
	          
	            boolean leap = isLeapYear(year);
	            if (leap = false) {
	                number_Of_DaysInMonth = 29;
	            } else {
	                number_Of_DaysInMonth = 28;
	            }
	            return number_Of_DaysInMonth;
	        case 3:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 4:
	            number_Of_DaysInMonth = 30;
	            return number_Of_DaysInMonth;
	        case 5:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 6:
	            number_Of_DaysInMonth = 30;
	            return number_Of_DaysInMonth;
	        case 7:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 8:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 9:
	            number_Of_DaysInMonth = 30;
	            return number_Of_DaysInMonth;
	        case 10:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
	        case 11:
	            number_Of_DaysInMonth = 30;
	            return number_Of_DaysInMonth;
	        case 12:
	            number_Of_DaysInMonth = 31;
	            return number_Of_DaysInMonth;
		}
		return 0;
	}
	
/////////////////////////////////////////////////////////////
	public static int getStartDay( int month,  int year ) {
		
		
		final int day = 1; // Must be set to day 1 for this to work.  JRD.
	
		
        // Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 ) 
        {
          month = month + 12;
          year = year - 1;
        }
        
        int yearInCent = year % 100;      // k Calculate year within century
        int century = year / 100;      // j Calculate century term
        int firstDay  = 0;            // h Day number of first day in month 'm'
        
        firstDay = (day + (13 * (month + 1) / 5) + yearInCent +
            (yearInCent / 4) + (century / 4) + (5 * century)) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((firstDay + 5) % 7) + 1;     
        return dayNum;
        //return dayNum;

	}

/////////////////////////////////////////////////////////////
	public static String getMonthName(int month) {
		String MonthOfName;
		switch (month) {
	        case 1:
	            MonthOfName = "January";
	            return MonthOfName;
	        case 2:
	            MonthOfName = "February";
	            return MonthOfName;
	        case 3:
	            MonthOfName = "March";
	            return MonthOfName;
	        case 4:
	            MonthOfName = "April";
	            return MonthOfName;
	        case 5:
	            MonthOfName = "May";
	            return MonthOfName;
	        case 6:
	            MonthOfName = "June";
	            return MonthOfName;
	        case 7:
	            MonthOfName = "July";
	            return MonthOfName;
	        case 8:
	            MonthOfName = "August";
	            return MonthOfName;
	        case 9:
	            MonthOfName = "September";
	            return MonthOfName;
	        case 10:
	            MonthOfName = "October";
	            return MonthOfName;
	        case 11:
	            MonthOfName = "November";
	            return MonthOfName;
	        case 12:
	            MonthOfName = "December";
	            return MonthOfName;
		}
		return "none";
	}

/////////////////////////////////////////////////////////////
	public static void printMonthBody(int month, int year) {
		
		int startDay = getStartDay(year, month);

	    // Get number of days in the month
	    int number_Of_DaysInMonth = getNumDaysInMonth(month, year);
	    
	    // Pad space before the first day of the month
	    int i = 0;
	    for (i = 0; i < startDay; i++)
	    	if (startDay != 7)
	        System.out.print("    ");
	    
	    int j;
	    for (j = 1; j<= number_Of_DaysInMonth; j++) {
	    	System.out.printf("%4d", j);
	    	if ((j + startDay) % 7 == 0)
	    		System.out.println();}
	      
	}
	
/////////////////////////////////////////////////////////////
	public static void printMonthHeader(int month, int year) {
		System.out.println("         " +getMonthName(month)+ "  "+ year);
		System.out.println("------------------------------\n"+"  Sun Mon Tue Wed Thu Fri Sat");
	}	
	
/////////////////////////////////////////////////////////////	
	public static void printMonthCalendar( int month,  int year ) {
		printMonthHeader(month, year);
		printMonthBody(month, year);
		
	}
	
}
