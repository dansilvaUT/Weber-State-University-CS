public class Combination extends Lock {
    private int first;
    private int second;
    private int third;

    public Combination(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean equals(Object obj) {
        return super.equals(obj)
                && first == ((Combination) obj).first
                && second == ((Combination) obj).second
                && third == ((Combination) obj).third;
    }
}
