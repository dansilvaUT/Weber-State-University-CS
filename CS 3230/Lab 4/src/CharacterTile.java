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

    /**
     * Calls the matches method from parent class and then compares symbols
     *
     * @param other other tile
     * @return boolean
     */
    public boolean matches(Tile other) {
        return super.matches(other) && (this.symbol == ((CharacterTile) other).symbol);
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
