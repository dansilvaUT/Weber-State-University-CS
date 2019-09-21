public class Tile {

    /**
     * Checks if both objects are instances of the same class
     *
     * @param inother other tile
     * @return true/false
     */
    public boolean matches(Tile inother) {
        if (this.getClass() == inother.getClass()) {
            return true;
        } else {
            return false;
        }
    }
}
