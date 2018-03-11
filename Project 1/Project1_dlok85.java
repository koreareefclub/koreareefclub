package module4;
import java.util.Scanner;
public class Project1_dlok85 {
	 static void displayModule(char array[][])
	    {
	        for(int i = 0; i < array.length; i++)
	        {
	            for(int j = 0; j < array[i].length; j++)
	            {
	                System.out.print(array[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    public static void main(String args[])
	    {
	        int rows, columns;
	        int cursorRow = 0,  noOfEats = 0, curCol = 0, noOfCommands = 0;
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Give the no. of rows & columns: ");
	        rows = sc.nextInt();
	        columns = sc.nextInt();
	        char array[][] = new char[rows][columns];
	        int noOfCookies = (int)(0.15 * rows * columns);
	        for(int i = 0; i < rows; i++)
	        {
	            for(int j = 0; j < columns; j++)
	            {
	                array[i][j] = '.';
	            }
	        }
	        array[0][0] = '<';
	        for(int i = 0; i < noOfCookies; i++)
	        {
	            int R = (int)(Math.random() * rows);
	            int C = (int)(Math.random() * columns);
	            if(array[R][C] == '.') array[R][C] = 'O';
	            else i--;
	        }
	        while(true)
	        {
	            int moves;
	            displayModule(array);
	            do
	            {
	                System.out.print("Enter 1: Turn left\nEnter 2: Turn right\nEnter 3: Move\nEnter 4: Exit\n");
	                moves = sc.nextInt();
	                
	                if(moves < 1 || moves > 4)
	                    System.out.println("Command Invalid");
	            }
	            while(moves < 1 || moves > 4);
	            switch(moves)
	            {
	                case 1:
	                    if(array[cursorRow][curCol] == '<')
	                        array[cursorRow][curCol] = 'v';
	                    else if(array[cursorRow][curCol] == 'v')
	                        array[cursorRow][curCol] = '>';
	                    else if(array[cursorRow][curCol] == '>')
	                        array[cursorRow][curCol] = '^';
	                    else if(array[cursorRow][curCol] == '^')
	                        array[cursorRow][curCol] = '<';
	                        noOfCommands++;
	                    break;
	                case 2:
	                    if(array[cursorRow][curCol] == '<')
	                        array[cursorRow][curCol] = '^';
	                    else if(array[cursorRow][curCol] == 'v')
	                        array[cursorRow][curCol] = '<';
	                    else if(array[cursorRow][curCol] == '>')
	                        array[cursorRow][curCol] = 'v';
	                    else if(array[cursorRow][curCol] == '^')
	                        array[cursorRow][curCol] = '>';
	                        noOfCommands++;
	                        displayModule(array);
	                    break;
	                case 3:
	                    if(array[cursorRow][curCol] == '<')
	                    {
	                        if(array[cursorRow].length > curCol + 1)
	                        {
	                            array[cursorRow][curCol] = ' ';
	                            if(array[cursorRow][curCol + 1] == 'o')
	                                noOfCookies++;
	                            	System.out.println("Ate one cookie, totalling "+noOfCookies+" so far!");
	                                array[cursorRow][curCol + 1] = '<';
	                                array[cursorRow][curCol] = '.';
	                                curCol++;
	                                noOfCommands++;
	                        }
	                    }
	                    else if(array[cursorRow][curCol] == 'v')
	                    {
	                        if(cursorRow >= 0)
	                        {
	                            array[cursorRow][curCol] = ' ';
	                            if(array[cursorRow - 1][curCol] == 'o')
	                                noOfCookies++;
	                            	System.out.println("Ate one cookie, totalling "+noOfCookies+" so far!");
	                                array[cursorRow - 1][curCol] = 'v';
	                                array[cursorRow][curCol] = '.';
	                                cursorRow--;
	                                noOfCommands++;
	                        }
	                    }
	                    else if(array[cursorRow][curCol] == '>')
	                    {
	                        if(curCol >= 0)
	                        {
	                            array[cursorRow][curCol] = ' ';
	                            if(array[cursorRow][curCol - 1] == 'o')
	                                noOfCookies++;
	                            	System.out.println("Ate one cookie, totalling "+noOfCookies+" so far!");
	                            array[cursorRow][curCol - 1] = '>';
	                            array[cursorRow][curCol] = '.';
	                            curCol--;
	                            noOfCommands++;
	                        }
	                    }
	                    else if(array[cursorRow][curCol] == '^')
	                    {
	                        if(array.length > cursorRow + 1)
	                        {
	                            array[cursorRow][curCol] = ' ';
	                            if(array[cursorRow + 1][curCol] == 'o')
	                                noOfCookies++;
	                            	System.out.println("Ate one cookie, totalling "+noOfCookies+" so far!");
	                                array[cursorRow + 1][curCol] = '^';
	                                array[cursorRow][curCol] = '.';
	                                cursorRow++;
	                                noOfCommands++;
	                        }
	                    }
	                    break;
	                case 4:
	                    System.out.println("No. of Moves: " + noOfCommands);
	                    System.out.println("No. of cookies: " + noOfCookies);
	                    return;
	                default:
	                	System.out.println("Wrong move!");
	                    break;
	            
	            }
	            System.out.println();
	        }
	    }

}
