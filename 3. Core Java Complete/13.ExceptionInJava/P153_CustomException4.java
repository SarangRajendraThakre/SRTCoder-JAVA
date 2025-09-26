package ExceptionInJava;


// 1. Define the custom exception.
class UserClassCastException extends RuntimeException {
    public UserClassCastException(String desc) {
        super(desc);
    }
}

public class P153_CustomException4 {
    public static void main(String[] args) {
        Object obj1 = new String("Hello");
        // The castObject method will throw an exception here.
        StringBuffer obj2 = castObject(obj1);
        System.out.println(obj2);
    }

    public static StringBuffer castObject(Object obj) {
        StringBuffer sb = null;
        // 2. Check if the object is the wrong type.
        if (!(obj instanceof StringBuffer)) {
            // 3. If so, throw the custom exception.
            throw new UserClassCastException("Obj cannot be casted to StringBuffer");
        } else {
            sb = (StringBuffer) obj;
        }
        return sb;
    }
}