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


}
