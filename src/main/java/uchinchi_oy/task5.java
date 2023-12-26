package uchinchi_oy;

import java.io.*;
import java.util.*;

public class task5 {
    public static void main(String[] args) throws IOException {
        FileReader fl = new FileReader("Fayllar/studentlar.txt");
        Scanner sc= new Scanner(fl);
        ArrayList<String> all = new ArrayList<>();
        while (sc.hasNextLine()){
            all.add(sc.nextLine());
        }
        fl.close();
        for (String x:all) {
            if(Integer.parseInt(x.split(" ")[1]) > 3){
                String result = x.split(" ")[0] + " " + x.split(" ")[1]+" ";
                result += Integer.parseInt(x.split(" ")[2])-10000;
                all.set(all.indexOf(x),result);
            }
        }
        FileWriter fl2 =new FileWriter("Fayllar/xodimlar_yangi.txt");
        for (String s:all) {
            fl2.write(s+"\n");
        }
        fl2.close();

        System.out.println("TASK SUCCESSFULLY DONE");
    }
}
