@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T> {

    private T[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 100;

    public DictList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size >= data.length) {
            resize();
        }
        data[size++] = element;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        return data[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Hàm mở rộng kích thước mảng khi cần
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
