import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PictureTile extends Tile {

    public String name;
    private Image image;

    /**
     * Constructor that initializes name of tile picture
     *
     * @param name
     */
    public PictureTile(String name) {
        this.name = name;
        this.setToolTipText(toString());
    }

    /**
     * toString will return the name, which will be one of the following:
     * "Chrysanthemum", "Orchid", "Plum", "Bamboo", "Spring", "Summer", "Fall", or "Winter".
     *
     * @return name of Tile
     */
    @Override
    public String toString() {
        return String.format("%s", name);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        URL imageSource = null;
        switch (name) {
            case "Bamboo":
                imageSource = FlowerTile.class.getResource("images/Bamboo.png");
                break;
            case "Chrysanthemum":
                imageSource = FlowerTile.class.getResource("images/Chrysanthemum.png");
                break;
            case "Fall":
                imageSource = SeasonTile.class.getResource("images/Fall.png");
                break;
            case "Orchid":
                imageSource = FlowerTile.class.getResource("images/Orchid.png");
                break;
            case "Plum":
                imageSource = FlowerTile.class.getResource("images/Plum.png");
                break;
            case "Sparrow":
                imageSource = Bamboo1Tile.class.getResource("images/Sparrow.png");
                break;
            case "Spring":
                imageSource = SeasonTile.class.getResource("images/Spring.png");
                break;
            case "Summer":
                imageSource = SeasonTile.class.getResource("images/Summer.png");
                break;
            case "Winter":
                imageSource = SeasonTile.class.getResource("images/Winter.png");
                break;
            default:
                System.exit(0);
        }
        if (imageSource != null) {
            image = Toolkit.getDefaultToolkit().getImage(imageSource);
            g.drawImage(image, 24, 15, 50, 50, this);
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Picture Tiles");

        frame.add(new Bamboo1Tile());

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);
    }
}
