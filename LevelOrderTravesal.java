package BinaryTreeEasey;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrderTravesal {

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
		// levelOrderTraversal(root);
		// System.out.println("Number of nodes inserted -> " + getNumberOfNodes(root, 0,
		// 0));
		// System.out.println("summetion of of nodes inserted -> " +
		// getSumOfAllNodesValue(root, 0));
		// System.out.println("maximum height of tree " + getMaxHeight(root));
	}

	public int isBalanced(Node root) {

		if (root == null)
			return 0;
		int left = isBalanced(root.left);
		int right = isBalanced(root.right);

		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public int getMaxHeight(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return getMaxHeight(root.left) > getMaxHeight(root.right) ? getMaxHeight(root.left) + 1
				: getMaxHeight(root.right) + 1;
	}

	private int getSumOfAllNodesValue(Node node, int sum) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;

		return getSumOfAllNodesValue(node.left, sum) + getSumOfAllNodesValue(node.right, sum) + node.val;
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

	public int getNumberOfNodes(Node root, int leftCount, int rightCount) {
		if (root == null)
			return 0;

		return getNumberOfNodes(root.left, leftCount, rightCount) + getNumberOfNodes(root.right, leftCount, rightCount)
				+ 1;
	}

	public void levelOrderTraversal(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		System.out.println("this soluation might throw an exception");

		while (!q.isEmpty()) {

			Node currNode = q.remove();
			if (currNode == null) {
				System.out.println();

				if (q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}

			} else {
				System.out.println(currNode.val);
				if (currNode.left != null)
					q.add(currNode.left);
				if (currNode.right != null)
					q.add(currNode.right);

			}

		}

	}

	public static void main(String[] args) {

		LevelOrderTravesal lot = new LevelOrderTravesal();
		// lot.insertRootElement();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		System.out.println(stack.pop());

	}

}
