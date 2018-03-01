package module4;
import java.util.Scanner;

public class discussion4 {

  public static void main( String [] args )

  {

    int userChoice = 0;// User selection: 1, 2, 3

       // Create a Scanner to obtain user input
    System.out.print( "Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: " );
    Scanner input = new Scanner( System.in );  
    userChoice = input.nextInt(); 

    if( userChoice<= 3 && userChoice>=1 )

    
	      switch( userChoice )
	
	      {
	
	        case 1: 
	        	System.out.print( "Enter a Fahrenheit temperature: " );
	        	Scanner TF = new Scanner( System.in ); 
		        float temperatureFahrenheit = TF.nextFloat();
		        FtoC(temperatureFahrenheit);
		        
		    case 2: 
		        System.out.print( "Enter a Celsius temperature: " );
		        Scanner TC = new Scanner( System.in ); 
	        	float temperatureCelsius = TC.nextFloat();
	        	CtoF(temperatureCelsius);
	        case 3: Exit();
	      }
	  else
	      System.out.println( "Invalid Data: You must enter 1, 2, or 3" );
      
    
  }

  
        public static void FtoC (float temperatureFahrenheit) {
        	
            float temperatureCelsius = 5F/9F * ( temperatureFahrenheit - 32F );

            String Celcius = temperatureFahrenheit + " degrees Fahrenheit is " + temperatureCelsius + " degrees Celsius" ;
            System.out.print(Celcius);
            return;
        }

        public static void CtoF (float temperatureCelsius) {
        	
            float temperatureFahrenheit = 9F/5F * temperatureCelsius + 32F;

            String Fahrenheit = temperatureCelsius + " degrees Celsius is " + temperatureFahrenheit + " degrees Fahrenheit"; 
            System.out.print(Fahrenheit);
            return;
        }    

        public static void Exit () {
        	System.out.print("Bye Bye");
            return;
            
            

            }


  }