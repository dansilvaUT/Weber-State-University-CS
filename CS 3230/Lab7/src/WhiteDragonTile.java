import java.awt.*;

public class WhiteDragonTile extends Tile {

    public WhiteDragonTile() {
        this.setToolTipText("White Dragon Tile");
    }

    /**
     * @return "white dragon"
     */
    @Override
    public String toString() {
        return "White Dragon";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(25, 16, 8, 5);
        g.fillRect(41, 16, 8, 5);
        g.fillRect(57, 16, 8, 5);
        g.setColor(Color.BLUE);
        g.fillRect(25, 29, 5, 8);
        g.fillRect(25, 45, 5, 8);
        g.setColor(Color.BLUE);
        g.fillRect(68, 20, 5, 8);
        g.fillRect(68, 37, 5, 8);
        g.fillRect(68, 52, 5, 8);
        g.setColor(Color.BLUE);
        g.fillRect(25, 59, 8, 6);
        g.fillRect(41, 60, 8, 5);
        g.fillRect(57, 60, 8, 5);
        g.setColor(Color.BLACK);
        g.drawRect(24, 15, 49, 50);
        g.drawRect(30, 20, 37, 39);

    }
}
