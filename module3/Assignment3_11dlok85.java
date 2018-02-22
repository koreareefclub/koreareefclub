package module3;

import java.util.Scanner;

public class Assignment3_11dlok85 {

	public static void main(String[] args) {
		{
            Scanner sc = new Scanner(System.in); 
            
            
            System.out.println("Type 1 for decreasing number of plus signs");
            System.out.println("Type 2 for increasing number of plus signs");
            int option = sc.nextInt(); 
            
            if (option == 1) {
                System.out.println("\nWhat is the maximum number of plus signs to display?");
                int number1 = sc.nextInt();
                System.out.println("\n");
                for (int i = number1; i >= 0; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("+");
                    }
                    System.out.println();
                }
            }
                
             else if (option == 2) {
                System.out.println("\nWhat is the maximum number of plus signs to display?");
                    int number2 = sc.nextInt();
                System.out.println("\n");
                for (int x = 1; x <= number2; x++) { 
                    for (int y = 1; y <= x; y++) {
                         System.out.print("+");
                    }
                    System.out.println();
                    }
                }             
             else {
                System.out.println("\nEnter either 1 or 2");
            }
            sc.close();
        }

	}

}
