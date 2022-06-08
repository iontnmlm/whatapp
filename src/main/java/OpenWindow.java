import javax.swing.*;

public class OpenWindow extends JFrame{
    public static final int Window_Width = 400;
    public static final int Window_Height = 250;
    public static final int StartAt = 0;

    public OpenWindow (){
        this.setLayout(null);
        this.setBounds(StartAt, StartAt, Window_Width, Window_Height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
