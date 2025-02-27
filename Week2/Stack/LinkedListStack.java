import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {

	class Node {
		T element;
		Node next;
	}

	Node stack = null;

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		Node newNode = new Node();
		newNode.element = element;
		newNode.next = stack;
		stack = newNode;

	
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (stack != null) {
			T data = stack.element;
			stack = stack.next;
			return data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (stack == null)
			return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}

	class StackIterator implements Iterator<T> {

		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = currentNode.element;
			currentNode = currentNode.next;
			return data;
		}
	}

}
