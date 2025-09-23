public class A4_Array_GetClass {
    public static void main(String[] args) {
        byte[] a = new byte[1];
        short[] b = new short[1];
        int[] c = new int[1];
        long[] d = new long[1];
        float[] e = new float[1];
        double[] f = new double[1];
        char[] g = new char[1];
        boolean[] h = new boolean[1];
        String[] i = new String[1];
        Student[] j = new Student[1];

        System.out.println(a.getClass()); // byte array
        System.out.println(b.getClass()); // short array
        System.out.println(c.getClass()); // int array
        System.out.println(d.getClass()); // long array
        System.out.println(e.getClass()); // float array
        System.out.println(f.getClass()); // double array
        System.out.println(g.getClass()); // char array
        System.out.println(h.getClass()); // boolean array
        System.out.println(i.getClass()); // String array
        System.out.println(j.getClass()); // Student array
    }
}

// A helper class for the demo.
class Student {}