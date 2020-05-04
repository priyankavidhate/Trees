import java.util.ArrayList;
import java.util.List;

public class MergeBSTs {

	public static Node mergeTwoBSTs(Node root1, Node root2) {

		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		inorder(root1, l1);
		inorder(root2, l2);
		List<Integer> r = merge(l1, l2);
		// System.out.println(r.toArray());
		return makeTree(r, 0, r.size() - 1);
	}

	static Node makeTree(List<Integer> l, int start, int end) {

		if (end < start)
			return null;

		int mid = start + (end - start) / 2;

		Node n = new Node(l.get(mid));
		n.left = null;
		n.right = null;

		n.left = makeTree(l, start, mid - 1);
		n.right = makeTree(l, mid + 1, end);

		return n;

	}

	public static void inorder(Node root, List<Integer> l) {
		if (root == null)
			return;

		inorder(root.left, l);
		l.add(root.key);
		inorder(root.right, l);
	}

	public static List<Integer> merge(List<Integer> l1, List<Integer> l2) {

		int ctr1 = 0;
		int ctr2 = 0;
		List<Integer> result = new ArrayList();
		while (ctr1 < l1.size() && ctr2 < l2.size()) {

			if (l1.get(ctr1) < l2.get(ctr2)) {
				result.add(l1.get(ctr1));
				ctr1++;
			} else {
				result.add(l2.get(ctr2));
				ctr2++;
			}

		}

		for (int i = ctr1; i < l1.size(); ++i)
			result.add(l1.get(i));
		for (int j = ctr2; j < l2.size(); ++j)
			result.add(l2.get(j));

		return result;
	}
}
