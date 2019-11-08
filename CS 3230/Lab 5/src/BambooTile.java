import javax.swing.*;
import java.awt.*;

public class BambooTile extends RankTile {
    /**
     * Constructor that initializes rank variable
     *
     * @param rank
     */
    public BambooTile(int rank) {
        super(rank);
        this.setToolTipText(toString());
    }

    /**
     * toString method that returns bamboo rank
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Bamboo %d", super.rank);
    }

    /**
     * Draws the difficult bamboo sticks using coordinates to draw them and colors
     *
     * @param g
     * @param x
     * @param y
     * @param color
     */
    public void drawBambooStick(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x + 3, y + 4, 4, 13);
        g.fillArc(x, y, 9, 10, 0, 180);
        g.fillArc(x, y + 8, 9, 10, 0, 180);
        g.fillArc(x, y + 14, 9, 10, 0, 180);
        g.setColor(Color.WHITE);
        g.drawLine(x + 5, y + 2, x + 5, y + 6);
        g.drawLine(x + 5, y + 12, x + 5, y + 16);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (rank) {
            case 2:
                drawBambooStick(g, 40, 20, Color.BLUE);
                drawBambooStick(g, 40, 40, Color.GREEN);
                break;
            case 3:
                drawBambooStick(g, 41, 20, Color.BLUE);
                drawBambooStick(g, 31, 40, Color.GREEN);
                drawBambooStick(g, 51, 40, Color.GREEN);
                break;
            case 4:
                drawBambooStick(g, 31, 20, Color.BLUE);
                drawBambooStick(g, 51, 20, Color.GREEN);
                drawBambooStick(g, 31, 40, Color.GREEN);
                drawBambooStick(g, 51, 40, Color.BLUE);
                break;
            case 5:
                drawBambooStick(g, 30, 21, Color.GREEN);
                drawBambooStick(g, 30, 41, Color.BLUE);
                drawBambooStick(g, 45, 29, Color.RED);
                drawBambooStick(g, 59, 21, Color.BLUE);
                drawBambooStick(g, 59, 41, Color.GREEN);
                break;
            case 6:
                for (int x = 29; x < 62; x += 16) {
                    drawBambooStick(g, x, 20, Color.GREEN);
                    drawBambooStick(g, x, 40, Color.BLUE);
                }
                break;
            case 7:
                drawBambooStick(g, 41, 11, Color.RED);
                for (int y = 30; y < 50; y += 19) {
                    drawBambooStick(g, 25, y, Color.GREEN);
                    drawBambooStick(g, 41, y, Color.BLUE);
                    drawBambooStick(g, 57, y, Color.GREEN);
                }
                break;
            case 8:
                for (int x = 28; x < 63; x += 17) {
                    drawBambooStick(g, x, 10, Color.GREEN);
                    drawBambooStick(g, x, 49, Color.BLUE);
                }
                drawBambooStick(g, 36, 30, Color.RED);
                drawBambooStick(g, 53, 30, Color.RED);
                break;
            case 9:
                for (int y = 11; y < 51; y += 19) {
                    drawBambooStick(g, 29, y, Color.RED);
                    drawBambooStick(g, 45, y, Color.BLUE);
                    drawBambooStick(g, 61, y, Color.GREEN);
                }
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bamboo Tiles");

        frame.add(new BambooTile(2));
        frame.add(new BambooTile(3));
        frame.add(new BambooTile(4));
        frame.add(new BambooTile(5));
        frame.add(new BambooTile(6));
        frame.add(new BambooTile(7));
        frame.add(new BambooTile(8));
        frame.add(new BambooTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
