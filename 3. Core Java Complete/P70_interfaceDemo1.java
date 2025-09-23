
interface example {
    void m1();
    void m2();
}

class DEMO implements example {
    @Override
    public void m1() {
        System.out.println("m1 got implemented");
    }

    @Override
    public void m2() {
        System.out.println("m2 got implemented");
    }
}

public class P70_interfaceDemo1 {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}