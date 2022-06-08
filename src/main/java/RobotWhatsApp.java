import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class RobotWhatsApp {

    public static final int Window_Width = 400;
    private static final int Window_Height = 300;

    public static void main(String[] args) {
        Window();
    }

    public static void Window() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(0, 0, Window_Width, Window_Height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton button = new JButton("Open the WhatApp");
        button.setBounds(40, 100, Window_Height, Window_Height/5);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener((even) -> {
            frame.dispose();
            OpenTheWhatsApp();
        });
    }

    public static void OpenTheWhatsApp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\Eliyahu toronto\\\\Dropbox\\\\PC\\\\Downloads\\\\Eli\\\\chromedriver.exe"    );
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");


        Thread thread = new Thread(() -> {
            while (true) {
                boolean firstPage = driver.getPageSource().contains("תיבת טקסט להזנת החיפוש");
                if (firstPage) {
                    Connection connection = new Connection(driver);
                    break;
                }

            }
        });
        thread.start();
    }

}

// eliyahu  ->  "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\Eli\\chromedriver.exe";
// yoni  -> "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
// eli -> "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe"