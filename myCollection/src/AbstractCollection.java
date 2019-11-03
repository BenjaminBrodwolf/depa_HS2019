import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {

    @Override
    public Iterator<E> iterator() {

        return null;
    }

    @Override
    public boolean add(E x) { // NOT JOB

        return true;
    }

    @Override
    public int size() {
        int amount = 0;
        while (this.iterator().hasNext()) {
            amount++;
            this.iterator().next();
        }
        return amount;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object x) {
        while (this.iterator().hasNext()) {
            if (null != x && x.equals(this.iterator().next())) return true;
           // this.iterator().next();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!this.contains(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean remove(Object x) {
        if (contains(x)) {
            while (this.iterator().hasNext()) {
                if (null != x && x.equals(this.iterator().next())) {
                   // this.iterator().next();
                    this.iterator().remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


}
