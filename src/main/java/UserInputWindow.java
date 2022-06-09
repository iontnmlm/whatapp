import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class UserInputWindow extends JFrame {

    public final int Window_Width = 500 , Window_Height = 400 , StartAt = 0;

    public UserInputWindow(ChromeDriver driver) {
        this.setLayout(null);
        this.setBounds(StartAt, StartAt, Window_Width, Window_Height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("ההתחברות בוצעה בהצלחה");
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setBounds( (Window_Width/5), Window_Height/10,Window_Width,Window_Height/8);
        this.add(label);

        JLabel number = new JLabel();
        number.setText("please write your number: ");
        number.setBounds(Window_Width/15, label.getY()+label.getHeight()+Window_Height/10,Window_Width/3, Window_Height/10);
        number.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(number);

        JLabel message = new JLabel();
        message.setText("please write your message: ");
        message.setFont(new Font("Arial", Font.BOLD, 12));
        message.setBounds(Window_Width/2+Window_Width/20, label.getY()+label.getHeight()+Window_Height/10,Window_Width/3, Window_Height/10);
        this.add(message);

        JTextField textBoxNum = new JTextField(0);
        textBoxNum.setBounds(Window_Width/15, number.getY()+number.getHeight(),Window_Width/3, Window_Height/10);
        this.add(textBoxNum);

        JTextField textBoxMas = new JTextField(5);
        textBoxMas.setBounds(Window_Width/2+Window_Width/20, message.getY()+message.getHeight(),Window_Width/3, Window_Height/10);
        this.add(textBoxMas);

        JButton button = new JButton("Send");
        button.setBounds(Window_Width/3-10, (textBoxMas.getY()+textBoxMas.getHeight()+Window_Height/7),Window_Width/3, Window_Height/10);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(button);

        button.addActionListener((event)->{
            String saveMas = textBoxMas.getText();
            String saveNum = textBoxNum.getText();
            this.dispose();
            CheckUserData files = new CheckUserData(saveMas, saveNum, driver);

        });

        this.setVisible(true);
    }
}
