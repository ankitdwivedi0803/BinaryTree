package BinaryTreeEasey;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SerializeAndDeSerializeTree {

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
		System.out.println(convertSerializeFormat(root));

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

	public String convertSerializeFormat(Node root) {
		if (root == null)
			return "";
		Queue<Node> q = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		q.add(root);
		while (!q.isEmpty()) {
			Node currNode = q.remove();

			if (currNode == null) {
				res.append("n ");
				continue;
			}
			res.append(currNode.val + " ");
			q.add(currNode.left);
			q.add(currNode.right);
		}

		return res.toString();
	}

	public Node deSerialize(String data) {
		if (data == "")
			return null;

		Queue<Node> q = new LinkedList();
		String[] value = data.split(" ");
		Node root = new Node(Integer.parseInt(value[0]));
		q.add(root);

		for (int i = 1; i < value.length; i++) {
			Node parent = q.remove();
			if (!value[i].equals('n')) {
				Node left = new Node(Integer.parseInt(value[i]));
				parent.left = left;
				q.add(left);
			}
			if (!value[++i].equals('n')) {
				Node right = new Node(Integer.parseInt(value[i]));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		SerializeAndDeSerializeTree s = new SerializeAndDeSerializeTree();
		s.insertRootElement();
	}

}
