/**
 * A custom exception class for index-out-of-bounds errors in Mystring.
 */
class MystringIndexOutOfBoundsException extends RuntimeException {
    public MystringIndexOutOfBoundsException(String message) {
        super(message);
    }
}

/**
 * A custom implementation of the String class.
 */
class Mystring {

    private final char[] arr;

    // Constructors

    /**
     * Initializes a new empty Mystring.
     */
    public Mystring() {
        this.arr = new char[0];
    }

    /**
     * Initializes a new Mystring that is a copy of a literal string.
     */
    public Mystring(String s) {
        this.arr = s.toCharArray();
    }

    /**
     * Initializes a new Mystring from a character array.
     */
    public Mystring(char[] arr) {
        this.arr = new char[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);

    }

    /**
     * Initializes a new Mystring from a sub-array of characters,
     * defined by a starting offset and a character count.
     */
    public Mystring(char[] arr, int start, int count) {

        // 1. Validate the input parameters

        if (start < 0 || count < 0 || start + count > arr.length) {
            throw new MystringIndexOutOfBoundsException(
                    "Invalid start or count for array of length " + arr.length);
        }

        // 2. Create the internal array with the specified count
        this.arr = new char[count];

        // 3. Copy the 'count' number of characters from the source array

        System.arraycopy(arr, start, this.arr, 0, count);
    }

    /**
     * Initializes a new Mystring from a byte array.
     */
    public Mystring(byte[] bytes) {
        this(bytes, 0, bytes.length);
    }

    /**
     * Initializes a new Mystring from a sub-array of bytes.
     */
    public Mystring(byte[] bytes, int start, int count) {
        if (bytes == null) {
            throw new NullPointerException("Input array is null");
        }
        if (start < 0 || count < 0 || start + count > bytes.length) {
            throw new MystringIndexOutOfBoundsException("Invalid start or count");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < (start + count); i++, j++) {
            this.arr[j] = (char) bytes[i];
        }
    }

    /**
     * Initializes a new Mystring from a sub-array of integer code points.
     */
    public Mystring(int[] codePoints, int start, int count) {
        if (codePoints == null) {
            throw new NullPointerException("Input array is null");
        }
        if (start < 0 || count < 0 || start + count > codePoints.length) {
            throw new MystringIndexOutOfBoundsException("Invalid start or count");
        }
        this.arr = new char[count];
        for (int i = start, j = 0; i < (start + count); i++, j++) {
            this.arr[j] = (char) codePoints[i];
        }
    }

    public Mystring(StringBuffer sb) {
        if (sb == null) {
            throw new NullPointerException("Input StringBuffer is null");
        }
        // Convert StringBuffer to String, then to char array
        this.arr = sb.toString().toCharArray();
    }

    /**
     * Initializes a new Mystring from a StringBuilder object.
     */
    public Mystring(StringBuilder sb) {
        if (sb == null) {
            throw new NullPointerException("Input StringBuilder is null");
        }
        // Convert StringBuilder to String, then to char array
        this.arr = sb.toString().toCharArray();
    }

    // Methods

    /**
     * Returns the length of this string.
     */
    public int length() {
        return arr.length;
    }

    /**
     * Returns the char value at the specified index.
     */
    public char charAt(int index) {
        if (index < 0 || index >= arr.length) {
            throw new MystringIndexOutOfBoundsException("Index " + index + " out of bounds for length " + arr.length);
        }
        return arr[index];
    }

    /**
     * Checks if this string starts with the specified prefix.
     */
    public boolean startsWith(Mystring str) {
        return startsWith(str, 0);
    }

    /**
     * Checks if this string starts with the specified prefix beginning at a
     * specified index.
     */
    public boolean startsWith(Mystring str, int start) {
        if (start < 0 || start >= arr.length || arr.length - start < str.length()) {
            return false;
        }
        for (int i = start, j = 0; j < str.length(); i++, j++) {
            if (arr[i] != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if this string ends with the specified suffix.
     */
    public boolean endsWith(Mystring suffix) {
        if (arr.length < suffix.length()) {
            return false;
        }
        for (int i = suffix.length() - 1, j = arr.length - 1; i >= 0; i--, j--) {
            if (arr[j] != suffix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Concatenates the specified string to the end of this string.
     */
    public Mystring concat(Mystring merge) {
        char[] newArr = new char[arr.length + merge.length()];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            newArr[index++] = arr[i];
        }
        for (int i = 0; i < merge.length(); i++) {
            newArr[index++] = merge.charAt(i);
        }
        return new Mystring(newArr);
    }

    /**
     * Returns the index within this string of the first occurrence of the specified
     * character.
     */
    public int indexOf(int ch) {
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index within this string of the first occurrence of the specified
     * character, starting the search at the specified index.
     */
    public int indexOf(int ch, int begin_index) {
        for (int i = begin_index; i < arr.length; i++) {
            if (ch == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index within this string of the last occurrence of the specified
     * character.
     */
    public int lastIndexOf(int ch) {
        return lastIndexOf(ch, arr.length - 1);
    }

    /**
     * Returns the index within this string of the last occurrence of the specified
     * character, searching backward from the specified index.
     */
    public int lastIndexOf(int ch, int start) {
        if (start >= arr.length) {
            start = arr.length - 1;
        }
        if (start < 0) {
            return -1;
        }
        for (int i = start; i >= 0; i--) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public int codePointAt(int index) {
        if (index < 0 || index >= arr.length) {
            throw new MystringIndexOutOfBoundsException("Index" + index + "out of bounds for length " + arr.length);
        }
        return arr[index];
    }

    public int codePointBefore(int index) {
        return codePointAt(index - 1);
    }

    public int codePointCount(int start, int end) {
        if (start > end || start < 0 || end < 0 ||
                start >= arr.length || end >= arr.length) {
            throw new IndexOutOfBoundsException("Range [" + start + "," + end + "] out of bounds for  ");

        }
        return end - start;
    }

    /**
     * Replaces all occurrences of a target character with a new character.
     */

    /**
     * Returns a string resulting from trimming leading and trailing whitespace.
     */
    public Mystring trim() {
        int start = 0;
        int end = arr.length - 1;

        while (start < arr.length && arr[start] == ' ') {
            start++;
        }
        while (end > start && arr[end] == ' ') {
            end--;
        }

        int newLength = end - start + 1;
        if (newLength <= 0) {
            return new Mystring();
        }
        return this.substring(start, end + 1);
    }

    /**
     * Returns a new string that is a substring of this string.
     */
    public Mystring substring(int start) {
        return substring(start, arr.length);
    }

    /**
     * Returns a new string that is a substring of this string.
     */
    public Mystring substring(int start, int end) {
        if (start < 0 || end > arr.length || start > end) {
            throw new MystringIndexOutOfBoundsException(
                    "Range [" + start + ", " + end + ") out of bounds for length " + arr.length);
        }
        if (start == 0 && end == arr.length) {
            return this;
        }
        char[] newArr = new char[end - start];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[start++];
        }
        return new Mystring(newArr);
    }

    /**
     * Converts all of the characters in this String to upper case.
     */
    public Mystring toUpperCase() {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                newArr[i] = (char) (arr[i] - 32);
            } else {
                newArr[i] = arr[i];
            }
        }
        return new Mystring(newArr);
    }

    /**
     * Converts all of the characters in this String to lower case.
     */
    public Mystring toLowerCase() {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                newArr[i] = (char) (arr[i] + 32);
            } else {
                newArr[i] = arr[i];
            }
        }
        return new Mystring(newArr);
    }

    /**
     * Returns true if, and only if, length() is 0.
     */
    public boolean isEmpty() {
        return arr.length == 0;
    }

    /**
     * Compares this string to another object.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Mystring))
            return false;
        Mystring str = (Mystring) obj;
        if (arr.length != str.length())
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares this Mystring to another Mystring, ignoring case considerations.
     */
    public boolean equalsIgnoreCase(Mystring str) {
        if (str == null)
            return false;
        return this.toUpperCase().equals(str.toUpperCase());
    }

    /**
     * Returns true if this string contains the specified sequence of char values.
     */
    public boolean contains(Mystring str) {
        for (int i = 0; i <= arr.length - str.length(); i++) {
            if (this.startsWith(str, i)) {
                return true;
            }
        }
        return false;
    }

    public Mystring replace(char oldChar, char newChar) {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldChar) {
                newArr[i] = newChar;
            } else {
                newArr[i] = arr[i];
            }
        }
        return new Mystring(newArr);
    }

    /**
     * Replaces the first substring of this string that matches the given regular
     * expression with the given replacement.
     */
    public Mystring replaceFirst(Mystring searchStr, Mystring repStr) {
        Mystring[] newArr = this.split(new Mystring(" "));
        Mystring op = new Mystring("");
        boolean b = false;
        for (int indx = 0; indx < newArr.length; indx++) {
            Mystring ele = newArr[indx];
            if (ele.equals(searchStr) && (!b)) {
                newArr[indx] = repStr;
                b = true;
            }
            op = op.concat(newArr[indx]);
            if (indx < newArr.length - 1) {
                op = op.concat(new Mystring(" "));
            }
        }
        return op.trim();
    }

    /**
     * Replaces each substring of this string that matches the given regular
     * expression with the given replacement.
     */
    public Mystring replaceAll(Mystring searchStr, Mystring repStr) {
        Mystring[] newArr = this.split(new Mystring(""));
        Mystring op = new Mystring("");
        for (int indx = 0; indx < newArr.length; indx++) {
            Mystring ele = newArr[indx];
            if (ele.equals(searchStr)) {
                newArr[indx] = repStr;
            }
            op = op.concat(newArr[indx]);
        }
        return op.trim();
    }

    /**
     * Splits this string around matches of the given regular expression.
     */
    public Mystring[] split(Mystring regex) {
        if (regex.length() == 0) { // Special case for splitting by empty string
            Mystring[] result = new Mystring[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = new Mystring(new char[] { arr[i] });
            }
            return result;
        }

        int count = 0;
        char regexChar = regex.charAt(0);
        for (char c : arr) {
            if (c == regexChar) {
                count++;
            }
        }

        Mystring[] newArr = new Mystring[count + 1];
        int index = 0;
        Mystring current = new Mystring("");
        for (char ele : arr) {
            if (ele == regexChar) {
                newArr[index++] = current;
                current = new Mystring("");
            } else {
                current = current.concat(new Mystring(new char[] { ele }));
            }
        }
        newArr[index] = current;
        return newArr;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        String str = "";
        for (char ele : arr) {
            str += ele;
        }
        return str;
    }

    public Mystring[] toCharArray(Mystring str){
         
         Mystring[] charArr = new Mystring[str.length()];
         for(int i =0;i<str.length();i++)
         {
            charArr[i] = new Mystring(new char[] { str.charAt(i) });
         }



         return charArr;
    }
}

/**
 * A driver class to test the Mystring implementation.
 */
public class MystringDriver {
    public static void main(String[] args) {
        Mystring str = new Mystring("hie  , bow , sarang , yadnesh , vidya");
        System.out.println(str);

        // The logic in the source code splits by "" and then replaces " ".
        // This will not produce the intuitive result of "hieRbow".
        // Instead, it iterates through ["h","i","e"," ","b","o","w"] and replaces " "
        // with "R".
        // The final string becomes "hieRbow".
        System.out.println(str.replaceAll(new Mystring(" "), new Mystring("R")));
        Mystring space = new Mystring(",");

        System.out.println(java.util.Arrays.toString(str.split(space)));

        System.out.println("------------split()-------------------");
        String s = new String("hie  , bow , sarang , yadnesh , vidya");
        System.out.println(java.util.Arrays.toString(s.split(",")));

        Mystring r1 = new Mystring("h");
        Mystring r2 = new Mystring("b");

         System.out.println("------------replace()--------------");

        System.out.println(str.replace('h','b'));

        System.out.println("------------replaceFirst()-------------------");
        System.out.println(str.replaceFirst(r1, r2));

        System.out.println("------------replaceAll()-------------------");
    
        System.out.println(str.replaceAll(r1, r2));

        System.out.println(java.util.Arrays.toString(new String("My name is Sarang").toCharArray()));

        System.out.println("------------------toCharArray()--------------------------");

        System.out.println(  java.util.Arrays.toString( str.toCharArray(new Mystring("My name is Sarnag")) ));
       


    }
}