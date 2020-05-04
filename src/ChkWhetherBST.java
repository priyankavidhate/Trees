/*Given a binary tree, check if it is a binary search tree (BST). 
 A valid BST does not have to be complete or balanced.
Consider the below definition of a BST:

All nodes values of left subtree are less than or equal to parent node value
All nodes values of right subtree are greater than or equal to parent node value
Both left subtree and right subtree must be a BST
By definition, NULL tree is a BST
By definition, tree having a single node or leaf nodes are BST*/

public class ChkWhetherBST {
	private static class TreeNode {
		public int val;
		public TreeNode left_ptr;
		public TreeNode right_ptr;

		public TreeNode() {
			this.left_ptr = null;
			this.right_ptr = null;
		}

		public TreeNode(int val) {
			this.val = val;
			this.left_ptr = null;
			this.right_ptr = null;
		}
	}

	static boolean isBST(TreeNode root) {
		return helper(root, null, null);
	}

	static boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.val < min) || (max != null && root.val > max)) {
			return false;
		}
		return helper(root.left_ptr, min, root.val) && helper(root.right_ptr, root.val, max);
	}

}
