package WS2;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter PN(YYMMDDXXXX): ");
		long pn = sc.nextLong();
		
		int uid = 0001;
		
		Member one = new Member(name, uid, pn);
		
		System.out.println("Hi "+one.getName());
		System.out.println("Your PN is "+one.getPN());
		System.out.println("Your UID is "+one.getUID());
		
	}
}
