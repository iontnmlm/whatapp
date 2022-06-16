import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CheckStatus extends JFrame{

    private final int x = 100, y = 50, width = 400, height = 100, sizeColor = 20;
    public static final int Window_Width = 400, Window_Height = 250;

    public CheckStatus(ChromeDriver driver) {
        OpenWindow openWindow = new OpenWindow(Window_Width,Window_Height);
        OpenWindow openWindow1 = new OpenWindow(Window_Width,Window_Height);
        OpenWindow openWindow2 = new OpenWindow(Window_Width,Window_Height);

        JLabel oneV = new JLabel("V");
        oneV.setLayout(null);
        oneV.setBounds(70,0,300,300);
        oneV.setFont(new Font("Arial", Font.BOLD, 20));
        openWindow.add(oneV);
        openWindow.setVisible(true);

        while (true) {
            boolean oneCheck = driver.getPageSource().contains(" נשלחה ");

            if (!oneCheck) {

                openWindow.dispose();
                JLabel towV = new JLabel("V V");
                towV.setBounds(100,0,300,300);
                towV.setFont(new Font("Arial", Font.BOLD, 20));
                openWindow2.add(towV);
                openWindow2.setVisible(true);



                break;
            }
        }



        Thread thread = new Thread(()->{
            while (true) {
                if (driver.getPageSource().contains(" נמסרה ")) {

                } else {
                    openWindow2.dispose();
                    JLabel readMessage = new JLabel("ההודעה נקראה!");
                    readMessage.setLayout(null);
                    readMessage.setBounds(70,0,300,300);
                    readMessage.setFont(new Font("Arial", Font.BOLD, 20));
                    openWindow1.add(readMessage);
                    openWindow1.setVisible(true);

                    driver.close();
                    break;
                }

            }
        });thread.start();

    }


//    public static String readFile() throws FileNotFoundException {
//        File path = new File("textBoxMas.txt");
//        Scanner scanner = new Scanner(path);
//        String text = scanner.nextLine();
//        return text;
//    }




}

/*

 */


