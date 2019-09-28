public abstract class PictureTile extends Tile {

    private String name;

    /**
     * Constructor that initializes name of tile picture
     *
     * @param name
     */
    public PictureTile(String name) {
        this.name = name;
    }

    /**
     * toString will return the name, which will be one of the following:
     * "Chrysanthemum", "Orchid", "Plum", "Bamboo", "Spring", "Summer", "Fall", or "Winter".
     *
     * @return name of Tile
     */
    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
