import java.util.NoSuchElementException;

class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int indx = 0;

    private static class Node<E> {
        E ele;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E ele) {
            this.prev = prev;
            this.ele = ele;
            this.next = null;
        }
    }

    public int size() {
        return indx;
    }

    public void clear() {
        head = null;
        tail = null;
        indx = 0;
    }

    public boolean isEmpty() {
        return indx == 0;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("list is empty");
        }
        return head.ele;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("list is empty");
        }
        return tail.ele;
    }

    public void addFirst(E ele) {
        Node<E> newNode = new Node<>(null, ele);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        indx++;
    }

    public void addLast(E ele) {
        Node<E> newNode = new Node<>(tail, ele);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        indx++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E temp = head.ele;
        head = head.next;
        indx--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return temp;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E temp = tail.ele;
        tail = tail.prev;
        indx--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return temp;
    }

    public void add(int index, E element) {
        if (index < 0 || index > indx) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + indx);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == indx) {
            addLast(element);
            return;
        }

        Node<E> nextNode = node(index);
        Node<E> prevNode = nextNode.prev;
        Node<E> newNode = new Node<>(prevNode, element);

        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        indx++;
    }

    public E remove(int index) {
        if (index < 0 || index >= indx) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + indx);
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == indx - 1) {
            return removeLast();
        }

        Node<E> nodeToRemove = node(index);
        Node<E> prevNode = nodeToRemove.prev;
        Node<E> nextNode = nodeToRemove.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        indx--;
        return nodeToRemove.ele;
    }

    public E get(int index) {
        // The bounds check is now handled by the node() helper method.
        return node(index).ele;
    }

    public E set(int index, E ele) {
        // Corrected the bounds check here.
        if (index < 0 || index >= indx) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + indx);
        }
        Node<E> currentNode = node(index);
        E temp = currentNode.ele;
        currentNode.ele = ele;
        return temp;
    }

    public int indexOf(Object object) {
        int index = 0;
        Node<E> current = head;

        // The loop must run until 'current' itself is null to check every node.
        while (current != null) {
            
            // Case 1: Handle the search if the object passed in is null.
            if (object == null) {
                if (current.ele == null) {
                    return index; // Found a null element.
                }
            } 
            
            // Case 2: Handle the search for a non-null object.
            else {
                // Use the correct single-argument equals() method.
                if (object.equals(current.ele)) {
                    return index; 
                }
            }
            
            // Move to the next node and increment the index.
            current = current.next;
            index++;
        }
        
        // If the loop finishes, the element was not found.
        return -1;
    }

    private Node<E> node(int index) {
        // It's good practice for the public method to check the bounds.
        // The helper can then assume the index is valid.
        if (index < 0 || index >= indx) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + indx);
        }
        Node<E> currentNode;
        if (index < (indx >> 1)) { // Using bit-shift for consistency
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = indx - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder data = new StringBuilder("[");
        Node<E> currNode = head;
        while (currNode.next != null) {
            data.append(currNode.ele).append(", ");
            currNode = currNode.next;
        }
        data.append(currNode.ele).append("]");
        return data.toString();
    }
}

class DoublyLinkedListDriver {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println(list.set(4, 534));
        System.out.println(list.get(4));
        System.out.println(list.indexOf(40));
    }
}