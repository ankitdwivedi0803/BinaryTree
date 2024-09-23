package BinaryTreeEasey;

import java.util.Scanner;

public class CountTheNodesInABalanceTree {

	Scanner sc = new Scanner(System.in);
	int maxHeight = Integer.MIN_VALUE;
	public boolean indicator = false;
	public int count = 0;

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
		System.out.println(calculateHeight(root));

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

	private int calculateHeight(Node root) {
		if (root == null)
			return 0;

		int leftSide = giveHeightLeft(root);
		int rightSide = giveHeightRight(root);
		if (leftSide == rightSide)
			return (int) Math.pow(2, rightSide);
		else
			return 1 + calculateHeight(root.left) + calculateHeight(root.right);

	}

	private int giveHeightLeft(Node root) {
		// TODO Auto-generated method stub
		int count = 0;
		while (root != null) {
			count++;
			root = root.left;
		}
		return count;
	}

	private int giveHeightRight(Node root) {
		// TODO Auto-generated method stub
		int count = 0;
		while (root != null) {
			count++;
			root = root.right;
		}
		return count;
	}

	public static void main(String[] args) {
		// CountTheNodesInABalanceTree count = new CountTheNodesInABalanceTree();

		CountTheNodesInABalanceTree count = new CountTheNodesInABalanceTree();
		count.insertRootElement();

	}

}
