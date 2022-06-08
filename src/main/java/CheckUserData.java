import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CheckUserData extends JFrame{
    File mas = new File("textBoxMas.txt");
    File num = new File("textBoxNum.txt");

    public CheckUserData(String message, String number, ChromeDriver driver){
        boolean bMas = true,bNum = true;

        if(message.length() == 0 ) {
            OpenWindow window = new OpenWindow();
            JLabel label = new JLabel("you don't enter anything");
            System.out.println(window.getWidth()+""+window.getHeight());
            label.setBounds(window.getWidth()/3,window.getHeight()/4, window.getWidth()/2, window.getHeight()/4 );
            window.add(label);
            bMas = false;

        }else if (number.length() == 0) {
            OpenWindow window = new OpenWindow();
            JLabel label = new JLabel("you don't enter number");
            label.setBounds(window.getWidth()/3,window.getHeight()/2, window.getWidth()/2, window.getHeight()/4 );
            window.add(label);
            bNum = false;

        }else {
            try {
                FileWriter writerMas = new FileWriter(mas);
                FileWriter writerNum = new FileWriter(num);

                writerNum.write(number);
                writerNum.close();

                writerMas.write(message);
                writerMas.close();

                String strNum = readFromFile(num);
                bNum = checkNum(strNum);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        if (bNum && bMas){
            try {
                OpenChat openChat = new OpenChat(driver);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }




    public static boolean checkNum (String str){
        if(str.charAt(0) != '0' || str.charAt(1) != '5' || str.length()!= 10){
            OpenWindow window = new OpenWindow();
            JLabel label = new JLabel("your number nut proper");
            label.setBounds(window.getWidth()/3,window.getHeight()/2, window.getWidth()/2, window.getHeight()/4 );
            window.add(label);
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (str.charAt(i) > 57 || str.charAt(i) < 48) {
                OpenWindow window = new OpenWindow();
                JLabel label = new JLabel("You can only put numbers!");
                label.setBounds(window.getWidth() / 3, window.getHeight() / 2, window.getWidth() / 2, window.getHeight() / 4);
                window.add(label);
                return false;
            }
        }
      return true;
    }

    public static String readFromFile(File file){
        String text;
        try {
            Scanner scanner = new Scanner(file);
            text =scanner.nextLine();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

}
