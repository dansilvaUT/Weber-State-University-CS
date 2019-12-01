import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SeasonTile extends PictureTile {

    private Image image;

    /**
     * Constructor that initializes name of tile picture
     *
     * @param name
     */
    public SeasonTile(String name) {
        super(name);
        this.setToolTipText(toString());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        URL imageSource = null;
        switch (super.name) {
            case "Spring":
                imageSource = SeasonTile.class.getResource("images/Spring.png");
                break;
            case "Summer":
                imageSource = SeasonTile.class.getResource("images/Summer.png");
                break;
            case "Fall":
                imageSource = SeasonTile.class.getResource("images/Fall.png");
                break;
            case "Winter":
                imageSource = SeasonTile.class.getResource("images/Winter.png");
                break;
        }
        if (imageSource != null) {
            image = Toolkit.getDefaultToolkit().getImage(imageSource);
            g.drawImage(image, 20, 15, 50, 50, this);
        } else {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Season Tiles");

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);

    }
}
