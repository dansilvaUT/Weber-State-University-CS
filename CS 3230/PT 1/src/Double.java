public class Double extends Password {
    private int pin;

    public Double(int pin) {
        super(password);
        this.pin = pin;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && password == ((Double) obj).password && pin == ((Double) obj).pin;
    }
}
