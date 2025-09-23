
/**
 * A resizable-array implementation of the {@code MyList} interface. Implements
 * all optional list operations.
 *
 * @param <E> the type of elements in this list
 */
public class MyArrayList<E> implements MyList<E> {

    private E[] arr;
    private int index; // Tracks the number of elements in the list (the "size")
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
        index = 0;
    }

    // --- Private Helper Methods ---

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = (int) (arr.length * 1.5) + 1;
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
        // This is tricky because we don't know the implementation of the other
        // collection.
        // A simple approach is to iterate through the passed collection.
        // NOTE: This cannot be implemented efficiently without an iterator on the
        // interface.
        // This implementation will work if the passed collection is also a MyArrayList.
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

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection. In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
   

    // --- MyList Interface Methods ---

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
            for (int i = 0; i < size(); i++)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (element.equals(arr[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        if (element == null) {
            for (int i = size() - 1; i >= 0; i--)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = size() - 1; i >= 0; i--)
                if (element.equals(arr[i]))
                    return i;
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
        if (size() == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size(); i++) {
            sb.append(arr[i]);
            if (i < size() - 1)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
