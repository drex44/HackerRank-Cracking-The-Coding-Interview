package ctci;
//https://www.hackerrank.com/challenges/ctci-is-binary-search-tree

public class CheckBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// accepted
	boolean checkBST(Node1 root) {
		return helperBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	boolean helperBST(Node1 root, int min, int max) {
		if (root == null)
			return true;
		if (root.data <= min || root.data >= max)
			return false;
		return (helperBST(root.left, min, root.data) && helperBST(root.right, root.data, max));
	}

	//failed
	boolean checkBST1(Node1 root) {
		if (root == null)
			return true;
		if (root.left != null && root.left.data > root.data)
			return false;
		if (root.right != null && root.right.data < root.data)
			return false;
		return checkBST(root.left) && checkBST(root.right);
	}
}

class Node1 {
	int data;
	Node1 left;
	Node1 right;
}
