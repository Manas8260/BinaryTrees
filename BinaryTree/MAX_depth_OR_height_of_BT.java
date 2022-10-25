package BinaryTree;

import java.util.*;

public class MAX_depth_OR_height_of_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.right.left = new Node(4);
//		root.right.right = new Node(6);
//		root.right.left.right = new Node(5);
//		root.right.left.right.left = new Node(9);
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		System.out.println(maxDepth(root));
		System.out.println(Using_levelOrder(root));
	}
	static int maxDepth(Node root) {
		if(root == null) return 0;
		
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		
		return 1+Math.max(lh, rh);
	}
	static int Using_levelOrder(Node root){
		Queue<Node> Q = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<>();
		if(root == null)
			return wrapList.size();
		
		Q.add(root);
		while(!Q.isEmpty()) {
			int levelnum = Q.size();
			List<Integer> sublist = new LinkedList<>();		
			
			for(int i = 0; i< levelnum; i++) {
				if(Q.peek().left != null)
					Q.add(Q.peek().left);
				
				if(Q.peek().right != null)
					Q.add(Q.peek().right);
				
				sublist.add(Q.poll().data);
			}
			wrapList.add(sublist);
		}
		return wrapList.size();
	}
	

}
