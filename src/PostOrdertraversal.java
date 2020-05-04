import java.util.ArrayList;

/*Write a function to traverse a binary tree Post-order, without using recursion.*/
import java.util.Collections;
import java.util.Stack;

public class PostOrdertraversal {
	private static class TreeNode {
		public int val;
		public TreeNode left_ptr;
		public TreeNode right_ptr;
	}

	static int[] postorderTraversal(TreeNode root) {
		int i = 0;
		int[] output = new int[0];
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (root != null) {
			s.push(root);
			while (!s.empty()) {
				TreeNode t = s.pop();
				al.add(t.val);
				if (t.left_ptr != null) {
					s.push(t.left_ptr);
				}
				if (t.right_ptr != null) {
					s.push(t.right_ptr);
				}
			}
			Collections.reverse(al);
			int len = al.size();
			output = new int[len];
			for (int ele : al) {
				output[i] = ele;
				i++;
			}
		}
		return output;
	}

}
