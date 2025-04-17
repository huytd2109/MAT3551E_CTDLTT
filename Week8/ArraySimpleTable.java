import java.util.*;
@SuppressWarnings({"unchecked", "deprecation"})
public class ArraySimpleTable<Key extends Comparable<Key>, Value> extends AbstractSimpleTable<Key, Value>{

    private Key[] keys;
    private Value[] values;
    private int n;
    private int default_size = 100;
    
    public ArraySimpleTable(){
        keys = (Key[]) new Comparable[default_size];
        values = (Value[]) new Object[default_size];
        n = 0;
    }

    public ArraySimpleTable(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        n = 0;
    }
    
    private int indexOf(Key key){
        for (int i = 0; i < n; i++){
            if (key.compareTo(keys[i]) == 0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void put(Key key, Value value) {
        // TODO Auto-generated method stub
        int idx = indexOf(key);
        if (idx == -1){
            keys[n] = key;
            values[n] = value;
            n++;
        }
        else {
            values[idx] = value;
        }

    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        int idx = indexOf(key);
        if (idx > -1){
            return values[idx];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;
        for (int i = 0; i < n; i++){
            if (values[i] != null){
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        List<Key> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (values[i] != null){
                result.add(keys[i]);
            }
        }
        return result;
    }



}
