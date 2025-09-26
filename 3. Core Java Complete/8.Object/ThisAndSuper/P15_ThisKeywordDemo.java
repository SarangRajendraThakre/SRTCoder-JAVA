
public class P15_ThisKeywordDemo {

    public static void main(String[] args) {
         P15_ThisKeywordDemo obj = new P15_ThisKeywordDemo();

         System.out.println(obj);
         obj.m1();

         P15_ThisKeywordDemo obj2 = new P15_ThisKeywordDemo();
         System.out.println(obj2);

    }

    public void m1()
    {
        System.out.println("m1()");
        System.out.println(this);
    }
}


