public class BSTIterator {

	Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
    	while (root != null) {
    		stack.push(root);
    		root = root.left;
    	}        
    }

    // Time O(1)   Space O(h)
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Time O(1)   Space O(h)
    /** @return the next smallest number */
    public int next() {
    	if (hasNext()) {
    		TreeNode node = stack.pop();

    		TreeNode rightChild = node.right;
    		while (rightChild != null) {
    			stack.push(rightChild);
    			rightChild = rightChild.left;
    		}
    		return node;
    	}   

    	throw new IllegalArgumentException("Index out of range");     
    }
}