import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class WhatsApp {
    public static void main(String[] args) {
        Window();
    }

    public static void Window() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(0, 0, 500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton button = new JButton("Open the WhatApp");
        button.setBounds(200, 200, 150, 150);
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener((even) -> {
            frame.dispose();
            OpenTheWhatApp();
        });
    }

    public static void OpenTheWhatApp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\Eliyahu toronto\\\\Dropbox\\\\PC\\\\Downloads\\\\Eli\\\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");


        Thread thread = new Thread(() -> {
            while (true) {
                boolean firstPage = driver.getPageSource().contains("תיבת טקסט להזנת החיפוש");
                if (firstPage) {
                    Window window1 = new Window(driver);
                    break;
                }

            }
        });
        thread.start();
    }

}

// tronto  -  "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\Eli\\chromedriver.exe";
// yoni  - "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"