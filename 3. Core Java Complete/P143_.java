

class P143_ExplicitExceptionExample3 {
    public static void main(String[] args) {
        throw new Exception("Exception created explicitly");
        throw new ClassCastException("Cannot be nested");
        throw new NullPointerException("Object not created");
        throw new Throwable("root class exception");
        throw new InterruptedException("thread get interrupted");
        throw new NoSuchFieldException("file not found");
    }
}