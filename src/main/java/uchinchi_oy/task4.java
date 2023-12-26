package uchinchi_oy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class task4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Vector<FileInputStream> shikoyatlar = new Vector<>();
        for (int i = 0; i < 2; i++) {
            System.out.printf("shikoyatni kiriting: ");
            String s = sc.next() + sc.nextLine() + "\n";
            String name = "Fayllar/shikoyat"+i+".txt";
            FileOutputStream fl = new FileOutputStream(name);
            shikoyatlar.add(new FileInputStream(name));
            fl.write(s.getBytes());
        }
        Enumeration e = shikoyatlar.elements();
        SequenceInputStream info = new SequenceInputStream(e);
        FileOutputStream all = new FileOutputStream("Fayllar/hamma_shikoyatlar.txt");
        all.write(info.readAllBytes());

    }
}
