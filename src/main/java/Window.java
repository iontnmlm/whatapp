import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Window extends JFrame {


    public final int Square = 500;
    public final int X = 0;

    public Window(ChromeDriver driver){
        this.setLayout(null);
        this.setBounds(X, X, Square, Square);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel label = new JLabel();
        label.setText("ההתחברות בוצעה בהצלחה");
        label.setBounds(getWidth()/5+((getWidth()*3)/20),X,(getWidth()*3)/10,(getWidth()*3)/10);
        this.add(label);


        JLabel number = new JLabel();
        number.setText("please write your number: ");
        number.setBounds(getWidth()/10,label.getHeight(), getWidth()/2-getWidth()/10, label.getHeight()/2);
        this.add(number);

        JLabel message = new JLabel();
        message.setText("please write your message: ");
        message.setBounds(number.getX()+number.getX()/2+number.getWidth(),label.getHeight(),number.getWidth(),label.getHeight()/2);
        this.add(message);

        JTextField textBoxNum = new JTextField(0);
        textBoxNum.setBounds(number.getX()/2,number.getY()*2-number.getHeight(),number.getWidth(), number.getHeight());
        this.add(textBoxNum);

        JTextField textBoxMas = new JTextField(5);
        textBoxMas.setBounds(message.getX()-number.getX()/2,message.getY()*2-number.getHeight(),message.getWidth(), message.getHeight());
        this.add(textBoxMas);

        JButton button = new JButton("Send");
        button.setBounds(number.getWidth(),label.getHeight()*2+label.getHeight()/6, number.getWidth()/2, number.getHeight());
        this.add(button);

        button.addActionListener((event)->{

            String saveMas = textBoxMas.getText();
            String saveNum = textBoxNum.getText();

            Files files = new Files(saveMas,saveNum);
            this.dispose();
            Files file = new Files(driver);



        });

        this.setVisible(true);



    }

}
