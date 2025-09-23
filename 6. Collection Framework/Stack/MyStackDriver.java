
class MyEmptyStackExeption extends RuntimeException {
    MyEmptyStackExeption() {
        super();
    }
}

class MyStack<E> {

    E[] arr;
    int index;

    public final static int INITIAL_CAPACITY = 10;

    public MyStack() {
        this.arr = (E[]) new Object[INITIAL_CAPACITY];
    }

    private int newCapacity(int INITIAL_CAPACITY) {
        return INITIAL_CAPACITY * 2;
    }

    public String toString() {
        if (index == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < index - 1; i++) {
            sb.append(arr[i]).append(", ");

        }
        sb.append(arr[index - 1]).append("]");

        return sb.toString();
    }

    public int size() {
        return index;
    }

    public E push(E element) {
        if (size() == arr.length) {
            E[] newArr = (E[]) new Object[newCapacity(arr.length)];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
              
            
            }
              arr = newArr;
        }

        arr[index++] = element;
        return element;
    }

    public E peek() {
        return arr[index - 1];
    }

    public E pop() {
        if (index == 0) {
            throw new MyEmptyStackExeption();
        }
        E temp = arr[index - 1];
        arr[index - 1] = null;
        index--;

        return temp;
    }

}

public class MyStackDriver {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        System.out.println(stack);

        for(int i = 0 ;i<=100;i+=10)
        {
            stack.push(i);
        }
       stack.push(1234);
        System.out.println(stack);
        

    }
}