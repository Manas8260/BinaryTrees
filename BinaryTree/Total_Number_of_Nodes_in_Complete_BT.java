package BinaryTree;

import java.util.*;
public class Total_Number_of_Nodes_in_Complete_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.left.left = new Node(8);
		root.left.right.left = new Node(10);
		root.left.left.right = new Node(9);
		root.left.right.right= new Node(11);
		
		Node root1 = new Node(1);
		root1.left= new Node(2);
		root1.right= new Node(3);
		root1.left.left= new Node(4);
		root1.left.right= new Node(5);
		root1.right.left = new Node(6);
//		root1.right.right = new Node(7);
		System.out.println(countNodes(root1));
	}
	static int countNodes(Node root) {
		if(root == null)
			return 0;
		
		int left = getleftH(root);
		int right = getrightH(root);
		
		if(left == right)return (1<<left)-1;
		
		else return 1+countNodes(root.left)+countNodes(root.right);
	}
	static int getleftH(Node root) {
		int c = 0;
		while(root!= null) {
			c++;
			root = root.left;
		}
		return c;
	}
	static int getrightH(Node root) {
		int c = 0;
		while(root != null) {
			c++;
			root = root.right;
		}
		return c;
	}
}
