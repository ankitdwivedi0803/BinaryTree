package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import BinaryTreeEasey.TopViewTraversal.Node;

public class RootTolLeafPath {

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
		System.out.println(getPath(root));
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

	private ArrayList<ArrayList<Integer>> getPath(Node root) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ansList;
		ArrayList<Integer> list = new ArrayList();
		findPath(root, list, ansList);
		return ansList;
	}

	private void findPath(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ansList) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		list.add(root.val);
		if (root.left == null && root.right == null) {
			ansList.add(new ArrayList<Integer>(list));
		}
		findPath(root.left, list, ansList);
		findPath(root.right, list, ansList);

		list.remove(list.size() - 1);
	}

	public static void main(String[] args) {

		RootTolLeafPath rtl = new RootTolLeafPath();
		rtl.insertRootElement();
	}

}
