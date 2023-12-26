package uchinchi_oy;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class task1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileInputStream fl = new FileInputStream("Fayllar/todo.txt");
        Scanner sl = new Scanner(fl);
        Vector<String> all = new Vector<>();
        while (sl.hasNextLine()){
            all.add(sl.nextLine());
        }
        all.forEach(System.out::println);
        System.out.printf("bajarilgan taskni kiriting: ");
        String bajarlgan = sc.nextLine();
        FileOutputStream out = new FileOutputStream("Fayllar/done.txt",true);
        for (String s:all) {
            if(s.equals(bajarlgan)){
                out.write(s.getBytes());
                break;
            }
        }
        FileOutputStream change = new FileOutputStream("Fayllar/todo.txt");
        for (String s:all) {
            if(!s.equals(bajarlgan)){
                change.write((s + "\n").getBytes());
            }
        }
        System.out.println("SUCCESSFULL");
    }
}
