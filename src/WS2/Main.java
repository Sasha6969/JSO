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
		
		boolean validInput=false;
		while(!validInput)
		{
		
		try {
<<<<<<< HEAD
			int menuChoice = sc.nextInt();
			validInput=true;
		switch (menuChoice) {
		
		case 1:
=======
			switch (menuChoice) {
			case 1:
				Scanner scan = new Scanner(System.in);
				String name;
				int persNum;
>>>>>>> f82932df765858cd2b4bb35c301a2fa9717c1998
			
				System.out.println("\n\t--Create a member--");
			
				System.out.print("Enter the Full Name: ");
				name = scan.nextLine();		
			
				System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
				persNum = scan.nextInt();
			
				Member one = new Member(name, uid, persNum);
				System.out.println("Member "+one.getName()+" has been created");
			
<<<<<<< HEAD
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
		}catch(InputMismatchException es) {
=======
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
>>>>>>> f82932df765858cd2b4bb35c301a2fa9717c1998
			System.out.print("Enter a Valid Number: ");
			sc.nextLine();
			continue;
			
			
		}
	}	
}
}
