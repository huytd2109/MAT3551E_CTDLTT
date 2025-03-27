import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {
	
	class Node{
		Key data;
		Node left, right;
		public Node(Key key)
		{
			this.data =  key;
		}
	}
	
	private Node root = null;
	int n = 0;
	@Override
	public void insert(Key k) {
		// TODO Auto-generated method stub
	    if (root == null){
	        root = new Node(k);
	    }
	    else{
	        Node p = root;
	        while (p != null){
	            if (k.compareTo(p.data) > 0){
	                if(p.right != null){
	                    p = p.right;
	                }
	                else{
	                    p.right = new Node(k);
	                    p = null;
	                }
	            }
	            else{
	                if(p.left != null){
	                    p = p.left;
	                }
	                else{
	                    p.left = new Node(k);
	                    p = null;
	                }
	            }
	        }
	    }
	    n++;
	}
	
	@Override
	public Key search(Key k) {
		// TODO Auto-generated method stub
		Node p = root;
		while (p != null){
		    if(p.data.compareTo(k) == 0){
		        return k;
		    }
		    else{
		        if(p.data.compareTo(k) < 0){
		            p = p.right;
		        }
		        else{
		            p = p.left;
		        }
		    }
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}
	
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		List<Key> result = new LinkedList<Key>();
		inTraverse(result);
		return result.iterator();
	}
	
	public void inTraverseHelper(Node node, List<Key> result){
	    if (node != null){
	        inTraverseHelper(node.left, result);
	        result.add(node.data);
	        inTraverseHelper(node.right, result);
	    }
	}
	
	public void inTraverse(List<Key> result) {
	    inTraverseHelper(root, result);
	}
	
	public void preTraverseHelper(Node node){
	    if (node != null){
	        System.out.println(node.data);
	        preTraverseHelper(node.left);
	        preTraverseHelper(node.right);
	    }
	}
	
	//duyệt cây theo thứ tự trước (tiền thứ tự)
	public void preTraverse()
	{
	    preTraverseHelper(root);
	}
	
	public void postTraverseHelper(Node node){
	    if (node != null){
	        postTraverseHelper(node.left);
	        postTraverseHelper(node.right);
	        System.out.println(node.data);

	    }
	}
	
    // duyệt cây theo thứ tự sau (hậu thứ tự)
	public void postTraverse() {
	    postTraverseHelper(root);
	}
	
	public void inTraverseHelper(Node node){
	    if (node != null){
	        inTraverseHelper(node.left);
	        System.out.println(node.data);
	        inTraverseHelper(node.right);


	    }
	}

    // duyệt cây theo thứ tự giữa (trung thứ tự)
	public void inTraverse() {
	    inTraverseHelper(root);
	}
	
	
	

	public static void main(String[] args) {
		SimpleBST<Integer> bst =  new SimpleBST<>();
		
		int[] data = {5,6,7,1,2,3,8,6,9,0};
		for(int i = 0 ; i < data.length ; i++)
			bst.insert(data[i]);
		
		System.out.println("All element in tree:");
		System.out.println("All element in tree:");
		int[] t = new int[data.length];
		int id = 0;
		for(int d:bst)
		{
			t[id] = d;
			id++;
		}
		
		Arrays.sort(t);
		for(int d:t)
		{
			System.out.print(d+" ");
		}
		
		System.out.println("");
		System.out.println("Size of tree = "+bst.size());
		
		System.out.println("Search key = 4> "+ bst.search(4));
		System.out.println("Search key = 6> "+bst.search(6));
		
		System.out.println("Pre-order tree traversal");
		bst.preTraverse();
		System.out.println("Post-order tree traversal");
		bst.postTraverse();
		System.out.println("In-order tree traversal");
		bst.inTraverse();
		
	}
	
	
	
}
