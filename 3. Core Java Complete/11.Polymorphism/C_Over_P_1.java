class Demo{
    Demo(){
        System.out.println("Demo()");
    }

    Demo(int a ){
        System.out.println("Demo(int a)");
    }
    Demo(byte a , String b)
    {
        System.out.println("Demo(byte a , String b)");
    }
}


public class C_Over_P_1 {
    // C_Over for Constructor Overloading
    public static void main(String[] args) {
        new Demo();
        new Demo(0);
        new Demo((byte)4, "Sarang");
    }
    
}
