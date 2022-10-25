package BinaryTree;

import java.util.*;

public class Check_if_the_TREE_isBALANCED {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		System.out.println(isBalanced(root));
		System.out.println(height(root));
		
		
	}
	static boolean isBalanced(Node root) {
		return height(root) != -1;
	}
	static int height(Node root) {
		if(root == null)
			return 0;
		int lh = height(root.left);
		if(lh == -1)
			return-1;
		int rh = height(root.right);
		if(rh == -1)
			return -1;
		
		if(Math.abs(rh-lh) > 1)
			return -1;
		
		return Math.max(lh, rh)+1;
	}
}
