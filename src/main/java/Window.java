import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        this.setLayout(null);
        this.setBounds(0, 0, 500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        JLabel label = new JLabel();
        label.setText("ההתחברות בוצעה בהצלחה");
       // label.setBounds(100,100,100,100);
        label.setSize(200,200);

        this.add(label);


    }
}
