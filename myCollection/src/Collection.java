import java.util.Iterator;

public interface Collection<E> extends Iterable<E> {
    @Override
    Iterator<E> iterator();

    boolean add(E x);

    int size();

    boolean isEmpty();

    boolean contains(Object x);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean remove(Object x);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

    void clear();

    Object[] toArray();

    <T> T[] toArray(T[] a);

}
