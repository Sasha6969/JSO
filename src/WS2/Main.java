package WS2;
import java.io.IOException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {			
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
				
				boolean validInput=false;
				while(!validInput) {
				try {
					int menuChoice = sc.nextInt();
					validInput=true;

					switch (menuChoice) {
					case 1:
						Register.regMember();
						Register.regMemberTxt();
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
