package Dars;

import java.util.HashSet;
import java.util.Scanner;

public class EmailCollector {
    public static HashSet<String> allemail = new HashSet<>();
    public static Scanner sc = new Scanner(System.in);

    public static void addEmail(){
        System.out.printf("Enter email: ");
        String email = sc.next() + sc.nextLine();
        if(allemail.add(email)){
            System.out.println("Accepted");
        }else{
            System.out.println("this email already exists, please enter again ");
        }
        System.out.printf("1.Yana email kiritsh\n2.Dasturni to'xtatish\n3.Barcha emaillarni ko'rish\n--> ");
        int choice = sc.nextInt();
        if(choice==1){
            addEmail();
        } else if (choice==2) {
            return;

        } else if (choice==3) {
            show_all();
        }
    }
    public static void show_all(){
        System.out.println("        Emaillar        ");
        for (String email:allemail) {
            System.out.println(email);
        }
        System.out.printf("\n");
        System.out.printf("1.Yana email kiritsh\n2.Dasturni to'xtatish\n--> ");
        int choice = sc.nextInt();
        if(choice==1){
            addEmail();
        } else if (choice==2) {
            return;
        }
    }

}

