package WS2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {

	private static ArrayList<Member> memList = new ArrayList<>();
	private static File memFile = new File("Members.txt");
	private static File boatFile = new File("Boats.txt");

	public static void regMember() { // HELOOOOOOO0
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t--Create a member--");

		System.out.print("\nEnter Full Name: ");
		String name = sc.nextLine();

		System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
		String persNum = sc.next();

		int uniqueId = (int) (System.currentTimeMillis() & 0xffffff);// generate unique id

		Member temp = new Member(uniqueId, name, persNum);
		memList.add(temp);

		System.out.println("\nMember " + temp.getName() + " has been created");
		System.out.println("Your PN: " + temp.getPN());
		System.out.println("Your UID: " + temp.getUID());
	}

	public static void regMemberTxt() throws IOException {
		if (!memFile.exists()) {
			memFile.createNewFile();
			try {
				// FileWriter fileWriter = new FileWriter(memFile,true);
				FileWriter fileWriter = new FileWriter(memFile);
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
				FileWriter fileWriter = new FileWriter(memFile);
				BufferedWriter output = new BufferedWriter(fileWriter);
				for (Member m : memList) {
					output.write(m.getUID() + ";" + m.getName() + ";" + m.getPN() + "\n");
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

				for (int j = 0; j < boats; j++) {
					System.out.print("\nChoose a Boat Type (1-4): ");
					System.out.println("\n1. Sailboat" + "\n2. Motorsailer" + "\n3. Kayak" + "\n4. Other");
					System.out.print("Enter Number: ");
					int type = sc.nextInt();
					System.out.print("Enter Boat Length in Meters: ");
					double length = sc.nextDouble();
					if (type == 1) {

						m.registerBoat(length, "SailBoat");
					}
					if (type == 2) {
						m.registerBoat(length, "MotorSailer");
					}
					if (type == 3) {
						m.registerBoat(length, "Kayak");

					}
					if (type == 4) {
						m.registerBoat(length, "Other");
					}
				}
			}
		}
	}

	public static void regBoatTxt() throws IOException {
		// int i = 0;// counter for temp id

		if (!boatFile.exists()) {
			boatFile.createNewFile();
			try {
				FileWriter myWriter = new FileWriter(boatFile.getPath());
				Writer output = new BufferedWriter(myWriter);
				for (Member m : memList) {
					if (m.getNoOfBoats() != 0) {// To store only if the member has boats
						for (Boat b : m.getBoatList())
							output.write(Integer.toString(m.getUID()) + ";" + b.getBoatType() + ";"
									+ Double.toString(b.getBoatLength()) + "\n");

						// i++;
					}
				}

				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter myWriter = new FileWriter(boatFile.getPath());
				Writer output = new BufferedWriter(myWriter);
				for (Member m : memList) {
					if (m.getNoOfBoats() != 0) {// To store only if the member has boats
						for (Boat b : m.getBoatList())
							output.write(Integer.toString(m.getUID()) + ";" + b.getBoatType() + ";"
									+ Double.toString(b.getBoatLength()) + "\n");
					}
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
		System.out.println("  2. Show Members Info");
		System.out.print("\nEnter a number: ");
		int choice3 = sc.nextInt();

		if (choice3 == 1) {
			System.out.println("\n1. Compact List");
			System.out.println("2. Verbose List");
			System.out.println("Choose a List: ");
			int list = sc.nextInt();

			if (list == 1) {
				printCompactList();
			}
			if (list == 2) {
				printVerboseList();

			}

		}
		if (choice3 == 2) {
			specMemInfo();

		}

		return;
	}

	public static void clearData() throws IOException {
		FileWriter clearMem = new FileWriter("Members.txt", false);
		FileWriter clearBoat = new FileWriter("Boats.txt", false);
		PrintWriter clearMem1 = new PrintWriter(clearMem, false);
		PrintWriter clearBoat1 = new PrintWriter(clearBoat, false);
		clearMem1.flush();
		clearMem1.close();
		clearMem.close();
		clearBoat1.flush();
		clearBoat1.close();
		clearBoat.close();
	}

	public static ArrayList<Integer> saveUID() {// To check from the seved uid's in member.txt
		ArrayList<Integer> tempUID = new ArrayList<>();
		try {
			String line = "";
			FileInputStream file = new FileInputStream("Members.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				tempUID.add(Integer.parseInt(line.substring(0, 8)));
			}
			scan.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tempUID;
	}

	public static void textToList() {
		if (memList.size() == 0) {
			try {
				String line = "";
				FileInputStream file = new FileInputStream("Members.txt");
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {// reading the members file

					line = scan.nextLine() + ";";
					String[] part = line.split(";");// parting for members text file
					memList.add(new Member(Integer.parseInt(part[0]), part[1], part[2]));

				}
				for (Member m : memList) {
					String boatLine = "";
					FileInputStream boatFile = new FileInputStream("Boats.txt");
					Scanner boatScan = new Scanner(boatFile);
					while (boatScan.hasNextLine()) {
						boatLine = boatScan.nextLine() + ";";
						String[] partBoat = boatLine.split(";");// parting for boats text file

						if (Integer.parseInt(partBoat[0]) == m.getUID()) {
							m.registerBoat(Double.parseDouble(partBoat[2]), partBoat[1]);

						}
					}
				}
				// scan.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void printCompactList() {
		System.out.println("UID/" + "Name/" + "No. Of Boats	");
		for (Member m : memList) {

			System.out.println(
					Integer.toString(m.getUID()) + " " + m.getName() + " " + Integer.toString(m.getNoOfBoats()));
		}
	}

	public static void printVerboseList() {
		for (Member m : memList) {
			System.out.println(Integer.toString(m.getUID()) + " " + m.getName() + " " + m.getPN());
			for (Boat b : m.getBoatList()) {
				System.out.println("				" + b.getBoatType() + "    " + Double.toString(b.getBoatLength()));
			}
		}
	}

	public static void specMemInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your UID : ");
		int id = sc.nextInt();
		System.out.println("UID/Name/Personal Number/Number of Boats/Boat Type and Length");
		for (Member m : memList) {
			if (id == m.getUID()) {
				System.out.println(m.getUID() + "  " + m.getName() + "  " + m.getPN() + "  " + m.getNoOfBoats());
				for (Boat b : m.getBoatList())
					System.out.println("						" + b.getBoatType() + "  " + b.getBoatLength());
			}
		}
		// sc.close();//we need to add exception handling
	}

	public static void deleteMem() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your UID : ");
		int id = sc.nextInt();
		for (Member m : memList) {
			if (id == m.getUID()) {
				memList.remove(m);
				System.out.println("Member deleted successfully");
			}
		}
		regMemberTxt();
		regBoatTxt();

	}

	public static void deleteBoat() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your UID : ");
		int id = sc.nextInt();
		for (Member m : memList) {
			if (id == m.getUID()) {
				System.out.println("Which boat do you want to remove? ");
				String bt=sc.next();
				for(Boat b:m.getBoatList())
				{
					if(bt.equalsIgnoreCase(bt));
					m.getBoatList().remove(b);
				}
				System.out.println("Boat successfully deleted");
			}
		}
	}

}
