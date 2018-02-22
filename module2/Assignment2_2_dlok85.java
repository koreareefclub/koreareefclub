package module2;

import java.util.Scanner;

public class Assignment2_2_dlok85 {

	public static void main(String[] args) {
		 // Define and initialize variables for values to be input
        double height;      // First value to be input
        double weight;      // Second value to be input


        // Use a Scanner to input integer values
        Scanner input = new Scanner ( System.in );
        System.out.println( "Body Mass Calculator" );
        System.out.println( "\n" );
        System.out.println( "Enter height in inches:" );
        height = input.nextInt();     // Input first value
        System.out.println( "Enter weight in pounds:" );
        weight = input.nextInt();     // Input second value
        input.close();
        
        double heightm = height * 0.0254;
        double weightkg = weight * 0.45359237;
        double bmi = weightkg / (Math.pow(heightm, 2));
        System.out.println( "Body Mass Index:" + bmi );
        
        // Output using System.out.println()
        System.out.println( "\n" );
        System.out.println( "\t" + "Underweight: less than 18.5");
        System.out.println( "\t" + "Normal: 18.5 - 24.9");
        System.out.println( "\t" + "Overweight: 25 - 29.9");
        System.out.println( "\t" + "Obese: 30 or greater");


	}

}
