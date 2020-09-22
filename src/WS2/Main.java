package WS2;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\t   Welcome to the Yacht club");
		System.out.println("\t\t-----MENU-----\n");
		System.out.println("Choose an option from below");
		System.out.println("1. Create");
		System.out.println("2. Retrieve");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Help\n");
		System.out.print("Enter a number: ");
		int jatin;
		
		boolean validInput=false;
		while(!validInput) {
		try {
			int menuChoice = sc.nextInt();
			validInput=true;

			switch (menuChoice) {
			case 1:
				
				Scanner scan = new Scanner(System.in);
				String name;
				String persNum;
			
				System.out.println("\n\t--Create a member--");
			
				System.out.print("\nEnter Full Name: ");
				name = scan.nextLine();		
			
				System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
				persNum = scan.next();
				int uniqueId = (int) (System.currentTimeMillis() & 0xffffff);//generate unique id
				Member one = new Member(name, uniqueId, persNum);
				System.out.println("\nMember "+one.getName()+" has been created");
				System.out.println("Your PN: "+one.getPN());
				System.out.println("Your UID: "+one.getUID());
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
		}catch(InputMismatchException ime) {
			System.out.print("Enter a Valid Number: ");
			sc.nextLine();
			continue;
			}
		}
	}
}
