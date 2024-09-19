package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewTraversal {

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
		System.out.println(leftViewTraversal(root));
	}

	private List<Integer> leftViewTraversal(Node root) {
		// TODO Auto-generated method stub
		List<Integer> resultList = new ArrayList<Integer>();
		if (root == null)
			return resultList;
		List<List<Integer>> list = new ArrayList();
		getLeftViewData(root, list);
		for (List<Integer> li : list) {
			resultList.add(li.get(0));
		}

		return resultList;
	}

	private void getLeftViewData(Node root, List<List<Integer>> list) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList();
			for (int i = 0; i < size; i++) {
				Node currNode = q.remove();
				l.add(currNode.val);

				if (currNode.left != null)
					q.add(currNode.left);
				if (currNode.right != null)
					q.add(currNode.right);

			}
			list.add(l);

		}

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

	public static void main(String[] args) {
		LeftViewTraversal ltv = new LeftViewTraversal();
		ltv.insertRootElement();
		

	}

}
