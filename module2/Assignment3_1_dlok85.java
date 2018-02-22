package module2;

import java.util.Scanner;

public class Assignment3_1_dlok85 {

	public static void main(String[] args) {
		{
            Scanner sc = new Scanner(System.in); // scanner class to read the data from the user
            System.out.println("Enter the type of presentation desired for the pyramid of asteriks : ");
            System.out.println("\n1. Forward Pyramid of asteriks.");
            System.out.println("\n2. Backward Pyramid of asteriks.\n");
            int choice = sc.nextInt(); // getting the choice entered by the user
            sc.close();
            
            if (choice == 1) { // if choice is 1
                System.out.println("\nEnter the maximum number of asteriks allowed in one line for a forward pyramid : ");
                int number = sc.nextInt();
                System.out.println("\n");
                for (int x = 1; x <= number; x++) { // loop to print the symbols
                    for (int y = 1; y <= x; y++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if (choice == 2) { // if choice is 2
                System.out.println("\nEnter the maximum number of asteriks allowed in one line for a backward pyramid : ");
                int number1 = sc.nextInt();
                System.out.println("\n");
                for (int i = number1; i >= 0; i--) { // loop to print the symbols
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else { // if choice is invalid then, prompt the user to input the value again
                System.out.println("\nInvalid Choice !!!");
            }
        }

	}

}
