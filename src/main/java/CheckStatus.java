import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class CheckStatus extends JFrame {

    private final int x = 100, y = 20, width = 400, height = 100, sizeColor = 20;
    public static final int Window_Width = 300, Window_Height = 200;
    ChromeDriver driver = null;

    OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
    JLabel label = new JLabel();

    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\ELI\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        CheckStatus checkStatus = new CheckStatus(driver);
    }
    public CheckStatus(ChromeDriver driver) {
        this.driver = driver;

        initWindow();

        label.setText("V");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        openWindow.revalidate();
        waitSend();
    }

    public void initWindow() {

        label.setBounds(100, 60, Window_Height, Window_Height / 5);

        label.setFont(new Font("Arial", Font.BOLD, 18));
        openWindow.add(label);
        openWindow.setVisible(true);
    }

    public void waitSend() {
        Thread thread = new Thread(() -> {
            while (true) {
                boolean oneCheck = driver.getPageSource().contains(" נשלחה ");

                if (!oneCheck) {

                    label.setText("V V");
                    label.setFont(new Font("Arial", Font.BOLD, 20));
                    openWindow.revalidate();
                    waitRead();
                    break;
                }
            }
        });
        thread.start();
    }

    public void waitRead() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (!driver.getPageSource().contains(" נמסרה ")) {
                    label.setText("ההודעה נקראה!");
                    openWindow.revalidate();
                    driver.close();
                    break;

                }

            }
        });
        thread1.start();
    }
}