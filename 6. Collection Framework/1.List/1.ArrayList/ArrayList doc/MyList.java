


/**
 * An ordered collection (also known as a sequence). The user of this
 * interface has precise control over where in the list each element is
 * inserted. The user can access elements by their integer index.
 *
 * @param <E> the type of elements in this list
 */
 public interface MyList<E> extends MyCollection<E> {
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
