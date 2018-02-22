package module3;
import java.util.Scanner;

public class Assignment3_2_dlok85 {

	public static void main(String[] args) {
		
		
		int trialCount = 1;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("set a maximum number");
		int max = sc.nextInt();
		System.out.println("How many guesses do you want to make?");
		int maxCount = sc.nextInt();
		 
		
		int randomNumber = ((int) (max * Math.random())+1);
		
		while (trialCount <= maxCount) {
			System.out.println("Guess a number between 1 and the maximum number you entered.");
			int guess = sc.nextInt();
		
			if (randomNumber == guess) {
				System.out.println("correct");
				break;
				}
				
		
			else if (randomNumber > guess ) {
				System.out.println("too low");
				trialCount ++;
				}
				
				
		    else if (randomNumber < guess ) {
				System.out.println("too high");
				trialCount ++;
				}
			
			else {
				System.out.println("Enter the correct value");}
	        }
			
		System.out.println("The game ended.");	
		sc.close();
	    }
		
	
}


