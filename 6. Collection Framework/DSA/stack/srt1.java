package stack;

class srt1 {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of srt1
  
    boolean isEmpty()
    {
        return (top < 0);
    }
    srt1()
    {
        top = -1;
    }
  
    boolean push(int x)
    {
        if (top >= (MAX - 1)) {
            System.out.println("srt1 Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into srt1");
            return true;
        }
    }
  
    int pop()
    {
        if (top < 0) {
            System.out.println("srt1 Underflow");
            return 0;
        }
        else {
            int x = a[top--];
            return x;
        }
    }
  
    int peek()
    {
        if (top < 0) {
            System.out.println("srt1 Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
     
    void print(){
    for(int i = top;i>-1;i--){
      System.out.print(" "+ a[i]);
    }
  }

  
// Driver code
    public static void main(String args[])
    {
        srt1 s = new srt1();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from srt1");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in srt1 :");
        s.print();
    }
}