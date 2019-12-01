import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CharacterTile extends Tile {

    protected char symbol;

    protected static HashMap<String, String> characters = new HashMap<>();

    /**
     * Constructer initializes the symbol fields
     *
     * @param symbol tile symbol
     */
    public CharacterTile(char symbol) {
        this.symbol = symbol;
        this.setToolTipText(toString());
        ;
    }

    static {
        characters.put("1", "\u4E00");
        characters.put("2", "\u4E8C");
        characters.put("3", "\u4E09");
        characters.put("4", "\u56DB");
        characters.put("5", "\u4E94");
        characters.put("6", "\u516D");
        characters.put("7", "\u4E03");
        characters.put("8", "\u516B");
        characters.put("9", "\u4E5D");
        characters.put("N", "\u5317");
        characters.put("E", "\u6771");
        characters.put("W", "\u8997");
        characters.put("S", "\u5357");
        characters.put("C", "\u4E2D");
        characters.put("F", "\u767C");
        characters.put("w", "\u842C");
    }

    /**
     * Calls the matches method from parent class and then compares symbols
     *
     * @param other other tile
     * @return boolean
     */
    public boolean matches(Tile other) {
        return super.matches(other) && (this.symbol == ((CharacterTile) other).symbol);
    }

    public String toChinese() {
        String chineseCharacter = "";
        switch (symbol) {
            case '1':
                chineseCharacter = Character.toString('\u4E00');
                break;
            case '2':
                chineseCharacter = Character.toString('\u4E8C');
                break;
            case '3':
                chineseCharacter = Character.toString('\u4E09');
                break;
            case '4':
                chineseCharacter = Character.toString('\u56DB');
                break;
            case '5':
                chineseCharacter = Character.toString('\u4E94');
                break;
            case '6':
                chineseCharacter = Character.toString('\u516D');
                break;
            case '7':
                chineseCharacter = Character.toString('\u4E03');
                break;
            case '8':
                chineseCharacter = Character.toString('\u516B');
                break;
            case '9':
                chineseCharacter = Character.toString('\u4E5D');
                break;
            case 'N':
                chineseCharacter = Character.toString('\u5317');
                break;
            case 'E':
                chineseCharacter = Character.toString('\u6771');
                break;
            case 'S':
                chineseCharacter = Character.toString('\u5357');
                break;
            case 'W':
                chineseCharacter = Character.toString('\u897F');
                break;
            case 'C':
                chineseCharacter = Character.toString('\u4E2D');
                break;
            case 'F':
                chineseCharacter = Character.toString('\u767C');
                break;
            default:
                break;
        }
        return chineseCharacter;
    }

    /**
     * toString method checks wether symbol is a character 1 through 9 or a character
     * N,E,W,S,C,F
     *
     * @return symbol for first nine tiles and regions
     */
    @Override
    public String toString() {
        String string = "";
        if (String.valueOf(symbol).matches("[0-9]")) {
            return String.format("Character %s", symbol);
        } else {
            switch (symbol) {
                case 'N':
                    string += "North Wind";
                    break;
                case 'E':
                    string += "East Wind";
                    break;
                case 'W':
                    string += "West Wind";
                    break;
                case 'S':
                    string += "South Wind";
                    break;
                case 'C':
                    string += "Red Dragon";
                    break;
                case 'F':
                    string += "Green Dragon";
                    break;
            }
            return string;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font f = g.getFont();
        f = f.deriveFont(f.getSize2D() * 2);
        Font num = f.deriveFont(Font.ITALIC, f.getSize2D() * .5f);
        Font wind = f.deriveFont(f.getSize2D() * 2f);

        if (String.valueOf(symbol).matches("[0-9]")) {
            drawWan(g2, f);
            g2.drawString(characters.get((String.valueOf(symbol)).toString()), 35, 35);
            g2.setColor(TOMATO);
            g2.setFont(num);
            g2.drawString(String.valueOf(symbol), 65, 20);
        } else {
            g2.setColor(TOMATO);
            g2.setFont(num);
            g2.drawString(String.valueOf(symbol), 65, 20);
            Color rg = null;
            switch (symbol) {
                case 'C':
                    rg = TOMATO;
                    break;
                case 'F':
                    rg = LIME;
                    break;
            }
            g2.setColor((symbol == 'C' || symbol == 'F') ? rg : Color.BLACK);
            g2.setFont(wind);
            g2.drawString(characters.get((String.valueOf(symbol)).toString()), 20, 60);
        }

    }

    /**
     * Draws the red character 'wan' at the bottom the character 1 through character 9 tiles
     *
     * @param g2 2D graphics object
     * @param f  font object
     */
    private void drawWan(Graphics2D g2, Font f) {
        g2.setFont(f);
        g2.setColor(TOMATO);
        g2.drawString(characters.get("W"), 32, 62);
        g2.setColor(Color.BLACK);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel tiles = new JPanel();
        JScrollPane scroller = new JScrollPane(tiles);
        tiles.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * 2, 40 + 2));

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }


}
