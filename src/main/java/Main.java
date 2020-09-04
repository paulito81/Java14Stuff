public class Main {

    public static void main(String[] args) {
       objectNullpointer();
       stringNullpointer();
    }

    private static void objectNullpointer(){
        Object myObject = null;
        myObject.toString().hashCode();
    }
    private static void stringNullpointer(){
        String nullValue = null;
        nullValue.toString().length();
    }
}
