package ExceptionInJava;

// 1. Define the custom exception.
class UserNullPointerException extends RuntimeException {
    UserNullPointerException(String desc) {
        super(desc);
    }
}

class Student {
    String name;
    
    Student(String name) {
        this.name = name;
    }
}

public class P152_CustomException3 {
    public static void main(String[] args) {
        // Create a student object that is null.
        Student obj = null;

        try {
            // Check if the object is null.
            if (obj == null) {
                // 2. If it's null, throw our custom, more descriptive exception.
                throw new UserNullPointerException("Cannot invoke name because obj is null.");
            } else {
                // This part would run if the object were not null.
                System.out.println(obj.name);
            }
        } catch (UserNullPointerException e) {
            // 3. Catch our custom exception and print its clear message.
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}