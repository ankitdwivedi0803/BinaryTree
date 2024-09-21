package BinaryTreeEasey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class DistanceNodes {
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
		System.out.println("Enter the Distance Range: ");
		int k = sc.nextInt();
		System.out.println(distanceK(root, target, k));

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

	private Node findTargetNode(Node root, int target) {
		if (root == null)
			return null;
		if (root.val == target)
			return root;
		Node left = findTargetNode(root.left, target);
		if (left != null)
			return left;
		return findTargetNode(root.right, target);
	}

	public void markParent(Node root, Map<Node, Node> parent_track, Node target) {
		Queue<Node> queue = new LinkedList<>();
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

	public List<Integer> distanceK(Node root, int targetValue, int k) {
		// Find the target node with the given value
		Node target = findTargetNode(root, targetValue);
		if (target == null)
			return new ArrayList<>(); // Target not found

		Map<Node, Node> parent_track = new HashMap<>();
		markParent(root, parent_track, target);
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(target);
		visited.put(target, true);
		int curr_level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (curr_level == k)
				break;
			curr_level++;
			for (int i = 0; i < size; i++) {
				Node currNode = queue.remove();
				if (currNode.left != null && visited.get(currNode.left) == null) {
					queue.add(currNode.left);
					visited.put(currNode.left, true);
				}
				if (currNode.right != null && visited.get(currNode.right) == null) {
					queue.add(currNode.right);
					visited.put(currNode.right, true);
				}
				if (parent_track.get(currNode) != null && visited.get(parent_track.get(currNode)) == null) {
					queue.add(parent_track.get(currNode));
					visited.put(parent_track.get(currNode), true);
				}
			}
		}
		List<Integer> ansList = new ArrayList<>();
		while (!queue.isEmpty()) {
			Node currNode = queue.remove();
			ansList.add(currNode.val);
		}
		return ansList;
	}

	public static void main(String[] args) {
		DistanceNodes d = new DistanceNodes();
		d.insertRootElement();
	}

}
