import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class CheckStatus {

    private final int x =100 ,y = 50 , width = 400, height = 100 , sizeColor = 20 ;
    public static final int Window_Width = 400 , Window_Height = 250;

    public CheckStatus(ChromeDriver driver){

            OpenWindow status = new OpenWindow(Window_Width,Window_Height);
            boolean oneCheck = true;
            boolean towCheck = true;

            boolean oneCheck1 = false;
            boolean towCheck1 = false;

            while (true) {

                if(oneCheck) {
                     oneCheck1 = driver.getPageSource().contains(" נשלחה ");
                }
                if(towCheck){
                     towCheck1 = driver.getPageSource().contains(" נמסרה ");
                }
                boolean readCheck1 = driver.getPageSource().contains(" נקראה ");


                if (oneCheck1) {
                    JLabel label = new JLabel();
                    label.setText("V");
                    label.setBounds(x,y,width,height);
                    label.setFont(new Font("Arial", Font.BOLD, sizeColor));
                    status.add(label);
                    oneCheck = false;
                    status.setVisible(true);
                }
                 if(towCheck1){

                    JLabel label = new JLabel();
                    label.setText("V");
                    label.setBounds(x+15,y+15,width+15,height+15);
                    label.setFont(new Font("Arial", Font.BOLD, sizeColor));
                    status.add(label);
                    towCheck = false;
                    status.setVisible(true);
                }
                if(readCheck1){
                    status.dispose();
                    break;
                }


            }

    }

    }


