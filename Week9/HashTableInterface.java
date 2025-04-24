public interface HashTableInterface<Key, Value> {

    public void set(Key k, Value v);
    public Value get(Key k);
    public Iterable<Key> keys();
    
}
