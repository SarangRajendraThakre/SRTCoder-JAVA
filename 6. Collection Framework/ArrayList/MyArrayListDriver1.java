class MyArrayList<E> {

    E arr[];
    public int index;

    public static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arr = (E[]) new Object[initialCapacity];
        } else {
            this.arr = (E[]) new Object[0];
        }
        this.index = 0;

    }

    public MyArrayList(MyCollection<? extends E> collection)

    {
        if (collection instanceof MyArrayList) {
            MyArrayList<? extends E> otherlist = (MyArrayList<? extends E>) collection;
            this.index = otherlist.size();
            this.arr = (E[]) new Object[index];

            System.arraycopy(collection, 0, arr, 0, index);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = (int) (arr.length * 1.5);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            E[] list = (E[]) new Object[newCapacity];
            System.arraycopy(arr, 0, list, 0, newCapacity);
            this.arr = list;

        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new MyArrayIndexOutOfBoundsException("index " + index + " size " + size());
        }

    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new MyArrayIndexOutOfBoundsException("index " + index + " size " + size());
        }

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

    public boolean add(E element) {
        ensureCapacity(size() + 1);
        arr[index++] = element;
        return true;

    }

    public boolean addAll(MyArrayList collection) {
        MyArrayList<E> col = (MyArrayList<E>) collection;
        for (int i = 0; i < col.size(); i++) {
            add(col.get(i));
        }
        return true;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size(); i++) {
            if (element.equals(arr[i]))
                return i;
        }
        return -1;

    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
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

        int right = 0;
        boolean modified = false;

        for (int i = 0; i < size(); i++) {
            if (!(collection.contains(arr[i]))) {

                arr[right] = arr[i];
                right++;
            }

        }

        for (int i = right; i < size(); i++) {
            arr[i] = null;
        }

        this.index = right;

        return modified;

    }

    public boolean retainAll(MyArrayList<E> collection) {

        int right = 0;
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (collection.contains(arr[i])) {
                arr[right] = arr[i];
                right++;

            }
        }

        if (right != size())
            flag = true;

        if (flag) {
            for (int i = right; i < size(); i++) {
                arr[i] = null;
            }
        }
        this.index = right;

        return flag;
    }

    public E remove(int index) {
        E temp = arr[index];
        checkIndex(index);
        remove(get(index));
        return temp;

    }

    public boolean containsAll(MyArrayList<E> collection) {

        int counter = 0;
        for (int i = 0; i < collection.size(); i++) {
            if (contains(collection.get(i))) {
                counter++;
            }

        }
        if (counter == collection.size()) {
            return true;
        }
        return false;

    }

    public boolean addAll(int index , MyArrayList<E> collection )
    {
        checkIndexForAdd(index);
        ensureCapacity(size()+ collection.size() );

       System.arraycopy(arr, index, arr, index + collection.size() , this.size() - index);

       MyArrayList<E> list =( MyArrayList<E>) collection;

       System.arraycopy(list.arr, 0, arr, index, collection.size());

       this.index += collection.size();

       return true;




    }

    public MyArrayList<E> subList(int fromIndex , int toIndex)
    {

        MyArrayList<E> sub = new MyArrayList();
        for(int i = fromIndex ;i<toIndex;i++)
        {
            sub.add(arr[i]);
        }
        return sub;
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < index - 1; i++) {
            sb.append(arr[i] + ", ");
        }
        sb.append(arr[index - 1]).append("]");

        return sb.toString();

    }

    public int size() {
        return index;
    }

}

public class MyArrayListDriver1<E> {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);



        MyArrayList<Integer> list2 = new MyArrayList();
        list2.add(90);
        list2.add(450);
        list2.add(934);
        list2.add(9034);
        list2.add(90345);

        list.addAll(1, list2);
        System.out.println(list);

    


    }

}
