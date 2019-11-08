import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FlowerTile extends PictureTile {

    private Image image;

    /**
     * Constructor that initializes name of tile picture
     *
     * @param name
     */
    public FlowerTile(String name) {
        super(name);
        this.setToolTipText(toString());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        URL imageSource = null;
        switch (super.name) {
            case "Bamboo":
                imageSource = FlowerTile.class.getResource("images/Bamboo.png");
                break;
            case "Chrysanthemum":
                imageSource = FlowerTile.class.getResource("images/Chrysanthemum.png");
                break;
            case "Orchid":
                imageSource = FlowerTile.class.getResource("images/Orchid.png");
                break;
            case "Plum":
                imageSource = FlowerTile.class.getResource("images/Plum.png");
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
        frame.setTitle("Flower Tiles");

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.pack();
        frame.setVisible(true);
    }
}
