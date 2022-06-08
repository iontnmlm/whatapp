import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class Connection {
    public final int X = 0;
    public Connection (ChromeDriver driver) {
        OpenWindow openWindow = new OpenWindow();
        JLabel label = new JLabel();
        label.setText("ההתחברות בוצעה בהצלחה");
        label.setBounds(openWindow.getWidth()/5+((openWindow.getWidth()*3)/20),X,(openWindow.getWidth()*3)/10,(openWindow.getWidth()*3)/10);
        openWindow.add(label);


        JLabel number = new JLabel();
        number.setText("please write your number: ");
        number.setBounds(openWindow.getWidth()/10,label.getHeight(), openWindow.getWidth()/2-openWindow.getWidth()/10, label.getHeight()/2);
        openWindow.add(number);

        JLabel message = new JLabel();
        message.setText("please write your message: ");
        message.setBounds(number.getX()+number.getX()/2+number.getWidth(),label.getHeight(),number.getWidth(),label.getHeight()/2);
        openWindow.add(message);

        JTextField textBoxNum = new JTextField(0);
        textBoxNum.setBounds(number.getX()/2,number.getY()*2-number.getHeight(),number.getWidth(), number.getHeight());
        openWindow.add(textBoxNum);

        JTextField textBoxMas = new JTextField(5);
        textBoxMas.setBounds(message.getX()-number.getX()/2,message.getY()*2-number.getHeight(),message.getWidth(), message.getHeight());
        openWindow.add(textBoxMas);

        JButton button = new JButton("Send");
        button.setBounds(number.getWidth(),label.getHeight()*2+label.getHeight()/6, number.getWidth()/2, number.getHeight());
        openWindow.add(button);

        button.addActionListener((event)->{

            String saveMas = textBoxMas.getText();
            String saveNum = textBoxNum.getText();
            openWindow.dispose();
            CheckUserData files = new CheckUserData(saveMas, saveNum, driver);

        });

        openWindow.setVisible(true);
    }

}
