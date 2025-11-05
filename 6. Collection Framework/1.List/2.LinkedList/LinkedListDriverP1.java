class MyNoSuchElementException extends RuntimeException {
    public MyNoSuchElementException(String desc) {
        super(desc);
    }
}

class MyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int index = 0;

    public static class Node<E> {

        E ele;
        Node<E> next;

        public Node(E ele) {
            this.ele = ele;
            this.next = null;
        }
    }

    MyLinkedList() {

    }

    // public MyLinkedList(MyLinkedList<E> col) {

    // if (col instanceof MyLinkedList) {
    // for (int i = 0; i < col.size(); i++) {
    // add(col.get(i));
    // }
    // this.index = col.size();
    // }

    // }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        this.index = 0;
    }

    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
        this.index++;
        return true;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
            index++;
            return;
        }

        newNode.next = head;
        head = newNode;
        this.index++;

    }

    public void addLast(E element) {

        Node<E> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            index++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        index++;

    }

    public E getFirst() {
        if (size() == 0) {
            throw new MyNoSuchElementException("the eleemnt not exist");
        }
        return head.ele;
    }

    public E getLast() {
        if (size() == 0) {
            throw new MyNoSuchElementException("the eleemnt not exist");
        }
        return tail.ele;
    }

    public E removeFirst() {
        E element = head.ele;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return element;

    }

    public E removeLast() {
        E element = tail.ele;

        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        return element;

    }

    @Override
    public String toString() {
        if (index == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            sb.append(currentNode.ele).append(",");

        }
        sb.append(currentNode.ele).append("]");

        return sb.toString();

    }

}

public class LinkedListDriverP1 {

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(10);
        list.add(10);
        System.out.println(list);
    }

}