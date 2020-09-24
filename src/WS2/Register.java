package WS2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {

	private static ArrayList<Member> memList = new ArrayList<>();
	private static ArrayList<Boat> boatList = new ArrayList<>();
	private static ArrayList<Integer> tempUid = new ArrayList<>();
	private static File memFile = new File("Members.txt");
	private static File boatFile = new File("Boats.txt");

	public static void regMember() { // HELOOOOOOO
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t--Create a member--");

		System.out.print("\nEnter Full Name: ");
		String name = sc.nextLine();

		System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
		String persNum = sc.next();

		int uniqueId = (int) (System.currentTimeMillis() & 0xffffff);// generate unique id

		Member temp = new Member(name, uniqueId, persNum);
		memList.add(temp);

		System.out.println("\nMember " + temp.getName() + " has been created");
		System.out.println("Your PN: " + temp.getPN());
		System.out.println("Your UID: " + temp.getUID());
	}

	public static void regMemberTxt() throws IOException {
		if (!memFile.exists()) {
			memFile.createNewFile();
			try {
				FileWriter fileWriter = new FileWriter(memFile,true);
				BufferedWriter output = new BufferedWriter(fileWriter);
				for (Member m : memList) {
					output.write(m.getUID() + ";" + m.getName() + ";" + m.getPN() + "\n");
					System.out.println("Successfully wrote to the file.");
				}
				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter fileWriter = new FileWriter(memFile,true);
				BufferedWriter output = new BufferedWriter(fileWriter);
				for (Member m : memList) {
					output.write(m.getUID() + ";" + m.getName() + ";" + m.getPN() + "\n");
					// System.out.println("Successfully wrote to the file.");
				}
				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public static void regBoat() throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t--Register a Boat--");

		System.out.print("What is your UID: ");
		int ID = sc.nextInt();

		for (Member m : memList) {

			if (m.getUID() == ID) {

				System.out.print("How Many Boats Would Like to Register: ");
				int boats = sc.nextInt();
				m.setnOfBoats(boats);
				for (int i = 0; i < boats; i++) {
					tempUid.add(ID);
					System.out.print("\nChoose a Boat Type (1-4): ");
					System.out.println("\n1. Sailboat" + "\n2. Motorsailer" + "\n3. Kayak" + "\n4. Other");
					System.out.print("Enter Number: ");
					int type = sc.nextInt();
					System.out.print("Enter Boat Length in Meters: ");
					double length = sc.nextInt();
					
					if (type == 1) {
						Boat sail = new Boat(length, "Sailboat");
						boatList.add(sail);
					}
					if (type == 2) {
						Boat motor = new Boat(length, "Motorsailer");
						boatList.add(motor);
					}
					if (type == 3) {
						Boat kayak = new Boat(length, "Kayak");
						boatList.add(kayak);
					}
					if (type == 4) {
						Boat other = new Boat(length, "Other");
						boatList.add(other);
					}
				}
			} else {
				System.out.print("UID doesnt exist,please try again: ");
				ID = sc.nextInt();
			}
		}
	}

	public static void regBoatTxt() throws IOException {
		int i = 0;// counter for temp id

		if (!boatFile.exists()) {
			boatFile.createNewFile();
			try {
				FileWriter myWriter = new FileWriter(boatFile,true);
				BufferedWriter output = new BufferedWriter(myWriter);
				for (Boat b : boatList) {
					output.write(tempUid.get(i).toString() + ";" + b.getBoatType() + ";"
							+ Double.toString(b.getBoatLength()) + "\n");
					// System.out.println("Successfully wrote to the file.");
					i++;
				}
				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter myWriter = new FileWriter(boatFile,true);
				BufferedWriter output = new BufferedWriter(myWriter);
				for (Boat b : boatList) {
					// System.out.print( b.getBoatType());
					output.write(tempUid.get(i).toString() + ";" + b.getBoatType() + ";" + b.getBoatLength() + "\n");
					// System.out.println("Successfully wrote to the file.");
					i++;
				}
				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public static void showInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("\tShow Information\n");
		System.out.println("Choose an option from below");
		System.out.println("  1. Show Members List");
		System.out.println("  2. Show Members' Info");
		System.out.print("\nEnter a number: ");
		int choice3 = sc.nextInt();

		if (choice3 == 1) {
			System.out.println("\n1. Comapct List");
			System.out.println("2. Verbose List");
			System.out.println("Choose a List: ");
			int list = sc.nextInt();
			
			if (list == 1) {
				String comp = "";
				for (Member m : memList) {
					comp = comp.concat(m.getName() + " ").concat(Integer.toString(m.getUID()) + " ")
							.concat(Integer.toString(m.getnOfBoats()) + "\n");

				}
				System.out.print(comp + "\n");

			}
			if (list == 2) {

			}

		}
		if (choice3 == 2) {

		}

		return;
	}

	public static void clearData() throws IOException
	{
		FileWriter clearMem = new FileWriter("Members.txt", false); 
		FileWriter clearBoat = new FileWriter("Boats.txt", false); 
        PrintWriter clearMem1 = new PrintWriter(clearMem, false);
        PrintWriter  clearBoat1= new PrintWriter(clearBoat, false);
        clearMem1.flush();
        clearMem1.close();
        clearMem.close();
        clearBoat1.flush();
        clearBoat1.close();
        clearBoat.close();
	}
   //public static void 
}
