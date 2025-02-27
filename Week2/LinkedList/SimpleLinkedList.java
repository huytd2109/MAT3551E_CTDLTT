import java.util.Iterator;
@SuppressWarnings({"unchecked", "deprecation"})
public class SimpleLinkedList<T> implements ListInterface<T> {
	class Node {
		T data;
		Node next;
		public Node(T data) {
		    this.data = data;
		    this.next = null;
		}
		
		public Node(){ }
	}
	private Node top = null;
	private Node bot = null;
	private int n = 0;
	
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		Node newNode = new Node();
		newNode.data = data;
        if (top == null){
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
	
	}
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < n){
		    Node p = top;
		    int count = 0;
		    while (count < i) {
		        p = p.next;
		        count++;
		    }
		    return p.data;
		}
		return null;
	}
	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
	    if (i >= 0 && i < n){
		    Node p = top;
		    int count = 0;
		    while (count < i) {
		        p = p.next;
		        count++;
		    }
		    p.data = data;
		}
	}
	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		Node p = top;
		int count = 0;
		Node pre = null;
		while (count < i){
		    pre = p;
		    p = p.next;
		    count++;
		}
		pre.next = p.next;
		p = null;
		
	}
	@Override
	public boolean isContain(T data) {
		// TODO Auto-generated method stub
	    Node p = top;
	    while (p != null){
	        if(p.data.equals(data)){
	            return true;
	        }
	        p = p.next;
	    }
		return false;
	}
	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stubNode  p = top;
	    Node p = top;
        int index = 0;
        while (p != null){
            if(p.data.equals(data)){
                return index;
            }
            p = p.next;
            index++;
        }
		return -1;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	class LinkedListIterator implements Iterator<T>{
	    private Node current = top;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
		    T data = current.data;
            current = current.next;
            return data;
		}
		
	}

}
