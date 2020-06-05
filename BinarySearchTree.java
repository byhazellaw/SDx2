
public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;

		Node(E value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node) obj;
			return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}

	protected Node root = null;

	protected void visit(Node n) {
		System.out.println(n.value);
	}

	public boolean contains(E val) {
		return contains(root, val);
	}

	protected boolean contains(Node n, E val) {
		if (n == null)
			return false;

		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}

	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}

	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			}
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			}
		}
	}

	public boolean remove(E val) {
		return remove(root, null, val);
	}

	protected boolean remove(Node n, Node parent, E val) {
		if (n == null)
			return false;

		if (val.compareTo(n.value) == -1) {
			return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
			return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null) {
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n) {
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
		} else {
			return maxValue(n.rightChild);
		}
	}

	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/

	// Method #1.
	// https://stackoverflow.com/questions/27719588/how-to-handle-null-check-when-searching-for-a-node-in-binary-search-tree/27719862#27719862

	public Node findNode(E val) {

		
		Node current = root;

		if (val != null) {
			
			while (current != null) { // null check
				if (current.value.compareTo(val) == 0) {
					return current; // found it
				} else if (current.value.compareTo(val) > 0) { // compare val to current
					current = current.leftChild;
				} else {
					current = current.rightChild;
				}
			}
			return current;
		}
		return null;
	}

	// Method #2.
	protected int depth(E val) {
		Node current = root;

		int count = 0;

		if (val != null) {
			while (current != null) {
				if (current.value.compareTo(val) == 0) {
					return count;
				} else if (current.value.compareTo(val) > 0) {
					current = current.leftChild;
					count++;
				} else {
					current = current.rightChild;
					count++;
				}
			}
		}
		return -1;
	}

	// Method #3.
	//https://stackoverflow.com/questions/17449845/confused-height-of-binary-tree
	//find the deepest node
	protected int height(E val) {

		Node current = findNode(val);

		if (current == null) {
			return -1;												//null
			
		}  else {
			return height(current);
		}
		
	}
	
	protected int height(Node n) {
		
		if (n==null) {
			return -1;												//null
		} else if (n.leftChild == null && n.rightChild == null) {
			return 0;												//leaf
		}
		
		
		return 1 + Math.max(height(n.leftChild), height(n.rightChild));
		
	}

	
	
	// Method #4.
	protected boolean isBalanced(Node n) {
		
		
		if (n!=null && contains(n.value)) {
			if (Math.abs(height(n.leftChild)-height(n.rightChild))<=1) {
				return true; 
			}
		}

		return false;
		
		
	}

	// Method #5. .
	public boolean isBalanced() {
		
		if (isBalanced(root)) {
			return (isBalanced(root.leftChild) && isBalanced(root.rightChild));
		} 
		return false; 

	}

}
