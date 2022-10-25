package BinaryTree;

import java.util.*;


public class PreOrderBT {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right =new Node(3);
		root1.left.left =new Node(4);
		root1.left.right = new Node(5);
		root1.left.right.left =new Node(6);
		root1.right.left =new Node(7);
		root1.right.right = new Node(8);
		root1.right.right.left = new Node(9);
		root1.right.right.right = new Node(10);
		
		preOREC(root1);
		System.out.println();
		System.out.println(StriverPreO(root1));
		InRec(root1);
		System.out.println();
		System.out.println(StriverInO(root1));
	}
	static void preOREC(Node root) {
		if(root == null)
			return ;
		System.out.print(root.data+" ");
		preOREC(root.left);
		preOREC(root.right);
	}
	static ArrayList<Integer> StriverPreO(Node curr){
		ArrayList<Integer> po = new ArrayList<>();
		if(curr == null)
			return po;
		
		Stack<Node> s= new Stack<>();
		s.push(curr);
		
		while(!s.isEmpty()) {
			Node topNode = s.peek();
			po.add(topNode.data);
			s.pop();
			if(topNode.right != null)
				s.push(topNode.right);
			if(topNode.left != null)
				s.push(topNode.left);
		}
		return po;
	}
	static ArrayList<Integer> StriverInO(Node curr){
		ArrayList<Integer> io = new ArrayList<>();
		if(curr == null)
			return io;
		
		Stack<Node> s = new Stack<>();
		s.push(curr);
		while(!s.isEmpty()) {
			Node topNode = s.peek();
			if(topNode.left != null)
				s.push(topNode.left);
			
			io.add(topNode.data);
			
			s.pop();
			
			if(topNode.right != null)
				s.push(topNode.right);
		}
		return io;
	}
	static void InRec(Node root) {
		if(root == null) {
			return;
		}
		InRec(root.left);
		System.out.print(root.data +" ");
		InRec(root.right);
	}

}
