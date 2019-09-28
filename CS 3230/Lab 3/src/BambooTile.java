public class BambooTile extends RankTile {
    /**
     * Constructor that initializes rank variable
     *
     * @param rank
     */
    public BambooTile(int rank) {
        super(rank);
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
}
