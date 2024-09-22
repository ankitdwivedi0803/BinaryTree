package BinaryTreeEasey;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TimeTakeBurnAllTree {

	Scanner sc = new Scanner(System.in);
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
		System.out.println("Enter the target Value:");
		int target = sc.nextInt();
		System.out.println(burnAllTree(root, target));

	}

	private Node findTargetNode(Node root, int target) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		if (root.val == target)
			return root;
		return findTargetNode(root.left, target) != null ? findTargetNode(root.left, target)
				: findTargetNode(root.right, target);
	}

	private void markParent(Node root, Map<Node, Node> parent_track) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {

			Node currNode = queue.remove();

			if (currNode.left != null) {
				parent_track.put(currNode.left, currNode);
				queue.add(currNode.left);
			}
			if (currNode.right != null) {
				parent_track.put(currNode.right, currNode);
				queue.add(currNode.right);
			}

		}

	}

	public int burnAllTree(Node root, int targetValue) {

		Node target = findTargetNode(root, targetValue);
		if (target == null)
			return 0;
		Map<Node, Node> parent_track = new HashMap();
		markParent(root, parent_track);
		Queue<Node> q = new LinkedList();
		Map<Node, Boolean> visited = new HashMap();
		q.add(target);
		visited.put(target, true);
		int timeTaken = 0;
		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node currNode = q.remove();
				if (currNode.left != null && visited.get(currNode.left) == null) {
					q.add(currNode.left);
					visited.put(currNode.left, true);
				}
				if (currNode.right != null && visited.get(currNode.right) == null) {
					q.add(currNode.right);
					visited.put(currNode.right, true);
				}
				if (parent_track.get(currNode) != null && visited.get(parent_track.get(currNode)) == null) {
					q.add(parent_track.get(currNode));
					visited.put(parent_track.get(currNode), true);
				}

			}

			timeTaken = timeTaken + 1;

		}
		return timeTaken - 1;
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
		TimeTakeBurnAllTree time = new TimeTakeBurnAllTree();
		time.insertRootElement();

	}

}
