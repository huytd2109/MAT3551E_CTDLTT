import java.util.*;

@SuppressWarnings("unchecked")

public class OrderedArraySimpleTable <Key extends Comparable<Key>, Value> implements OrderedSimpleTable<Key, Value> {

	private Key[]  keys;
	private Value[] values;
	int n = 0, default_size = 100;
	
	
	// Chú ý hoàn thiện hàm dựng, khởi tạo 2 mảng keys và values
	public OrderedArraySimpleTable() {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[default_size];
        values = (Value[]) new Object[default_size];
        n = 0;
	}
	
	private void resize(int capacity) {
		Key[] tempKeys = (Key[]) new Comparable[capacity];
		Value[] tempValues = (Value[]) new Object[capacity];
		
		for (int i = 0; i < n; i++) {
			tempKeys[i] = keys[i];
			tempValues[i] = values[i];
		}
		
		keys = tempKeys;
		values = tempValues;
	}
	
	@Override
	//Phương thức thực hiện thêm 1 phần tử vào bảng tra cứu, phần tử mới được thêm vào sao
	// cho mảng keys luôn được sắp tăng dần
	public void put(Key key, Value value) {
		// TODO Auto-generated method stub
		int i = binarySearch(key);
		if (i >= 0) {
			values[i] = value;
			return;
		}
		
		if (n == keys.length) {
			resize(2 * keys.length);
		}
		
		i = rank(key);
		
		for (int j = n; j > i; j--) {
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		
		keys[i] = key;
		values[i] = value;
		n++;
	}
	
	
	
	//Phương thức thực hiện tìm kiếm khóa key trên mảng keys bằng thuật toán tìm kiếm nhị phân
	// kết quả trả về là chỉ số (index) của phần tử key trong mảng key
	// nếu không tìm thấy key trong mảng keys, trả lại -1
	public int binarySearch(Key key)
	{
		if (key == null) return -1;
		
		int low = 0, high = n - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			
			if (cmp < 0) high = mid - 1;
			else if (cmp > 0) low = mid + 1;
			else return mid; 
		}
		
		return -1; 
	}
	
	
	// Phương thức get, lấy ra giá trị value tương ứng với key
	// Phương thức này gọi tới phương thức binarySearch(Key key)
	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return null;
		}
		
		int i = binarySearch(key);
		if (i >= 0){
		    return values[i];
		}
		return null;
	}

	
	@Override
	// xóa phần tử ra khỏi bảng tra cứu, dồn lại mảng sau khi xóa
	public void delete(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return;
		}
		
		int i = binarySearch(key);
		if (i == -1) return; 
		
		for (int j = i; j < n-1; j++) {
			keys[j] = keys[j+1];
			values[j] = values[j+1];
		}
		
		keys[n-1] = null;
		values[n-1] = null;
		n--;
		
		if (n > 0 && n == keys.length/4) {
			resize(keys.length/2);
		}
		
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		ArrayList<Key> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(keys[i]);
		}
		return list;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return null;
		}
		return keys[0];
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return null;
		}
		return keys[n - 1];
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return null;
		}
		
		int i = rank(key);
		
		if (i < n && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}
		if (i == 0) return null;
		return keys[i-1];
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return null;
		}
		
		int i = rank(key);
		if (i == n) return null; 
		return keys[i];
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		if (key == null) return 0;
		
		int low = 0, high = n - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			
			if (cmp < 0) high = mid - 1;
			else if (cmp > 0) low = mid + 1;
			else return mid;
		}
		
		return low;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		if (k < 0 || k >= n) return null;
		return keys[k];
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		if (isEmpty()){
		    return;
		}
		delete(min());
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
        if (isEmpty()){
            return;
        }		
        delete(max());
	}

	@Override
	public int size(Key u, Key v) {
		// TODO Auto-generated method stub
		if (u == null || v == null) return 0;
		if (u.compareTo(v) > 0) return 0;
		
		int count = 0;
		int i = rank(u);
		int j = rank(v);
		
		if (contains(v)) {
			return j - i + 1;
		} else {
			return j - i;
		}
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		// TODO Auto-generated method stub
        ArrayList<Key> list = new ArrayList<>();
		if (u == null || v == null) return list;
		if (u.compareTo(v) > 0) return list;
		
		int i = rank(u);
		int j = rank(v);
		
		for (int k = i; k < j; k++) {
			list.add(keys[k]);
		}
		
		if (contains(v)) {
			list.add(v);
		}
		
		return list;
	}
	

}
