package BinaryTreeEasey;


import java.util.List;
import java.util.Scanner;

import BinaryTreeEasey.LevelOrderZigZagOrder.Node;

public class BoundaryTraversal {

	//User function Template for Java

	// class Node  
	// { 
//	     int data; 
//	     Node left, right; 
	   
//	     public Node(int d)  
//	     { 
//	         data = d; 
//	         left = right = null; 
//	     } 
	// }

	
	   /* public  void addLeftNodes(Node node, ArrayList <Integer> ansList){
	        if(node == null || (node.left == null && node.right == null)) return;
	        
	        ansList.add(node.data);
	        if(node.left != null) addLeftNodes(node.left, ansList);
	        else addLeftNodes(node.right, ansList);
	    }
	    public  void addLeafNodes(Node node, ArrayList <Integer> ansList){
	        if (node == null) return;
	        if (node.left == null && node.right == null) {
	            ansList.add(node.data);
	            return;
	        }
	        addLeafNodes(node.left,ansList);
	        addLeafNodes(node.right,ansList);
	    }
	    public  void addRightNodes(Node node, ArrayList <Integer> ansList){
	        if(node == null || node.left == null && node.right == null){
	            return;
	        }
	        
	        if(node.right!=null) addRightNodes(node.right, ansList);
	        else addRightNodes(node.left, ansList);
	        
	        // now at this time function will do back track at this point will add the right loot
	        ansList.add(node.data);
	    }
		ArrayList <Integer> boundary(Node node)
		{
		    ArrayList <Integer> ansList = new ArrayList<Integer>();
		    
		    if(node == null) return ansList;
		    
		    ansList.add(node.data);
		    // add all left node expect leaf nodes
		    addLeftNodes(node.left,ansList);
		    // add all leaf nodes both right and left subtree
		    // adding left side leaf node
		    addLeafNodes(node.left,ansList);
		    // add all leaf node right side 
		    addLeafNodes(node.right,ansList);
		    // add all right node expcet leaft node but in a reverse order
		    addRightNodes(node.right,ansList);
		    
		    // now return the ansList value 
		    return ansList;
		}
	}
	*/
}
