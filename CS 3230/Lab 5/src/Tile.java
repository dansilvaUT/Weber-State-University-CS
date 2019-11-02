import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    private static final Dimension SIZE = new Dimension(200, 200);
    private static final Rectangle FACE = new Rectangle(18, 6, 54, 72);
    private static final Polygon SIDE;

    //TODO fix polygon dimensions.
    static {
        final int[] x = {14, 11, 22, 88};
        final int[] y = {11, 22, 55, 44};
        SIDE = new Polygon(x, y, 4);
    }

    //Polygon gradient color 1
    private static final GradientPaint g0 = new GradientPaint(20, 100, Color.WHITE, 120, 0, Color.BLUE);
    //Polygon gradient color 2
    private static final GradientPaint g1 = new GradientPaint(10, 110, Color.WHITE, 20, 0, Color.RED);

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
        //TODO draw polygons
        g2D.setPaint(g0);
        g2D.fill(SIDE);
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
