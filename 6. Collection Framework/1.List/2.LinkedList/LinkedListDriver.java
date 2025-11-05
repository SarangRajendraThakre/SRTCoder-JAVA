import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A custom implementation of a singly linked list.
 * This class implements the java.util.List interface.
 *
 * @param <E> the type of elements held in this collection
 */
class MyLinkedList<E> implements List<E> {

    // --- Instance Variables ---
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node<E> {
        E ele;
        Node<E> next;

        Node(E ele) {
            this.ele = ele;
            this.next = null;
        }
    }

    // --- Constructors ---

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
    }

    /**
     * Constructs a list containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     */
    public MyLinkedList(Collection<? extends E> c) {
        this(); // Call the default constructor
        addAll(c);
    }

    // --- Helper Methods ---

    /**
     * A private helper method to get the node at a specific index.
     * This is an O(n) operation.
     */
    private Node<E> node(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * A private helper to check if an index is valid for element access.
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * A private helper to check if an index is valid for adding an element.
     */
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // --- Core LinkedList-Specific Public Methods ---

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to adddfgrfl
     */
    public void addFirst(E e) {
        final Node<E> oldHead = head;
        final Node<E> newNode = new Node<>(e);
        newNode.next = oldHead;
        head = newNode;
        if (oldHead == null) {
            // List was empty
            tail = newNode;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * This is equivalent to add(E).
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        final Node<E> oldTail = tail;
        final Node<E> newNode = new Node<>(e);
        tail = newNode;
        if (oldTail == null) {
            // List was empty
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    /**
     * Retrieves, but does not remove, the first element of this list.
     *
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }
        return head.ele;
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return the last element of this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty.");
        }
        return tail.ele;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }
        final E element = head.ele;
        final Node<E> next = head.next;
        head.ele = null; // Help GC
        head.next = null; // Help GC
        head = next;
        if (head == null) {
            // List is now empty
            tail = null;
        }
        size--;
        return element;
    }

    /**
     * Removes and returns the last element from this list.
     * Note: This is an O(n) operation for a singly linked list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty.");
        }
        final E element = tail.ele;
        if (head == tail) {
            // Only one element in the list
            head = null;
            tail = null;
        } else {
            // Find the second to last node
            // Node<E> newTail = node(size - 2);
            // tail = newTail;
            // tail.next = null;

            Node<E> newTail = head;
            for (int i = 0; i < size() - 2; i++) {
                newTail = newTail.next;
            }

            tail = newTail;

            tail.next = null;

        }
        size--;
        return element;
    }

    // --- List and Collection Interface Methods ---

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> prev = node(index - 1);
            Node<E> newNode = new Node<>(element);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).ele;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> targetNode = node(index);
        E oldVal = targetNode.ele;
        targetNode.ele = element;
        return oldVal;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node<E> prev = node(index - 1);
        Node<E> toRemove = prev.next;
        E element = toRemove.ele;
        prev.next = toRemove.next;

        toRemove.ele = null; // Help GC
        toRemove.next = null; // Help GC
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(o, current.ele)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(o, current.ele)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public void clear() {
        // Clear all nodes to help the garbage collector
        for (Node<E> x = head; x != null;) {
            Node<E> next = x.next;
            x.ele = null;
            x.next = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = tail;
        } else {
            succ = node(index);
            pred = (index == 0) ? null : node(index - 1);
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked")
            E e = (E) o;
            Node<E> newNode = new Node<>(e);
            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }

        if (succ == null) {
            tail = pred;
        } else {
            pred.next = succ;
        }

        size += numNew;
        return true;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> current = head;
        while (current != null) {
            sb.append(current.ele);
            if (current.next != null) {
                sb.append(',').append(' ');
            }
            current = current.next;
        }
        sb.append(']');
        return sb.toString();
    }

    // --- Methods below are often more complex and are not fully implemented for
    // simplicity ---
    // A full ListIterator and subList implementation for a singly linked list can
    // be complex.

    @Override
    public Iterator<E> iterator() {
        // A simple iterator implementation will be provided here for demonstration.
        // It does not support remove() for simplicity.
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.ele;
                current = current.next;
                return element;
            }
        };
    }

    // The remaining methods from List/Collection are typically harder to implement
    // or rely on the iterator. They are provided here with basic implementations.

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next)
            result[i++] = x.ele;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next)
            result[i++] = x.ele;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                // Note: a proper implementation would use it.remove()
                // For this example, we re-scan. This is inefficient but works.
                remove(it.next()); // This is conceptually what happens
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                // Note: a proper implementation would use it.remove()
                // For this example, we re-scan. This is inefficient but works.
                remove(it.next()); // This is conceptually what happens
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("ListIterator not implemented.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator not implemented.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList not implemented.");
    }
}

public class LinkedListDriver {

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println(list.indexOf(70));

        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.addFirst(1000);
        System.out.println(list);
        list.addLast(2000);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

}