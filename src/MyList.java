import java.util.Arrays;

public class MyList<T> {
    private T[] array;

    public MyList() {
        array = (T[]) new Object[10];
    }

    public MyList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public int size() {
        int count = 0;
        for (T item : array) {
            if (item != null)
                count++;
        }
        return count;
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(T data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                break;
            } else if (array[i] != null && i + 1 == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
                array[i + 1] = data;
                break;
            }
        }
    }

    public T get(int index) {
        if (index < array.length && index >= 0) {
            return array[index];
        } else
            return null;
    }

    public T remove(int index) {
        if (index < array.length && index >= 0) {
            if (array[index] != null) {
                array[index] = null;
            }
        } else
            return null;
        return array[index];
    }

    public T set(int index, T data) {
        if (index < array.length && index >= 0) {
            if (array[index] != null) {
                array[index] = data;
            } else
                return null;
        } else
            return null;
        return array[index];
    }

    public int indexOf(T data) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public T[] toArray() {
        Object[] obj = array;
        return (T[]) obj;
    }

    public void clear() {
        this.array= (T[]) new Object[10];
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> subArray = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subArray.add(array[i]);
        }
        return subArray;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(data))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (size() > 0) {
            StringBuilder str = new StringBuilder("[");
            for (int i = 0; i < size(); i++) {
                if (i == (size() - 1)) {
                    str.append(array[i]).append("]");
                } else str.append(array[i]).append(",");

            }
            return str.toString();
        }
        return "[]";
    }
}
