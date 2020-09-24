package WS2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestSearch {

    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter UID: ");
         int id = sc.nextInt();
         String line = "";
         try{
             FileInputStream file = new FileInputStream("Boats.txt");
             Scanner scan = new Scanner(file);
             while(scan.hasNextLine()){
                 line=scan
             }

         } catch (Exception ex){
             ex.printStackTrace();
         }

    }
}
