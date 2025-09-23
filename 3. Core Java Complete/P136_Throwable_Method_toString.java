

public class P136_Throwable_Method_toString {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            String str = null;
            // This throws the exception.
            System.out.println(str.isEmpty());
        } catch (NullPointerException npe) {
            System.out.println("catch");
            // These two lines produce the same output.
            System.out.println(npe);
            System.out.println(npe.toString());
        }
    }
}