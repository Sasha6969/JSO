package WS2;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Register.textToList();
		int menuChoice = 0;
		while (menuChoice != 6) {
			menuChoice = menu();
			switch (menuChoice) {
			case 1:
				Register.regMember();
				Register.regMemberTxt();
				break;
			case 2:
				Register.regBoat();
				Register.regBoatTxt();
				break;
			case 3:
				showInfo();
				break;
			case 4:
				System.out.println("Change info");
				break;
			case 5:
				deleteInfo();
				break;
			case 6:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			case 7:
				Register.clearData();
				System.out.println("....Data Cleared");
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
		System.out.println("| 1. Create a Member                |");
		System.out.println("| 2. Register Boat             	    |");
		System.out.println("| 3. Show Information               |");
		System.out.println("| 4. Change Information	 	    |");
		System.out.println("| 5. Delete Information	 	    |");
		System.out.println("| 6. Exit			    |");
		System.out.println("|-----------------------------------|");
		System.out.print("Enter a number: ");

		menuChoice = sc.nextInt();

		return menuChoice;
	}
	
	public static void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("\t--Show Information--\n");
		System.out.println("Choose an option from below");
		System.out.println("  1. Show Members List");
		System.out.println("  2. Show Members Info");
		System.out.print("\nEnter a number: ");
		
		int choice3 = sc.nextInt();

		if (choice3 == 1) {
			System.out.println("\nChoose a List");
			System.out.println("1. Compact List");
			System.out.println("2. Verbose List");
			System.out.print("\nEnter a number: ");
			int list = sc.nextInt();

			if (list == 1) {
				Register.printCompactList();
			}
			if (list == 2) {
				Register.printVerboseList();
			}
		}
		if (choice3 == 2) {
			Register.specMemInfo();
		}
	return;
	}
	
	public static void deleteInfo() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\tDelete Information\n");
		System.out.println("1. Delete Member");
		System.out.println("2. Delete Boat");
		System.out.println("Enter Number: ");
		int di = sc.nextInt();
		if (di==1) {
			Register.deleteMem();
		}
		if (di==2) {
			Register.deleteBoat();
		}
	return;
	}
}
