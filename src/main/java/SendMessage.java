import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SendMessage {


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


        OpenWindow openWindow = new OpenWindow();
        JLabel label = new JLabel("ההודעה נשלחה בהצלחה");
        label.setBounds(100, 100, 300, 33);
        openWindow.add(label);
        try {
            Thread.sleep(5000);
            driver.close();
            openWindow.dispose();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    public static String readFile() throws FileNotFoundException {
        File path = new File("textBoxMas.txt");
        Scanner scanner = new Scanner(path);
        String text = scanner.nextLine();
        return text;
    }


}
