public class Tile {

    /**
     * Checks if both objects are instances of the same class
     *
     * @param other other tile
     * @return true/false
     */
    public boolean matches(Tile other) {
        return this.getClass() == other.getClass();
    }
}
