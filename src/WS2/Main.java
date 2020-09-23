package WS2;

import java.io.IOException;
import java.util.*;

public class Main {

	


	public static void main(String[] args) throws IOException {

		
		int menuChoice = 0;
		while (menuChoice!=5) {
			menuChoice = menu();
			switch (menuChoice) {
			case 1:
				Register.regMember();
				break;

			case 2:
				Register.regBoatTxt();
				break;
			case 3:
				System.out.println("you entered 3\n");
				break;
			case 4:
				System.out.println("you entered 4\n");
				break;
			case 5:
				System.out.println("You have exited the program\n");

			case 0:
				Register.regMemberTxt();
				break;
			}
		}
	}

	public static int menu() {
		
		Scanner sc = new Scanner(System.in);
		int menuChoice = 0;
		
		System.out.println("\t   Welcome to the Yacht club");
		System.out.println("\t\t-----MENU-----\n");
		System.out.println("Choose an option from below");
		System.out.println("1. Create");
		System.out.println("2. Retrieve");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Help");
		System.out.println("0. Exit");
		System.out.print("Enter a number: ");
		
		menuChoice = sc.nextInt();
		
		return menuChoice;
	}
}
