package BinaryTree;

import java.util.*;
public class MorrisTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(40);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(30);
		root.right.right = new Node(9);
		System.out.println(InO(root));
		
	}
	static ArrayList<Integer> InO(Node root){
		ArrayList<Integer> inOr = new ArrayList<>();
		Node cur = root;
		while(cur != null) {
			if(cur.left == null) {
				inOr.add(cur.data);
				cur = cur.right;
			} 
			else{
			  Node prev = cur.left;
			  while(prev.right != null && prev.right != cur) {
				  prev = prev.right;
			  }
			  if(prev.right == null) {
				  prev.right = cur;
				  cur = cur.left;
			  }else {
				  prev.right = null;
				  inOr.add(cur.data);
				  cur = cur.right;
			  }
			}
			
		}
		return inOr;
	}
	static ArrayList<Integer> preO(Node root){
		ArrayList<Integer> preOr = new ArrayList<>();
		Node cur = root;
		while(cur != null) {
			if(cur.left == null) {
				preOr.add(cur.data);
				cur = cur.right;
			} 
			else{
			  Node prev = cur.left;
			  while(prev.right != null && prev.right != cur) {
				  prev = prev.right;
			  }
			  if(prev.right == null) {
				  prev.right = cur;
				  preOr.add(cur.data);
				  cur = cur.left;
			  }else {
				  prev.right = null;
				  cur = cur.right;
			  }
			}
			
		}
		return preOr;
	}

}
