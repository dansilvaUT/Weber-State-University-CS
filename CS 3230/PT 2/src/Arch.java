import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;


public class Arch extends JFrame {
    private Image image;

    public Arch() {
        setTitle("Delicate Arch");
        setSize(600, 400);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        try {
            URL url = new URL("https://www.nps.gov/arch/learn/photosmultimedia/upload/arches3.jpg");

            image = Toolkit.getDefaultToolkit().getImage(url);

        } catch (MalformedURLException murle) {
            JOptionPane.showMessageDialog(this, "Bad URL: " + murle,
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }


        add(new Display());


        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        setVisible(true);
    }

    class Display extends JPanel {


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
            setBackground(Color.BLUE);
            g.setColor(Color.RED);
            g.drawString("Delicate Arch", 300, 360);
            g.getFont().deriveFont(20F);
        }
    }

    public static void main(String[] args) {
        new Arch();
    }
}

