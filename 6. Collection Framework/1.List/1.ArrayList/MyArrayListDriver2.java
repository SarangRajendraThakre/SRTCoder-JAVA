class MyArrayList<E> {
    E[] arr;
    int index;
    public final static int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arr = (E[]) new Object[initialCapacity];
        } else {

            this.arr = (E[]) new Object[0];
        }
        this.index = 0;
    }

    public MyArrayList(MyArrayList<E> col) {

        if (col instanceof MyArrayList) {
            MyArrayList<E> list = (MyArrayList) col;
            this.index = list.size();
            this.arr = (E[]) new Object[index];
            System.arraycopy(list.arr, 0, arr, 0, index);
        }

    }

    public int size() {
        return index;
    }

    public void clear() {
        for (int i = 0; i < index; i++) {
            arr[i] = null;
        }
        this.index = 0;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = (int) (arr.length * 1.5);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            E[] newArr = (E[]) new Object[newCapacity];

            System.arraycopy(arr, 0, newArr, 0, index);
            this.arr = newArr;
        }

    }

    public void checkIndex(int index) {
        if (index < 0 || index > arr.length) {
            throw new MyArrayIndexOutOfBoundsException("arr is out of bounds");
        }
    }

    public void checkIndexForAdd(int index) {
        if (index < 0 || index >= arr.length) {
            throw new MyArrayIndexOutOfBoundsException("arr is out of bounds");
        }
    }

    public boolean add(E element) {
        ensureCapacity(size() + 1);
        arr[index++] = element;
        return true;

    }

    public boolean addAll(MyArrayList<E> col) {
        ensureCapacity(size() + col.size());
        for (int i = 0; i < arr.length; i++) {
            add(col.get(i));
        }
        return true;
    }

    public boolean remove(E element) {

        int removingIndex = indexOf(element);
        if (removingIndex != -1) {
            for (int i = removingIndex; i < size() - 1; i++) {
                arr[i] = arr[++i];
            }
            this.index--;
            return true;

        }
        return false;

    }

    public boolean removeAll(MyArrayList<E> collection) {

    }

    public int indexOf(E element) {

        if (element == null) {
            for (int i = 0; i < size(); i++) {
                if (arr[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (element.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        if (element == null)
            for (int i = size() - 1; i >= 0; i--) {
                if (arr[i] == null)
                    return i;
            }
        else {
            for (int i = size() - 1; i >= 0; i--) {
                if (element.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E temp = arr[index];
        arr[index] = element;
        return temp;

    }

}

public class MyArrayListDriver2<E> {

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList();
        list.add(10);
        System.out.println(list);

    }

}
