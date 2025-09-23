
enum ContainerState {
    EMPTY, FULL, LOCKED
}

class Container<T> {

    private T item;
    private ContainerState state;

    public Container() {
        this.state = ContainerState.EMPTY;
    }

    public void putItem(T item) {
        if (this.state != ContainerState.LOCKED) {
            this.item = item;
            this.state = ContainerState.FULL;
        }
    }

    public ContainerState getState() {
        return this.state;
    }

}

public class Enum3 {

    public static void main(String[] args) {

        Container<Integer> c = new Container<>();
        c.putItem(324);
        System.out.println(c.getState());
        
    }
}
