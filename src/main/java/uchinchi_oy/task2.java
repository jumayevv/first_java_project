package uchinchi_oy;

import java.io.*;
import java.util.*;

public class task2 {
        private static final String ENGLISH_FILE_PATH = "english.txt";
        private static final String UZBEK_FILE_PATH = "uzbek.txt";

        private static int len;
        Scanner sc=new Scanner(System.in);
        public void start() throws FileNotFoundException {
                String word;
                do {
                        System.out.printf("so'zni kiriting: ");
                        word = sc.nextLine();
                        System.out.printf("tilni kiriting[en/uz]: ");
                        String lang = sc.nextLine();
                        if(lang.equals("en")){
                                writeToFile(ENGLISH_FILE_PATH,word);
                        } else if (lang.equals("uz")) {
                                writeToFile(UZBEK_FILE_PATH,word);
                        }

                }while (!word.equals("exit"));
                System.out.println("    WORDS   ");
                show();
        }

        private static void writeToFile(String filePath, String word) {
                try (FileOutputStream writer = new FileOutputStream(filePath, true)) {
                        writer.write((word+"\n").getBytes());
                } catch (IOException e) {
                        e.printStackTrace();
                }
                len++;
        }
        private static void show() throws FileNotFoundException {
                ArrayList<String> words = new ArrayList<>();
                FileInputStream en = new FileInputStream(ENGLISH_FILE_PATH);
                FileInputStream uz = new FileInputStream(UZBEK_FILE_PATH);
                Scanner en2 = new Scanner(en);
                Scanner uz2 = new Scanner(uz);
                while (en2.hasNextLine()){
                        words.add(en2.nextLine() + " | " + uz2.nextLine());
                }
                Collections.sort(words);
                for (String word : words) {
                        System.out.println(word);
                }
        }
        public static void main(String[] args) throws FileNotFoundException {
                task2 t = new task2();
                t.start();
        }
}
