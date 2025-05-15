import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T>{
    
    private ArrayList<T> list; 
    
    public DictList() {
        list = new ArrayList<T>();
    }
    
    @Override
    public void add(T data) {
        list.add(data);
    }

    @Override
    public T get(int i) {
        if (i >= 0 && i < list.size()) {
            return list.get(i);
        }
        return null; 
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
