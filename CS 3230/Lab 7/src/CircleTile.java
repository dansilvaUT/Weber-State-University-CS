import javax.swing.*;
import java.awt.*;

public class CircleTile extends RankTile {

    private static int DIAMETER = 12;

    /**
     * Constructor that initializes circle rank.
     *
     * @param rank
     */
    public CircleTile(int rank) {
        super(rank);
        this.setToolTipText(toString());
    }

    class Pancake extends CircleTile {
        public Pancake(int rank) {
            super(rank);
            this.setToolTipText("Circle " + rank);
        }

        /**
         * Draws the white oval circles inside the pancake tile
         *
         * @param g
         * @param x
         * @param y
         */
        public void drawCircle(Graphics g, int x, int y) {
            g.setColor(Color.BLACK);
            g.fillOval(x, y, DIAMETER * 3, DIAMETER * 3);
            g.setColor(Color.GREEN);
            g.fillOval(x + 1, y + 1, DIAMETER * 3 - 2, DIAMETER * 3 - 2);
            g.setColor(Color.WHITE);
            g.fillOval(45, 24, 3, 3);
            g.fillOval(51, 26, 3, 3);
            g.fillOval(54, 29, 3, 3);
            g.fillOval(56, 33, 3, 3);
            g.fillOval(57, 37, 3, 3);
            g.fillOval(56, 41, 3, 3);
            g.fillOval(55, 45, 3, 3);
            g.fillOval(51, 48, 3, 3);
            g.fillOval(45, 50, 3, 3);
            g.fillOval(39, 48, 3, 3);
            g.fillOval(36, 45, 3, 3);
            g.fillOval(33, 41, 3, 3);
            g.fillOval(31, 37, 3, 3);
            g.fillOval(33, 32, 3, 3);
            g.fillOval(36, 28, 3, 3);
            g.fillOval(40, 26, 3, 3);

        }
    }

    /**
     * toString method that returns the rank of the circle.
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Circle %d", super.rank);
    }

    /**
     * Takes in coordinates to draw the 'x' inside the circles
     *
     * @param g     Graphics object
     * @param x     coordinate
     * @param y     coordinate
     * @param color Color of the x
     */
    public void drawCircle(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillOval(x, y, DIAMETER, DIAMETER);
        g.setColor(Color.WHITE);
        g.drawLine(x + (DIAMETER / 3), y + (DIAMETER / 3), x + DIAMETER - (DIAMETER / 3), y + DIAMETER - (DIAMETER / 3));
        g.drawLine(x + DIAMETER - (DIAMETER / 3), y + (DIAMETER / 3), x + (DIAMETER / 3), y + DIAMETER - (DIAMETER / 3));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (this.rank) {
            case 1:
                Pancake p = new Pancake(rank);
                p.drawCircle(g, 28, 20);
                drawCircle(g, 40, 32, Color.RED);
                break;
            case 2:
                drawCircle(g, 38, 25, Color.GREEN);
                drawCircle(g, 38, 45, Color.RED);
                break;
            case 3:
                drawCircle(g, 23, 16, Color.BLUE);
                drawCircle(g, 41, 35, Color.RED);
                drawCircle(g, 59, 52, Color.GREEN);
                break;
            case 4:
                drawCircle(g, 29, 21, Color.BLUE);
                drawCircle(g, 29, 48, Color.GREEN);
                drawCircle(g, 57, 21, Color.GREEN);
                drawCircle(g, 57, 48, Color.BLUE);
                break;
            case 5:
                drawCircle(g, 25, 17, Color.BLUE);
                drawCircle(g, 58, 17, Color.GREEN);
                drawCircle(g, 43, 34, Color.RED);
                drawCircle(g, 25, 49, Color.GREEN);
                drawCircle(g, 58, 49, Color.BLUE);
                break;
            case 6:
                drawCircle(g, 31, 13, Color.GREEN);
                drawCircle(g, 54, 13, Color.GREEN);
                for (int x = 31; x < 59; x += 23) {
                    for (int y = 32; y < 59; y += 19) {
                        drawCircle(g, x, y, Color.RED);
                    }
                }
                break;
            case 7:
                drawCircle(g, 26, 10, Color.GREEN);
                drawCircle(g, 43, 13, Color.GREEN);
                drawCircle(g, 60, 16, Color.GREEN);
                drawCircle(g, 33, 33, Color.RED);
                drawCircle(g, 52, 33, Color.RED);
                drawCircle(g, 33, 48, Color.RED);
                drawCircle(g, 52, 48, Color.RED);
                break;
            case 8:
                for (int y = 15; y < 60; y += 14) {
                    drawCircle(g, 30, y, Color.BLUE);
                    drawCircle(g, 30, y, Color.BLUE);
                    drawCircle(g, 55, y, Color.BLUE);
                    drawCircle(g, 30, y, Color.BLUE);
                }
                break;
            case 9:
                for (int x = 23; x < 62; x += 19) {
                    drawCircle(g, x, 14, Color.GREEN);
                    drawCircle(g, x, 33, Color.RED);
                    drawCircle(g, x, 52, Color.BLUE);
                }
                break;
            default:
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
