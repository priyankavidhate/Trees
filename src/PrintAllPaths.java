/*Given a binary tree, return all paths from root to leaf.*/
import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
	private static class TreeNode {
		public int val;
		public TreeNode left_ptr;
		public TreeNode right_ptr;
	}

	static List<List<Integer>> allPathsOfABinaryTree(TreeNode root) {
		if (root == null)
			return null;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> onePath = new ArrayList<Integer>();
		allPathsHelper(root, results, onePath);
		return results;
	}

	static void allPathsHelper(TreeNode root, List<List<Integer>> results, List<Integer> onePath) {
		if (root == null)
			return;
		onePath.add(root.val);
		if (root.left_ptr == null && root.right_ptr == null) {
			results.add(onePath);
			for (Integer i : onePath)
			if (onePath.size() > 0)
				onePath.remove(onePath.size() - 1);
			return;
		}
		if (root.left_ptr != null)
			allPathsHelper(root.left_ptr, results, onePath);
		if (root.right_ptr != null)
			allPathsHelper(root.right_ptr, results, onePath);
		if (onePath.size() > 0)
			onePath.remove(onePath.size() - 1);
	}
}
