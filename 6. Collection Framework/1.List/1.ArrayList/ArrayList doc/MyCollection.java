
/**
 * The root interface in the custom collection hierarchy. A collection
 * represents a group of objects, known as its elements.
 *
 * @param <E> the type of elements in this collection
 */
public interface MyCollection<E> {
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
