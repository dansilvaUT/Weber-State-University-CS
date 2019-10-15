public class Lock {
    public boolean equals(Object obj) {
        if (this == obj)
            return false;
        if (obj == null)
            return false;
        return getClass() == obj.getClass();
    }
}
