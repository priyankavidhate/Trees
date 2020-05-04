
public class LCA {
	class Node {
		int data;
		Node left;
		Node right;
	}

	int lca(Node head, Node a, Node b) {
		if (head == null)
			return 0;
		if (head.data == a.data || head.data == b.data)
			return head.data;
		int left = lca(head.left, a, b);
		int right = lca(head.right, a, b);
		if (left != 0 && right != 0) {
			return head.data;
		}
		if (left == 0 && right == 0) {
			return 0;
		}
		return (left != 0) ? left : right;
	}
}
