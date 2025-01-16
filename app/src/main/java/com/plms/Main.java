package com.plms;
import java.util.Scanner;

public class Main{
		public static void main(String[] args) {
				
				// Display welcome message
				System.out.println("Welcome to PLMS!");
				System.out.println("=========================");
				
				// initialize selction before loop start
				int selection = 0;

				// creat a Scanner object
				Scanner scanner = new Scanner(System.in);

				//loop as long as selection is not to quit
				while(selection != 3){
						// Display menu
						System.out.println("1. View Library");
						System.out.println("2. Add Book to Library");
						System.out.println("3. Quit");
						System.out.print("[1-3]: ");

						// capture and validate selection
						if (scanner.hasNextInt()){
								selection = scanner.nextInt();
								scanner.nextLine();
						} else {
								System.out.println("Invalid input! Please enter a number between 1 and 3.");
								scanner.nextLine();
								continue;
						}

						// determine selection
						switch (selection) {
								case 1:
										System.out.println("You Selected 1");
										break;
								case 2:
										System.out.println("You Selected 2");
										break;
								case 3:
										System.out.println("Goodbye!");
										break;
								default:
										System.out.println("Invalid selection!");
						}
				}
				// close the scanner
				scanner.close();
		}
}
