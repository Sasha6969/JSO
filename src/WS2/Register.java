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


    public static void regMember() { //HELOOOOOO
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t--Create a member--");

        System.out.print("\nEnter Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter the Personal Number (YYMMDDXXXX): ");
        String persNum = sc.next();

        int uniqueId = (int) (System.currentTimeMillis() & 0xffffff);//generate unique id

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
                FileWriter myWriter = new FileWriter(memFile.getPath());
                Writer output = new BufferedWriter(myWriter);
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
                FileWriter myWriter = new FileWriter(memFile.getPath());
                Writer output = new BufferedWriter(myWriter);
                for (Member m : memList) {
                    output.write(m.getUID() + ";" + m.getName() + ";" + m.getPN() + "\n");
                    System.out.println("Successfully wrote to the file.");
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


}
