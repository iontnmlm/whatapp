import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenChat {
    private final int TOW_SECONDS = 1000*2;
    public OpenChat(ChromeDriver driver) throws FileNotFoundException {
        driver.manage().window().maximize();
        String phoneNumber = readFile();
        driver.get(phoneNumber);
        WebElement click = driver.findElement(By.id("action-button"));
        click.click();
        try {
            Thread.sleep(TOW_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement chat = driver.findElement(By.cssSelector("#fallback_block > div > div > h4:nth-child(2) > a"));
        chat.click();
        try {
            Thread.sleep(5000);
            SendMessage sendMessage = new SendMessage(driver);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }

    public static String readFile() throws FileNotFoundException {
        File path = new File("textBoxNum.txt");
        Scanner scanner = new Scanner(path);
        String text = scanner.nextLine();
        String phoneNumber = "https://api.whatsapp.com/send?phone=972" + text;
        return phoneNumber;
    }
}
