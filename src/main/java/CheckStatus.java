import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class CheckStatus {

    private final int x =100 ,y = 50 , width = 400, height = 100 , sizeColor = 20 ;
    public static final int Window_Width = 400 , Window_Height = 250;

    public CheckStatus(ChromeDriver driver) {

        OpenWindow status = new OpenWindow(Window_Width, Window_Height);
        JLabel oneV = new JLabel();
        oneV.setText("V");
        oneV.setBounds(50,50,50,50);
        oneV.setFont(new Font("Arial", Font.BOLD, sizeColor));
        status.add(oneV);
        status.setVisible(true);


        while (true) {
            boolean oneCheck = driver.getPageSource().contains(" נשלחה ");

            if (!oneCheck) {
                status.dispose();

                JLabel label = new JLabel();
                label.setText("V V");
                label.setBounds(50,50,50,50);
                label.setFont(new Font("Arial", Font.BOLD, sizeColor));
                status.add(label);
                status.setVisible(true);
                break;
            }
        }
        while (true){
            if(driver.getPageSource().contains(" נמסרה ")){

            }else {
               status.dispose();
               break;
            }

        }
    }


}


