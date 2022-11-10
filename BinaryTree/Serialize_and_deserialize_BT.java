package BinaryTree;

import java.util.*;
public class Serialize_and_deserialize_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.left.right= new Node(7);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		System.out.println(serialize(root));
	}
	static String serialize(Node root) {
		if(root == null)
			return "";
		Queue<Node> q = new LinkedList<>();
		String res = "";
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node == null) {
				res += "n ";
				continue;
			}
			res += node.data+" ";
				q.add(node.left);
				q.add(node.right);
		}
		return res;
	}
	static Node deserialize(String data) {
		if(data == "")
			return null;
			
		Queue<Node> q = new LinkedList<>();
		String vals[] = data.split(" ");
		Node root = new Node(Integer.parseInt(vals[0]));
		
		q.add(root);
		for(int i = 1 ;i < vals.length ;i++) {
			Node prnt = q.poll();
			if(!vals[i].equals("n")) {
				Node left = new Node(Integer.parseInt(vals[i]));
				prnt.left = left;
				q.add(left);
			}
			if(!vals[++i].equals("n")) {
				Node right = new Node(Integer.parseInt(vals[i]));
				prnt.right = right;
				q.add(right);
			}
		}
		return root;
	}
	
}






















