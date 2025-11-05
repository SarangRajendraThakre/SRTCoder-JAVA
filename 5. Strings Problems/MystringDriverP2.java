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
        arr = new char[0];
    }

    public MyString(String str) {
        this.arr = str.toCharArray();
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
            throw new NullPointerException("The arr is null");
        }
        if (start < 0 || start + count > arr.length) {
            throw new StringIndexOutOfBoundsException("Error in bounds");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < (start + count); i++) {
            this.arr[j] = arr[i];
        }
    }

    public MyString(byte[] arr) {
        this(arr, 0, arr.length);
    }

    public MyString(byte[] arr, int start, int count) {
        if (arr == null) {
            throw new NullPointerException("The arr is null");
        }
        if (start < 0 || start + count > arr.length) {
            throw new StringIndexOutOfBoundsException("Error in bounds");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < (start + count); i++) {
            this.arr[j] = (char) arr[i];
        }
    }

    public MyString(int[] arr, int start, int count) {
        if (arr == null) {
            throw new NullPointerException("The arr is null");
        }
        if (start < 0 || start + count > arr.length) {
            throw new StringIndexOutOfBoundsException("Error in bounds");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < (start + count); i++) {
            this.arr[j] = (char) arr[i];
        }
    }

    public int size() {
        return arr.length;
    }

    public boolean isEmpty() {
        return arr.length == 0;
    }

    public char charAt(int index) {
        return arr[index];
    }

    public boolean startsWith(MyString str) {
        return startsWith(str, 0);
    }

    public boolean startsWith(MyString str, int start) {
        if (str == null) {
            throw new NullPointerException("String is null");
        }
        if (start < 0 || arr.length - start < str.length()) {
            throw new StringIndexOutOfBoundsException(" Error in the bounds ");
        }

        for (int i = start, j = 0; i < str.length(); i++, j++) {
            if (this.arr[i] != str.charAt(j)) {
                return false;
            }

        }
        return true;

    }

    public boolean endsWith(MyString suffix) {
        if (suffix == null) {
            throw new NullPointerException("the string is null");
        }
        if (arr.length < suffix.length()) {
            throw new StringIndexOutOfBoundsException("out of bounds ");
        }
        for (int i = suffix.length() - 1, j = arr.length - 1; i >= 0; i--, j--) {

            if (this.arr[j] != suffix.charAt(i)) {
                return false;
            }

        }
        return true;

    }

    public int length() {
        return arr.length;
    }

    public MyString concat(MyString merge) {
        char[] newArr = new char[merge.length() + arr.length];

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            newArr[k++] = arr[i];
        }
        for (int i = 0; i < merge.length(); i++) {
            newArr[k++] = merge.charAt(i);
        }

        return new MyString(newArr);

    }

    public int indexOf(int c) {
        for (int i = 0; i < arr.length; i++) {

            if (c == arr[i]) {
                return i;
            }

        }
        return -1;

    }

    public int indexOf(int c, int startIndex) {
        for (int i = startIndex; i < arr.length; i++) {
            if (c == arr[i]) {
                return i;
            }

        }
        return -1;

    }

    public int lastIndexOf(int c, int start) {
        if (start >= arr.length) {
            start = arr.length - 1;
        }

        for(int i = start;i>=0;i--)
        {
              if(arr[i]==c)
              {
                  return i;
              }

        }
        return -1;
      

    }

    public String toString() {
        if (length() == 0)
            return "";
        String str = "";
        for (char ele : arr) {
            str += ele;
        }
        return str;
    }

}

public class MystringDriverP2 {

    public static void main(String[] args) {

        MyString str = new MyString("Sarang");
        System.out.println(str);

        System.out.println(str.length());
        MyString str2 = new MyString();
        System.out.println(str2.isEmpty());

        System.out.println(str.startsWith(new MyString("ara"), 0));

        System.out.println(str.endsWith(new MyString("rang")));

        System.out.println(str.concat(new MyString(" Thakre")));

    
        System.out.println(str.lastIndexOf( (byte)'g', 345));



    }
    
}