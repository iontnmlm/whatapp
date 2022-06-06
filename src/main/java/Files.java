import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files extends JFrame{
    File mas = new File("textBoxMas.txt");
    File num = new File("textBoxNum.txt");

    public Files(String message,String number){
        try {
            FileWriter writer = new FileWriter(mas);
            FileWriter writer1 = new FileWriter(num);

            writer.write(message);
            writer.close();

            writer1.write(number);
            writer1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(checkNum(num) && checkMas(mas)){
            //כאן אתם צריכים להכניס את מספרים 3,4
        }
    }


    public static boolean checkNum (File num){
        String str = readFromFile(num);

        if (str == null) {
            OpenWindow window = new OpenWindow();
            JLabel label = new JLabel("you don't put number");
            window.add(label);
            return false;
        }
            for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>57 || str.charAt(i)<48){
                OpenWindow window = new OpenWindow();
                JLabel label = new JLabel("your number nut proper");
                window.add(label);
                return false;
            }

            if(str.charAt(0)!= 0 || str.charAt(1)!= 5){
                OpenWindow window = new OpenWindow();
                JLabel label = new JLabel("your number nut proper");
                window.add(label);
                return false;
            }
        }
        return true;
    }

    public static boolean checkMas (File mas){
        String str = readFromFile(mas);

        if (str == null) {
            OpenWindow window = new OpenWindow();
            JLabel label = new JLabel("you don't enter anything");
            window.add(label);
            return false;
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
