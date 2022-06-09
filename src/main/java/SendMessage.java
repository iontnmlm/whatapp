import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SendMessage {
    private final int x =100 ,y = 50 , width = 400, height = 100 , sizeColor = 20 , timeSleep = 5000;
    public static final int Window_Width = 400 , Window_Height = 250;
    public SendMessage(ChromeDriver driver) {


        String massage = null;
        try {
            massage = readFile();
            System.out.println(massage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        WebElement putMassage = driver.findElement(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div.p3_M1 > div > div._13NKt.copyable-text.selectable-text"));
        putMassage.sendKeys(massage);

        WebElement element = driver.findElement(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div._3HQNh._1Ae7k"));
        element.click();

        OpenWindow openWindow = new OpenWindow(Window_Width,Window_Height);

        JLabel label = new JLabel();
        label.setText("ההודעה נשלחה בהצלחה");
        label.setBounds(x,y,width,height);
        label.setFont(new Font("Arial", Font.BOLD, sizeColor));
        openWindow.add(label);
        openWindow.setVisible(true);

        try {
            Thread.sleep(timeSleep);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        openWindow.dispose();
        driver.close();
        driver.close();
        new Thread(() ->{
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static String readFile() throws FileNotFoundException {
        File path = new File("textBoxMas.txt");
        Scanner scanner = new Scanner(path);
        String text = scanner.nextLine();
        return text;
    }

}
