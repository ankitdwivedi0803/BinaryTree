package BinaryTreeEasey;

import java.util.Scanner;

public class LCABinaryTree {

	Scanner sc = new Scanner(System.in);

	public class Node {
		Node left;
		int val;
		Node right;

		public Node() {

		}

		public Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public void insertRootElement() {
		System.out.println("Enter the root Element Value");

		root = new Node(sc.nextInt());

		insertValue(root);
		System.out.println("Enter the p node: ");
		int p = sc.nextInt();
		System.out.println("Enter the q node: ");
		int q = sc.nextInt();
		System.out.println(getLCA(root, p, q));

	}

	private void insertValue(Node node) {
		// TODO Auto-generated method stub
		System.out.println("Do you want insert value of left " + node.val);
		boolean left = sc.nextBoolean();
		if (left) {
			System.out.println("Please Enter the value ");
			node.left = new Node(sc.nextInt());
			insertValue(node.left);
		}
		System.out.println("Do you want insert value of right " + node.val);
		boolean right = sc.nextBoolean();
		if (right) {
			System.out.println("Please enter the value ");
			node.right = new Node(sc.nextInt());
			insertValue(node.right);
		}

	}

	public int getLCA(Node root, int p, int q) {
		if (root == null)
			return 0;

		return findLCA(root, p, q);
	}

	private int findLCA(Node root, int p, int q) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		if (root.val == p || root.val == q)
			return root.val;
		int leftVal = findLCA(root.left, p, q);
		int rightVal = findLCA(root.right, p, q);
		if (leftVal > 0 && rightVal > 0) {
			return root.val;
		} else {
			return leftVal > 0 ? leftVal : rightVal;
		}
	}

	public static void main(String[] args) {

		LCABinaryTree lca = new LCABinaryTree();
		lca.insertRootElement();

	}

}
