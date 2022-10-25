package BinaryTree;

import java.util.*;

public class RIGHT_LEFT_view_of_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		ArrayList<Integer> al = new ArrayList<>();
		rightView(root, al, 0);
		System.out.println(al);
		ArrayList<Integer> al2 = new ArrayList<>();
		leftView(root, al2, 0);
		System.out.println(al2);
	}
	static void rightView(Node root,List<Integer> res,int curDepth) {
		if(root == null)
			return ;
		if(curDepth == res.size())
			res.add(root.data);
		
		rightView(root.right, res, curDepth+1);
		rightView(root.left, res, curDepth+1);
	}
	static void leftView(Node root,List<Integer> res,int curDepth) {
		if(root == null)
			return ;
		if(curDepth == res.size())
			res.add(root.data);
		
		leftView(root.left, res, curDepth+1);
		leftView(root.right, res, curDepth+1);
	}

}
