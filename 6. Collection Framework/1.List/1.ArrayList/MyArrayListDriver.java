
 class MyNullPointerException extends RuntimeException {
    MyNullPointerException(String desc) { super(desc); }
}


// Custom Exception Classes (Unchanged)
class MyArrayIndexOutOfBoundsException extends RuntimeException {
    MyArrayIndexOutOfBoundsException(String desc) { super(desc); }
}

/**
 * The root interface in the custom collection hierarchy. A collection
 * represents a group of objects, known as its elements.
 *
 * @param <E> the type of elements in this collection
 */
  interface MyCollection<E> {
    /** Returns the number of elements in this collection. */
    int size();

    /** Returns true if this collection contains no elements. */
    boolean isEmpty();

    /** Removes all of the elements from this collection. */
    void clear();

    /** Appends the specified element to this collection. */
    boolean add(E element);

    /** Adds all of the elements in the specified collection to this collection. */
    boolean addAll(MyCollection<E> collection);

    /**
     * Removes a single instance of the specified element from this collection, if
     * it is present.
     */
    boolean remove(E element);

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection.
     */
    boolean removeAll(MyCollection<E> collection);

    /** Returns true if this collection contains the specified element. */
    boolean contains(E element);

    /**
     * Returns true if this collection contains all of the elements in the specified
     * collection.
     */
    boolean containsAll(MyCollection<E> collection);


    /**
     * 
     * @param collection
     * @return Returns true if  alleast one element is retained from the specified collection
     */
    boolean retainAll(MyCollection<E> collection);

}





/**
 * An ordered collection (also known as a sequence). The user of this
 * interface has precise control over where in the list each element is
 * inserted. The user can access elements by their integer index.
 *
 * @param <E> the type of elements in this list
 */
  interface MyList<E> extends MyCollection<E> {
    /** Inserts the specified element at the specified position in this list. */
    void add(int index, E element);

    /** Adds all of the elements in the specified collection to this list at the specified position. */
    boolean addAll(int index, MyCollection<E> collection);

    /** Returns the element at the specified position in this list. */
    E get(int index);

    /** Replaces the element at the specified position in this list with the specified element. */
    E set(int index, E element);

    /** Removes the element at the specified position in this list. */
    E remove(int index);

    /** Returns the index of the first occurrence of the specified element in this list, or -1 if not found. */
    int indexOf(E element);

    /** Returns the index of the last occurrence of the specified element in this list, or -1 if not found. */
    int lastIndexOf(E element);

    /** Returns a view of the portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive). */
    MyList<E> subList(int fromIndex, int toIndex);
}





/**
 * A resizable-array implementation of the {@code MyList} interface. Implements
 * all optional list operations.
 *
 * @param <E> the type of elements in this list
 */
  class MyArrayList<E> implements MyList<E> {

    private E[] arr;
    private int index; // Tracks the number of elements in the list (the "size")
    private static final int DEFAULT_CAPACITY = 10;

// --- Constructors ---

/**
 * Constructs an empty list with an initial capacity of ten.
 */
public MyArrayList() {
    // Calls the more specific constructor with the default capacity
    this(DEFAULT_CAPACITY);
}

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arr = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            // Use a shared empty array for efficiency if capacity is 0
            this.arr = (E[]) new Object[0]; 
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
        this.index = 0; // The list is initially empty
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public MyArrayList(MyCollection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Input collection cannot be null");
        }
        
        // This implementation depends on the collection being a MyArrayList
        // to access its internal array for an efficient copy.
        if (c instanceof MyArrayList) {
            MyArrayList<? extends E> otherList = (MyArrayList<? extends E>) c;
            this.index = otherList.size();
            this.arr = (E[]) new Object[index];
            System.arraycopy(otherList.arr, 0, this.arr, 0, index);
        } else {
            // Fallback for other collection types
            this.arr = (E[]) new Object[c.size()];
            this.index = 0;
            // A better solution would use an iterator if the interface supported it
            // This will not work if 'c' is not a MyList with a get() method.
        }
    }
    // --- Private Helper Methods ---

     void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = (int) (arr.length * 1.5) ;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            E[] newArr = (E[]) new Object[newCapacity];
            System.arraycopy(arr, 0, newArr, 0, size());
            arr = newArr;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new MyArrayIndexOutOfBoundsException("Index " + index + " out of bounds for size " + size());
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new MyArrayIndexOutOfBoundsException("Index " + index + " out of bounds for size " + size());
        }
    }


    // --- MyCollection Interface Methods ---

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < index; i++) {
            arr[i] = null;
        }
        index = 0;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(size() + 1);
        arr[index++] = element;
        return true;
    }

     @Override
    public boolean addAll(MyCollection<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size() + collection.size());
        if (collection instanceof MyArrayList) {
            MyArrayList<E> otherList = (MyArrayList<E>) collection;
            for (int i = 0; i < otherList.size(); i++) {
                add(otherList.get(i));
            }
        }
        return true;
    }
    
    @Override
    public boolean remove(E element) {
        int foundIndex = indexOf(element);
        if (foundIndex != -1) {
            remove(foundIndex);
            return true;
        }
        return false;
    }

     @Override
    public boolean removeAll(MyCollection<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        boolean modified = false;
        int writeIndex = 0;
        for (int readIndex = 0; readIndex < size(); readIndex++) {
            if (!collection.contains(arr[readIndex])) {
                arr[writeIndex++] = arr[readIndex];
            } else {
                modified = true;
            }
        }
        for (int i = writeIndex; i < size(); i++) {
            arr[i] = null;
        }
        this.index = writeIndex;
        return modified;
    }


    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

  
    @Override
    public boolean containsAll(MyCollection<E> collection) {

        if (collection instanceof MyArrayList) {
            MyArrayList<E> otherList = (MyArrayList<E>) collection;
            for (int i = 0; i < otherList.size(); i++) {
                if (!this.contains(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        // Fallback for unknown collection types (would be very slow)
        System.err.println("Warning: containsAll with unknown collection type is not fully supported.");
        return false;
    }


    @Override
    public boolean retainAll(MyCollection<E> c) {
        if (c == null) {
            throw new NullPointerException("Input collection cannot be null.");
        }

        int originalSize = size();
        int writeIndex = 0; // Points to the next spot to place a "kept" element

        // Iterate through the list with a read index
        for (int readIndex = 0; readIndex < originalSize; readIndex++) {
            // If the element is in the collection 'c', we keep it.
            if (c.contains(arr[readIndex])) {
                // Copy the kept element to the next available 'write' spot.
                arr[writeIndex] = arr[readIndex];
                writeIndex++; // Move the write pointer forward
            }
        }

        // If writeIndex is less than the original size, it means elements were removed.
        boolean modified = (writeIndex != originalSize);
        
        if (modified) {
            // Clean up the rest of the array for the garbage collector
            for (int i = writeIndex; i < originalSize; i++) {
                arr[i] = null;
            }
            // Update the list's actual size
            this.index = writeIndex;
        }

        return modified;
    }
   

   


    // --- MyList Interface Methods ---

      @Override
    public E get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = arr[index];
        arr[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity(size() + 1);
        System.arraycopy(arr, index, arr, index + 1, size() - index);
        arr[index] = element;
        this.index++;
    }
    
    @Override
    public boolean addAll(int index, MyCollection<E> collection) {
        checkIndexForAdd(index);
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size() + collection.size());
        
        // Shift existing elements
        System.arraycopy(arr, index, arr, index + collection.size(), this.size() - index);

        // Copy new elements
        if (collection instanceof MyArrayList) {
            MyArrayList<E> otherList = (MyArrayList<E>) collection;
            System.arraycopy(otherList.arr, 0, this.arr, index, otherList.size());
        }
        
        this.index += collection.size();
        return true;
    }

  

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedElement = arr[index];
        int numToMove = size() - index - 1;
        if (numToMove > 0) {
            System.arraycopy(arr, index + 1, arr, index, numToMove);
        }
        this.index--;
        arr[this.index] = null;
        return removedElement;
    }

    

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size(); i++) if (arr[i] == null) return i;
        } else {
            for (int i = 0; i < size(); i++) if (element.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        if (element == null) {
            for (int i = size() - 1; i >= 0; i--) if (arr[i] == null) return i;
        } else {
            for (int i = size() - 1; i >= 0; i--) if (element.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new MyArrayIndexOutOfBoundsException("Invalid range [" + fromIndex + ", " + toIndex + "]");
        }
        MyList<E> sub = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(arr[i]);
        }
        return sub;
    }

    // --- Object Methods ---
    
    @Override
    public String toString() {
        if (size() == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size(); i++) {
            sb.append(arr[i]);
            if (i < size() - 1) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}



public class MyArrayListDriver {
    public static void main(String[] args) {

        System.out.println("--- Demonstrating Programming to an Interface ---");

        // Use the interface type for the variable declaration
        MyList<String> fruits = new MyArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("List: " + fruits);
        System.out.println("Size: " + fruits.size());

        // ---
        
        MyCollection<String> moreFruits = new MyArrayList<>();
        moreFruits.add("Grape");
        moreFruits.add("Kiwi");
        
        fruits.addAll(1, moreFruits);
        System.out.println("\nAfter addAll: " + fruits);
        
        System.out.println("Does list contain all from moreFruits? " + fruits.containsAll(moreFruits));

        // ---
        
        MyList<String> sub = fruits.subList(2, 5);
        System.out.println("Sublist from index 2 to 5: " + sub);
    }
}
