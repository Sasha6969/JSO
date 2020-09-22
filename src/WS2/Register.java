package WS2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	
	static ArrayList<Member> memList=new ArrayList<>();
	private static File memFile = new File("Members.txt");
	private static File boatFile = new File("Boats.txt");
	
	
	public static void regMember()
{
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
			memList.add(one);
			System.out.println("\nMember "+one.getName()+" has been created");
			System.out.println("Your PN: "+one.getPN());
			System.out.println("Your UID: "+one.getUID());
			scan.close();
}
	public static void regMemberTxt() throws IOException
	{
		if(!memFile.exists()) {
			memFile.createNewFile();
			try {
				for(Member m: memList)
				{ FileWriter myWriter = new FileWriter("Members.txt");
			      myWriter.write(m.getName()+";"+m.getPN()+";"+m.getUID()+"\n");
			      
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    }} catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		} else {
			try {
				for(Member m: memList)
				{ FileWriter myWriter = new FileWriter("Members.txt");
			      myWriter.write(m.getName()+";"+m.getPN()+";"+m.getUID()+"\n");
			      
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    }} catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		}

		
	}
	
	
}
