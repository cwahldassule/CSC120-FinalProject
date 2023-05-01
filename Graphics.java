import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Graphics extends Frame implements ActionListener {

    JTextField tf;
    JLabel l;
    JButton b;

    public Graphics() {

        tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);

        l = new JLabel();
        l.setBounds(50, 100, 500, 20);
        l.setText("Welcom to our game!");

        b = new JButton("Start");
        b.setBounds(50, 150, 95, 30);
        b.addActionListener(this);

        add(tf);
        add(l);
        add(b);

        setSize(1200, 800);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            String host = tf.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            l.setText("IP address of " + host + " is: " + ip);
        } catch (Exception e) {
            l.setText(e.getMessage());
        }
    }

    public void ImageJFrame(){
    JFrame f = new JFrame("Add an image to JFrame");
    ImageIcon icon = new ImageIcon("test.png");
    f.add(new JLabel(icon));
    f.pack();
    f.setVisible(true);
  }
    
    public static void main(String[] args) {
        new Graphics();
    }
}