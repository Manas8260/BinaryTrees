package BinaryTree;

import java.util.*;
public class Binary_Tree_To_LinkedList {

	static Node prev = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left= new Node(2);
		root.right= new Node(5);
		root.left.left= new Node(3);
		root.left.right= new Node(4);
		root.right.right = new Node(6);
		root.right.right.left = new Node(7);
		flattenMORRIS(root);
		while(root!=null){
		      System.out.print(root.data+"->");
		      root=root.right;
		}
	}
	static void flattenREC(Node root) {
		if(root == null)
			return;
		flattenREC(root.right);
		flattenREC(root.left);
		
		root.right = prev;
		root.left = null;
		
		prev = root;
	}
	static void flattenITE(Node root) {
		if(root == null) return;
		Stack<Node> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			Node cur = st.pop();
			if(cur.right != null)
				st.push(cur.right);
			if(cur.left != null)
				st.push(cur.left);
			if(!st.isEmpty())
				cur.right = st.peek();
			cur.left = null;
		}
	}
	static void flattenMORRIS(Node root) {
		Node cur = root;
		while(cur != null) {
			if(cur.left != null) {
				Node prev = cur.left;
				while(prev.right != null)
					prev = prev.right;
				prev.right = cur.right;
				cur.right = cur.left;
			}
			cur = cur.right;
		}
	}
	
	
}
