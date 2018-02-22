// Author:      This program does ....
package module2;

import java.util.Scanner;


public class Assignment2_dlok85 
{
    public static void main( String [] args )
    {
		 // Define and initialize variables for values to be input
        int userNum1;      // First value to be input
        int userNum2;      // Second value to be input
        int userNum3;      // Third value to be input
        int userNum4;      // Fourth value to be input
        int userNum5;      // Fifth value to be input
        int userNum6;      // Sixth value to be input

        // Use a Scanner to input integer values
        Scanner input = new Scanner ( System.in );
        System.out.println( "\n\n" );
        System.out.println( "Enter 6 integers separated by a blank space:" );
        userNum1 = input.nextInt();     // Input first value
        userNum2 = input.nextInt();     // Input second value
        userNum3 = input.nextInt();     // Input third value
        userNum4 = input.nextInt();     // Input fourth value
        userNum5 = input.nextInt();     // Input fifth value
        userNum6 = input.nextInt();     // Input sixth value
        input.close();
        
        int total1 = userNum1 + userNum2;
        int total2 = userNum3 + userNum4;
        int total3 = userNum5 + userNum6;
        int total4 = userNum1 + userNum3 + userNum5;
        int total5 = userNum2 + userNum4 + userNum6;
        int total6 = total1 + total2 + total3;
        
        // Output using System.out.println()
        System.out.println( "\n\n" );
        System.out.println( "\t" + "Value" + "\t" + "Value" + "\t" + "Total");
        System.out.println( "\t" + userNum1 + "\t" + userNum2 + "\t" + total1);
        System.out.println( "\t" + userNum3 + "\t" + userNum4 + "\t" + total2);
        System.out.println( "\t" + userNum5 + "\t" + userNum6 + "\t" + total3);
        System.out.println( "\t" + "----" + "\t" + "----" + "\t" + "----");
        System.out.println( "Total" + "\t" + total4 + "\t" + total5 + "\t" + total6);
        System.out.println( "\n\n" );
    }
}


