package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BanyTreeImpletations {
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

	public void display() {
		display(root, "");
	}

	public void display(Node node, String indent) {
		if (node == null) {
			return;
		}
		System.out.println(indent + node.val);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");
	}

	public static void main(String[] args) {

		BanyTreeImpletations bt = new BanyTreeImpletations();
		bt.insertRootElement();
		bt.display();
		bt.sc.close();
		List<Integer> val = new ArrayList<Integer>();
	}
}
