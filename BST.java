/*************************************************************************
 *  Compilation:  javac BST.java
 *  Execution:    java BST
 
 *@author: Jie
 *************************************************************************/

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
			left = null; right = null;
		}
	}
	
	/**
	 * return the value asscociated with the given key, or null if no such key exists
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node x, Key key) {
		if(x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			return get(x.left, key);
		} else if(cmp > 0) {
			return get(x.right, key);
		} else {
			return x.val;
		}
	}
	
	/**
	 * Insert key-value pair into BST
	 * If key already exits, update with new value
	 */
	public void put(Key key, Value val) {
		if(val == null) {
			// HERE: a design issue
			// delete(key);
			return;
		}
		root = put(root, key, val);
	}
	
	public Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val);
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			x.left = put(x.left, key, val);
		} else if(cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}
		
		return x;
	}
	
	/**
	 * Get the minimum key in BST, same to maximum key
	 * 
	 * @return
	 */
	public Key getMin() {
		if(root == null) return null;
		return getMin(root);
	}
	
	private Key getMin(Node x) {
		if(x.left == null) return x.key;
		return getMin(x.left);
	}
	
}


