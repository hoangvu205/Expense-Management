import javax.swing.*;

public class nhap{
    public static void main(String[] args) {
        JFrame windown=new JFrame("cua so app");
        windown.setSize(500,500);
        windown.setDefaultCloseOperation(windown.EXIT_ON_CLOSE);
        JButton view=new JButton("view");
        windown.setLayout(null);
        JButton chuyen=new JButton("chuyen");
        chuyen.setBounds(2,2,300,20);
        windown.add(chuyen);
        windown.setVisible(true);
    }
}