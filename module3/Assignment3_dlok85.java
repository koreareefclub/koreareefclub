package module3;
import java.util.Scanner;

public class Assignment3_dlok85 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			int option;
			System.out.print("1 or 2");
			option = sc.nextInt();
			sc.close();
			int i = 10;
			int j = 1;
			
			switch (option)
			{
			
				case 1:
					while (i > 0)
					{
						int k = i;
						int[] firstArray;
						while (k > 0) 
							firstArray = new int[k];
							System.out.println(firstArray);
							--k;
					--i;
					}
				case 2:
					while (j <= 10)
					{
						int l = j;
						while (l > 0)
							System.out.println("+");
							--l;
					++j;
					}
					
				default:
					{
						System.out.print("Enter only 1 or 2");
						break;
					}
			}
		}
	}
			
}
