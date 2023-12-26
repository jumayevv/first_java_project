package uchinchi_oy;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class faylga_yozish {
    public static void main(String[] args) throws IOException {
        FileOutputStream fl = new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\ismlar.txt");
        String s = "Doniyorbek";
        fl.write(s.getBytes());
        JOptionPane.showOptionDialog(null,
                "txt successfully written",
                "Confirmation",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK");
    }
}
