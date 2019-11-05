import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    private static final Dimension SIZE = new Dimension(200, 200);
    private static final Rectangle FACE = new Rectangle(18, 6, 54, 72);

    private static Polygon side;
    private static Polygon outerSide;
    private static Polygon bottom;
    private static Polygon outerBottom;


    static {
        final int[] x1 = {10, 18, 18, 10};
        final int[] y1 = {12, 6, 78, 85};
        side = new Polygon(x1, y1, 4);

        final int[] x2 = {2, 10, 10, 2};
        final int[] y2 = {18, 12, 88, 95};
        outerSide = new Polygon(x2, y2, 4);

        final int[] x3 = {18, 10, 65, 72};
        final int[] y3 = {78, 88, 88, 78};
        bottom = new Polygon(x3, y3, 4);

        final int[] x4 = {10, 2, 57, 65};
        final int[] y4 = {88, 97, 97, 88};
        outerBottom = new Polygon(x4, y4, 4);

    }

    //Polygon gradient color 1
    private static final GradientPaint g0 = new GradientPaint(20, 100, Color.WHITE, 120, 0, Color.BLUE);
    //Polygon gradient color 2
    private static final GradientPaint g1 = new GradientPaint(10, 100, Color.WHITE, 60, 0, Color.BLUE);

    //Color Face
    private static final Color color = new Color(208, 215, 219);

    /**
     * Checks if both objects are instances of the same class
     *
     * @param other other tile
     * @return true/false
     */
    public boolean matches(Tile other) {
        return this.getClass() == other.getClass();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        setPreferredSize(SIZE);

        //Downcast Graphics to Graphics 2D to use method 'setPaint'
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(color);
        g2D.fill(FACE);

        g2D.setPaint(g0);
        g2D.fill(side);

        g2D.setPaint(g1);
        g2D.fill(outerSide);

        g2D.setPaint(g0);
        g2D.fill(bottom);

        g2D.setPaint(g1);
        g2D.fill(outerBottom);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");

        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);
    }
}
