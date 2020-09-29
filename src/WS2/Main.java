package WS2;

import java.io.IOException;
import java.util.*;

public class Main {

    public static Register reg = new Register();

    public static void main(String[] args) throws IOException {
        reg.textToList();
        int menuChoice = 0;
        while (menuChoice != 6) {
            menuChoice = menu();
            switch (menuChoice) {
                case 1:
                    reg.regMember();
                    reg.regMemberTxt();
                    break;
                case 2:
                	reg.regBoat();
                	reg.regBoatTxt();
                    break;
                case 3:
                    showInfo();
                    break;
                case 4:
                    updateInfo();
                    break;
                case 5:
                    deleteInfo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                case 7:
                    reg.clearData();
                    System.out.println("....Data Cleared");
                    break;
            }
        }
    }

    public static int menu() {

        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        while (true) {
            try {
                System.out.println("|-----------------------------------|");
                System.out.println("|      Welcome to the Yacht club    |");
                System.out.println("|---------------MENU----------------|");
                System.out.println("| Choose an option from below:      |");
                System.out.println("| 1. Create a Member                |");
                System.out.println("| 2. Register Boat             	    |");
                System.out.println("| 3. Show Information               |");
                System.out.println("| 4. Update Information	 	    |");
                System.out.println("| 5. Delete Information	 	    |");
                System.out.println("| 6. Exit			    |");
                System.out.println("|-----------------------------------|");
                System.out.print("Enter a number: ");
                menuChoice = sc.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Error, Please Enter a Valid Number: ");
                sc.next();
            }
            return menuChoice;
        }
    }

        public static void showInfo () {
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
                    reg.printCompactList();
                }
                if (list == 2) {
                    reg.printVerboseList();
                }
            }
            if (choice3 == 2) {
                reg.specMemInfo();
            }
            return;
        }

        public static void deleteInfo () throws IOException {

            Scanner sc = new Scanner(System.in);
            System.out.println("\t--Delete Information--\n");
            System.out.println("1. Delete Member");
            System.out.println("2. Delete Boat");
            System.out.println("Enter Number: ");
            int di = sc.nextInt();
            if (di == 1) {
                reg.deleteMem();
            }
            if (di == 2) {
                reg.deleteBoat();
            }
            return;
        }

        public static void updateInfo () throws IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("\t--update Information--\n");
            System.out.println("Choose an option from below");
            System.out.println("  1. Update Member");
            System.out.println("  2. Update Boat");
            System.out.print("\nEnter a number: ");
            int info = sc.nextInt();

            if (info == 1) {
                reg.updateMemInfo();
            }
            if (info == 2) {
                reg.updateBoat();
            }


        }
    }
