package WS2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	
	static ArrayList<Member> memList=new ArrayList<>();
	private static File memFile = new File("Members.txt");
	//private static File boatFile = new File("Boats.txt");
	
	
	public static void regMember()
{
			Scanner sc = new Scanner(System.in);		
			System.out.println("\n\t--Create a member--");
		
			System.out.print("\nEnter Full Name: ");
			String name = sc.nextLine();		
		
			System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
			String persNum = sc.next();
			
			int uniqueId = (int) (System.currentTimeMillis() & 0xffffff);//generate unique id
			
			Member temp = new Member(name, uniqueId, persNum);
			memList.add(temp);
			
			System.out.println("\nMember "+temp.getName()+" has been created");
			System.out.println("Your PN: "+temp.getPN());
			System.out.println("Your UID: "+temp.getUID());

}
	public static void regMemberTxt() throws IOException
	{
		if(!memFile.exists()) {
			memFile.createNewFile();
			try {
				for(Member m: memList)
				{ FileWriter myWriter = new FileWriter(memFile.getPath());//To get path of the file
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
				{ FileWriter myWriter = new FileWriter(memFile.getPath());
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
