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
				Register.regMemberTxt();
				break;
			case 2:
				Register.regBoat();
				break;
			case 3:
				Register.showInfo();
				break;
			case 4:
				System.out.println("you entered 4\n");
				break;
			case 5:
				System.out.println("Saving and Exiting...\n");
				break;
			case 0:
				Register.regMemberTxt();
				break;
			}
		}
	}

	public static int menu() {
		
		Scanner sc = new Scanner(System.in);
		int menuChoice = 0;
		

		System.out.println("|-----------------------------------|");
		System.out.println("|      Welcome to the Yacht club    |");
		System.out.println("|---------------MENU----------------|");
		System.out.println("| Choose an option from below:      |");
<<<<<<< HEAD
		System.out.println("| 1. Create a Member                |");
		System.out.println("| 2. Register Boat             	    |");
		System.out.println("| 3. Show Information               |");
		System.out.println("| 4. Change Information	 	    |");
		System.out.println("| 5. Delete Information	 	    |");
		System.out.println("| 6. Exit			    |");
		System.out.println("|-----------------------------------|");
=======
		System.out.println("| 1. Create                         |");
		System.out.println("| 2. Retrieve                  	    |");
		System.out.println("| 3. Update                         |");
		System.out.println("| 4. Delete			                |");
		System.out.println("| 5. Help		 	                |");
		System.out.println("| 0. Exit			                |");
		System.out.println("-------------------------------------");
>>>>>>> bef7d4d75599dfb3ca5785e5bb0a4c4345ce079d
		System.out.print("Enter a number: ");
		
		menuChoice = sc.nextInt();
		
		return menuChoice;
	}
}
