public abstract class RankTile extends Tile {
    protected int rank;

    /**
     * @param rank
     */
    public RankTile(int rank) {
        this.rank = rank;
    }

    /**
     * Calls matches method of parent class then compares the ranks
     *
     * @param other other tile
     * @return
     */
    public boolean matches(Tile other) {
        return super.matches(other) && (this.rank == ((RankTile) other).rank);
    }
}
