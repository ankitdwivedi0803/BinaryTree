package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import BinaryTreeEasey.TopViewTraversal.Node;

public class BottamViewTraversal {

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
//4 4 N 6 8 N 7 8 N 1 4 N 6 5 N 1 8 N 8 7 N 1 8 N 7 2 N 3 1
		insertValue(root);
		System.out.println(bottomViewTraversal(root));
	}

	private List<Integer> bottomViewTraversal(Node root) {
		// TODO Auto-generated method stub
		List<Integer> resultList = new ArrayList();

		// return the value if the value is already null
		if (root == null)
			return resultList;
		// use treemap in order to sort the keys
		TreeMap<Integer, List<Integer>> tmap = new TreeMap();
		getbottomViewData(root, 0, tmap);
		// Iterate over the entries in the TreeMap
		for (Map.Entry<Integer, List<Integer>> entry : tmap.entrySet()) {
			resultList.addAll(entry.getValue());
		}

		return resultList;
	}

	private void getbottomViewData(Node root, int col, TreeMap<Integer, List<Integer>> tmap) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList();
		Queue<Integer> index = new LinkedList();
		q.add(root);
		index.add(col);
		while (!q.isEmpty()) {
			Node currNode = q.remove();
			int currIndex = index.remove();
			if (!tmap.containsKey(currIndex)) {
				tmap.put(currIndex, new ArrayList());
				tmap.get(currIndex).add(currNode.val);
			} else if (tmap.containsKey(currIndex)) {
				tmap.put(currIndex, new ArrayList());
				tmap.get(currIndex).add(currNode.val);
			}

			if (currNode.left != null) {
				q.add(currNode.left);
				index.add(currIndex - 1);
			}
			if (currNode.right != null) {
				q.add(currNode.right);
				index.add(currIndex + 1);
			}

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

		BottamViewTraversal btv = new BottamViewTraversal();
		btv.insertRootElement();

	}

}
