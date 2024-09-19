package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class LevelOrderZigZagOrder {

	Scanner sc = new Scanner(System.in);
	private int zigZag;

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
		System.out.println(ZigZagLevelOrder(root));
	}

	private void insertValue(Node node) {
		// TODO Auto-generated method stub
		System.out.println("Do you want insert the value of left " + node.val);
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

	private List<List<Integer>> ZigZagLevelOrder(Node node) {
		List<List<Integer>> storeZigZag = new ArrayList<List<Integer>>();
		if (node == null)
			return storeZigZag;

		boolean directionIndicator = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> storeElement = new ArrayList<Integer>();

			// level process
			for (int i = 0; i < size; i++) {
				Node currNode = queue.remove();
				storeElement.add(currNode.val);

				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
			}

			// Reverse the list if the direction is from right to left
			if (!directionIndicator) {
				Collections.reverse(storeElement);
			}

			directionIndicator = !directionIndicator;
			storeZigZag.add(storeElement);
		}
		return storeZigZag;
	}

	public static void main(String[] args) {

		LevelOrderZigZagOrder zig = new LevelOrderZigZagOrder();
		zig.insertRootElement();
		List<List<Integer>> li= new ArrayList<List<Integer>>();
		TreeMap<Integer, List<Integer>> tmap = new TreeMap(); 
        Queue<Node> q =new LinkedList();
	}

}
