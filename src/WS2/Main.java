package WS2;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int uid = 0000;
		
		System.out.println("\t   Welcome to the Yacht club");
		System.out.println("\t\t-----MENU-----\n");
		System.out.println("Choose an option from below");
		System.out.println("1. Create");
		System.out.println("2. Retrieve");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Help\n");
		System.out.print("Enter a number: ");
		
		int menuChoice = sc.nextInt();
		
		try {
			switch (menuChoice) {
			case 1:
				Scanner scan = new Scanner(System.in);
				String name;
				int persNum;
			
				System.out.println("\n\t--Create a member--");
			
				System.out.print("Enter the Full Name: ");
				name = scan.nextLine();		
			
				System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
				persNum = scan.nextInt();
			
				Member one = new Member(name, uid, persNum);
				System.out.println("Member "+one.getName()+" has been created");
			
				uid++;
				break;
			case 2:
				System.out.println("you entered 2");
				break;
			case 3:
				System.out.println("you entered 3");
				break;
			case 4:
				System.out.println("you entered 4");
				break;
			case 5:
				System.out.println("you entered 5");
				break;
			}
		}catch(Exception es) {
			System.out.print("Enter a Valid Number: ");
			menuChoice = sc.nextInt();
		}
	}	
}
