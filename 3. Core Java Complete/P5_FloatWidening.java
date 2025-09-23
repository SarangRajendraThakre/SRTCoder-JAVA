
public class P5_FloatWidening {
    public static void main(String[] args) {
        float f = 50.5f;
        double d = f;

        System.out.println("float + float = " + (f + f) + " (float)");
        System.out.println("float + double = " + (f + d) + " (double)");
    }
}
