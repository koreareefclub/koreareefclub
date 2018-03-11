package module6;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	int numEmployees;	
	Assignment6_dlok85 mainclass = new Assignment6_dlok85();
	
	
	public void finalMethod()
    {
	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	Scanner input = new Scanner(System.in);

    System.out.println( "How many employees do you wish to enter?" );
    numEmployees = input.nextInt();
	
		for ( int i = 0; i < numEmployees; i++ ) 
	    {
	        Name e1 = new Name();
	        Address e3 = new Address();
	        Date e4 = new Date();
	        
	        System.out.println( "Enter the name of the employee" );
	        String fullname = input.nextLine();
	        e1.setFirstName( fullname );

	        System.out.println( "" );
	        String NA = input.nextLine();

	        System.out.println( "Enter the address of the employee" );
	        String address = input.nextLine();
	        e3.setAddress(address);
	        
	        System.out.println( "Enter the start day of the employee");
	        int day = input.nextInt();
	        System.out.println( "Enter the start month of the employee");
	        int month = input.nextInt();
	        System.out.println( "Enter the start year of the employee");
	        int year = input.nextInt();
	        int date = e4.setDay(day, month, year);
	        Integer intInstance = new Integer(date);
	        String stringdate = intInstance.toString();
	        
	        ArrayList<String> employeeArray = new ArrayList<String>();
	        employeeArray.add(address);
	        employeeArray.add(stringdate);
	        
	        
	        
	        
	        map.put(fullname, employeeArray);
	        
	
	    }
		
		for(Map.Entry<String, ArrayList<String>> e : map.entrySet())
	    {
	        System.out.println(e.getKey()+": "+e.getValue());
	    }
		
	}
}
