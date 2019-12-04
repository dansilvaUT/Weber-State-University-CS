import javax.swing.*;
import java.awt.*;

public class Bamboo1Tile extends PictureTile {
    /**
     * Constructor that initializes name of tile picture
     */
    public Bamboo1Tile() {
        super("Sparrow");
        this.setToolTipText(toString());
    }

    /**
     * toString method that returns a hard coded "Bamboo 1"
     *
     * @return
     */
    @Override
    public String toString() {
        return "Bamboo1";
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bamboo 1 Tile");

        frame.add(new Bamboo1Tile());

        frame.pack();
        frame.setVisible(true);
    }
}
