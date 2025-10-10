
public class MyBaseClass {

    // 1. public member: Accessible from anywhere
    public String publicVar = "Public Variable";

    public void publicMethod() {
        System.out.println("  > Public Method called.");
    }

    // 2. protected member: Accessible within the same package,
    // and by subclasses in any package.
    protected String protectedVar = "Protected Variable";

    protected void protectedMethod() {
        System.out.println("  > Protected Method called.");
    }

    // 3. default (package-private) member: Accessible only within the same package.
    String defaultVar = "Default (Package-Private) Variable";

    void defaultMethod() {
        System.out.println("  > Default Method called.");
    }

    // 4. private member: Accessible only within this class.
    private String privateVar = "Private Variable";

    private void privateMethod() {
        System.out.println("  > Private Method called.");
    }

    // A public method to demonstrate access to private members from within the same
    // class
    public void demonstratePrivateAccess() {
        System.out.println("\n--- Inside MyBaseClass: Demonstrating Private Access ---");
        System.out.println("  Accessing privateVar: " + privateVar);
        privateMethod();
        System.out.println("----------------------------------------------------\n");
    }
}