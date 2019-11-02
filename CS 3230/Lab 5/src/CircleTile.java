public class CircleTile extends RankTile {
    /**
     * Constructor that initializes circle rank.
     *
     * @param rank
     */
    public CircleTile(int rank) {
        super(rank);
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
}
