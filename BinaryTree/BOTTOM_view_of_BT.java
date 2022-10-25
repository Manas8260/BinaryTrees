package BinaryTree;

import java.util.*;

public class BOTTOM_view_of_BT {

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
		ArrayList<Integer> al = bottomV(root);
		for(int i = 0;i< al.size() ;i++) {
			System.out.print(al.get(i)+" ");
		}
				
	}

	static ArrayList<Integer> bottomV(Node root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null)
			return ans;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		Map<Integer, Integer> map = new TreeMap<>();
		while(!q.isEmpty()) {
			Pair it = q.remove();
			Node node = it.node;
			int hd = it.num;
			map.put(hd, it.node.data);
			if(node.left != null) {
				q.add(new Pair(node.left, hd-1));
			}
			if(node.right != null) {
				q.add(new Pair(node.right, hd+1));
			}
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}
}
