import java.util.Collection;

/**
 * A custom implementation of a singly linked list.
 * This class demonstrates basic data structure concepts, including node
 * manipulation,
 * traversal, and handling of edge cases like an empty list.
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * MyLinkedList<String> list = new MyLinkedList<>();
 * list.add("Apple");
 * list.add("Banana");
 * System.out.println(list.get(0)); // Prints "Apple"
 * }</pre>
 *
 * @author Sarang Thakre
 * @version 1.0
 * @since 2025-08-23
 * @param <E> the type of elements held in this collection
 */

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node<E> {
        E ele;
        Node<E> next;

        public Node(E ele) {
            this.ele = ele;
            this.next = null;
        }
    }

    // --- CONSTRUCTORS ---

    /**
     * Constructs an empty list.
     * 
     */
    public MyLinkedList() {
        // No explicit initialization is needed.
        // head/tail are already null, and size is 0 by default.
    }

    /**
     * Constructs a list containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     */
    public MyLinkedList(Collection<? extends E> c) {
        // Iterate through each element in the provided collection
        for (E element : c) {
            // Add each element to the end of this new linked list
            add(element);
        }
    }

    /**
     * this method add the element at last position
     * 
     * @param ele Element which we adding at the last position
     * @throws no exception is thrown by this method
     * @return this method return nothing
     * 
     */
    public void add(E ele) {
        Node<E> newNode = new Node<>(ele);
       
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index index at which the specified element is to be inserted
     * @param ele   element to be inserted
     * @throws MyIndexOutOfBoundsException if the index is out of range (index < 0
     *                                     || index > size())
     */
    public void add(int index, E ele) {
        if (index < 0 || index > size()) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            addFirst(ele);
        } else if (index == size()) {
            addLast(ele);
        } else {
            Node<E> newNode = new Node<>(ele);
            Node<E> currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
            size++;
        }
    }

  

    /**
     * Inserts the specified element at the beginning of this list.
     * 
     * @param ele the element to add
     */
    public void addFirst(E ele) {
        Node<E> newNode = new Node<>(ele);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param ele the element to add
     */
    public void addLast(E ele) {
        add(ele);
    }

    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws MyIndexOutOfBoundsException if the index is out of range (index < 0
     *                                     || index >= size())
     */
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            return removeFirst();
        }
        Node<E> currNode = head;
        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }
        Node<E> nodeToRemove = currNode.next;
        E temp = nodeToRemove.ele;
        currNode.next = nodeToRemove.next;
        if (currNode.next == null) {
            tail = currNode;
        }
        size--;
        return temp;
    }

    /**
     * Removes and returns the first element from this list.
     * 
     * @return the first element from this list
     * @throws MyNoSuchElementException if this list is empty
     */
    public E removeFirst() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        E ele = head.ele;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return ele;
    }

    /**
     * Removes and returns the last element from this list.
     * 
     * @return the last element from this list
     * @throws MyNoSuchElementException if this list is empty
     */
    public E removeLast() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        E temp = tail.ele;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> currNode = head;
            for (int i = 0; i < size - 2; i++) {
                currNode = currNode.next;
            }
            tail = currNode;
            tail.next = null;
        }
        size--;
        return temp;
    }

    /**
     * Retrieves, but does not remove, the first element of this list.
     *
     * @return the first element of this list
     * @throws MyNoSuchElementException if this list is empty
     */
    public E getFirst() {
        if (head == null) {
            throw new MyNoSuchElementException("Cannot get first element from an empty list.");
        }
        return head.ele;
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return the last element of this list
     * @throws MyNoSuchElementException if this list is empty
     */
    public E getLast() {
        if (tail == null) {
            throw new MyNoSuchElementException("Cannot get last element from an empty list.");
        }
        return tail.ele;
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws MyIndexOutOfBoundsException if the index is out of range (index < 0
     *                                     || index >= size())
     */
    public E get(int index) {

        if (index < 0 || index >= size()) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.ele;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * 
     * @param index index of the element to replace
     * @param ele   element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws MyIndexOutOfBoundsException if the index is out of range (index < 0
     *                                     || index >= size())
     */
    public E set(int index, E ele) {
        if (index < 0 || index >= size()) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        E temp = currNode.ele;
        currNode.ele = ele;
        return temp;
    }

    /**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     * @param there is no parameter
     * @throws no exception is thrown by this method
     */
    public int size() {
        return size;
    }

    /**
     * it delete all the element present in the list
     * 
     */

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * this method check whether the object is present or not
     * 
     */

    public boolean contains(Object o) {
        
        Node<E> currNode = head;

        while (currNode != null) {
            if (o == null) {
                if (currNode.ele == null) {
                    return true;
                }
            } else {
                if (o.equals(currNode.ele)) {
                    return true;
                }
            }
            currNode = currNode.next;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence, or -1 if not found
     */

    public int indexOf(Object o) {
        int index = 0;
        Node<E> currNode = head;
        while (currNode != null) {
            if (o == null) {
                if (currNode.ele == null) {
                    return index;
                }
            } else {
                if (o.equals(currNode.ele)) {
                    return index;
                }
            }
            index++;
            currNode = currNode.next;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence, or -1 if not found
     * 
     */

    public int lastIndexOf(Object o) {
        int index = 0;
        int lastFoundIndex = -1; // Keep track of the last match
        Node<E> currNode = head;

        while (currNode != null) {
            if (o == null) {
                if (currNode.ele == null) {
                    lastFoundIndex = index;
                }
            } else {
                if (o.equals(currNode.ele)) {
                    lastFoundIndex = index;
                }
            }
            index++;
            currNode = currNode.next;
        }
        return lastFoundIndex;
    }

    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<E> currNode = head;
        while (currNode != null) {
            sb.append(currNode.ele);
            if (currNode.next != null) {
                sb.append(", ");
            }
            currNode = currNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

}