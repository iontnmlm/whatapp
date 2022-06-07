import javax.swing.*;

public class OpenWindow extends JFrame{

    public  OpenWindow (){
        final int Square = 500;
        final int X = 0;

        this.setLayout(null);
        this.setBounds(X, X, Square, Square);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
