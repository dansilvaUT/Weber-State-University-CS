public class Password extends Lock {
    public static String password;

    public Password(){

    }
    public Password(String password) {
        this.password = password;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && password == ((Password) obj).password;
    }
}
