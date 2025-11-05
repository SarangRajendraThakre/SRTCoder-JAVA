import java.util.Arrays;

class StringIndexOutOfBoundsException extends RuntimeException {

    public StringIndexOutOfBoundsException(String desc) {
        super(desc);
    }

}

class NullPointerException extends RuntimeException {

    public NullPointerException(String desc) {
        super(desc);
    }

}

class MyString {

    private final char[] arr;

    public MyString() {
        this.arr = new char[0];
    }

    public MyString(String str) {
        this.arr = str.toCharArray();
    }

    public MyString[] toCharArray(MyString str) {
        MyString[] newArr = new MyString[str.length()];

        for (int i = 0; i < str.length(); i++) {
            newArr[i] = new MyString(new char[] { str.charAt(i) });
        }
        return newArr;
    }

    public char charAt(int i) {
        if (i < 0 || i >= arr.length) {
            throw new StringIndexOutOfBoundsException("there is error in bounds ");
        }
        return arr[i];
    }

    public int length() {
        return this.arr.length;
    }

    public MyString(StringBuffer sb) {
        this.arr = sb.toString().toCharArray();
    }

    public MyString(StringBuilder sb) {
        this.arr = sb.toString().toCharArray();
    }

    public MyString(char[] arr) {
        this.arr = new char[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    public MyString(char[] arr, int start, int count) {
        if (arr == null) {
            throw new NullPointerException("arr is null");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < arr.length; i++, j++) {
            this.arr[j] = arr[i];
        }
    }

    public MyString(byte[] arr) {
        this(arr, 0, arr.length);
    }

    public MyString(byte[] arr, int start, int count) {
        if (arr == null) {
            throw new NullPointerException("arr is null");
        }
        if (start < 0 || count > arr.length || start + count > arr.length) {
            throw new StringIndexOutOfBoundsException("there is error in start and end length ");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < arr.length; i++, j++) {
            this.arr[j] = (char) arr[i];
        }

    }

    public MyString(int[] arr, int start, int count) {

        if (arr == null) {
            throw new NullPointerException("arr is null");
        }
        if (start < 0 || count > arr.length || start + count > arr.length) {
            throw new StringIndexOutOfBoundsException("there is error in start and end length ");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < arr.length; i++, j++) {
            this.arr[j] = (char) arr[i];
        }
    }

    public boolean isEmpty()
    {
        return this.arr.length == 0;
    }


    @Override
    public String toString() {
        if (arr.length == 0)
            return "";

        String str = "";
        for (char ele : this.arr) {
            str += ele;
        }
        return str;
    }



}

public class MystringDriverP {

    public static void main(String[] args) {

        MyString str = new MyString("Sarang");
        System.out.println(str);
        System.out.println(Arrays.toString(str.toCharArray(str)));
    }

}