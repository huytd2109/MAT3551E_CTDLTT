package hashtable;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"unchecked", "deprecation"})
public class OpenAddressingHashTable<Key, Value> implements HashTableInterface<Key, Value> {

    private int size = 11;
    private Node<Key, Value>[] table;


    class Node<Key, Value>{
        private Key key;
        private Value value;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{key:"+key+", value:"+value+"}";
        }
    }

    public OpenAddressingHashTable(){
        this.table = new Node[this.size];
    }

    public OpenAddressingHashTable(int size){
        this.size  = size;
        this.table = new Node[this.size];
    }


    //Hàm thực hiện thêm 1 Node mới chứa cặp khóa-giá trị vào trong bảng table
    //Dùng hàm getIndex để lấy ra chỉ số vị trí của khóa k
    //Áp dụng phương pháp dò tuyến tính để xác định vị trí đặt Node mới
    @Override
    public void set(Key k, Value v) {
        
    }
    
    //Hàm thực hiện tìm và trả lại giá trị Value tương ứng với khóa k.
    //Dùng hàm getIndex để lấy ra chỉ số vị trí của khóa k
    //Áp dụng phương pháp dò tuyến tính để xác định vị trí của khóa k và trả lại giá trị value tương ứng
    @Override
    public Value get(Key k) {
        
        return null;
    }

    //Thêm tất cả các khóa có trong bảng vào 1 danh sách (ArrayList) và trả lại danh sách này
    @Override
    public Iterable<Key> keys() {
        
       return null;
    }


    //Hàm băm, hàm này đã viết sẵn sinh viên không chỉnh sửa
    private int hash(Key key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    //Hàm lấy ra vị trí của khóa trong bảng, hàm này đã đươc hoàn thiện, sinh viên không chỉnh sửa hàm này
    private int getIndex(Key key){
        int index = hash(key) & (size - 1);
        return index;
    }
    //Hàm in ra bảng băm, đã hoàn thiện và không cần chỉnh sửa
    public void printTable(){
        for(int i = 0 ; i < size; i++)
        {
            String hidx = "null";
            if(table[i] != null)
                hidx = ""+getIndex(table[i].key);

            
            System.out.println(i+": "+table[i]+" hidx:"+hidx);
        }
    }

    public static void main(String[] args) {
        OpenAddressingHashTable<String, Integer> myHashTable = new OpenAddressingHashTable<>();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);

        myHashTable.set("sin", 111);
        myHashTable.set("cos", 222);
        myHashTable.set("tang", 333);
        myHashTable.set("abs", 444);

        System.out.println(myHashTable.keys());
        myHashTable.printTable();
    }

}
