package BinaryTreeEasey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTreeEasey.LCABinaryTree.Node;

public class MaxWidthOfTree {

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

		System.out.println(getMaxWidth(root));

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

	public int getMaxWidth(Node root) {
		if (root == null)
			return 0;

		return findMaxWidth(root, 0);
	}

	private int findMaxWidth(Node root, int i) {
		// TODO Auto-generated method stub
		Deque<Node> q = new ArrayDeque();
		Deque<Integer> index = new ArrayDeque();
		int maxWidth = Integer.MIN_VALUE;
		q.add(root);
		index.add(i);

		while (!q.isEmpty()) {
			int n = q.size();
			int frontIndex = index.peekFirst();
			int backIndex = index.peekLast();
			maxWidth = Math.max(maxWidth, backIndex - frontIndex + 1);
			for (int j = 0; j < n; j++) {
				Node currNode = q.removeFirst();
				int currIndex = index.removeFirst();
				if (currNode.left != null) {
					q.add(currNode.left);
					index.add((2 * currIndex + 1));
				}
				if (currNode.right != null) {
					q.add(currNode.right);
					index.add((2 * currIndex + 2));
					// we can also able to take one queue in map format

				}

			}

		}
		return maxWidth;
	}

	public static void main(String[] args) {
		MaxWidthOfTree mwo = new MaxWidthOfTree();
		mwo.insertRootElement();

	}

}
