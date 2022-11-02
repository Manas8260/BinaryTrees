package BinaryTree;

import java.util.*;
public class Min_time_take_toBurn_entire_tree_from_a_node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.left.right= new Node(7);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		System.out.println(timeToBurn(root, root.left));
	}
	static void parentTrack(Node root,Map<Node,Node> trackP) {
		if(root == null)
			return ;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.left != null) {
				trackP.put(n.left, n);
				q.add(n.left);
			}
			if(n.right != null) {
				trackP.put(n.right, n);
				q.add(n.right);
			}
		}
	}
	static int timeToBurn(Node root,Node target) {
		Map<Node,Node> trackP = new HashMap<>();
		parentTrack(root, trackP);
		Map<Node,Boolean> visited= new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(target);
		visited.put(target,true);
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			int fl = 0;
			for(int i = 0 ; i < size ;i++) {
				Node curr = q.poll();
				if(curr.left != null && visited.get(curr.left) == null) {
					fl = 1;
					q.add(curr.left);
					visited.put(curr.left, true);
				}
				if(curr.right != null && visited.get(curr.right) == null) {
					fl = 1;
					q.add(curr.right);
					visited.put(curr.right, true);
				}
				if(trackP.get(curr) != null && visited.get(trackP.get(curr)) == null) {
					fl = 1;
					q.add(trackP.get(curr));
					visited.put(trackP.get(curr),true);
				}
			}

			if(fl == 1)time++;
		}
		return time;
	}

}
















