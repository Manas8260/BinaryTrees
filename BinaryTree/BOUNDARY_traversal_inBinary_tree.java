package BinaryTree;

import java.util.ArrayList;

class Node{
	int data ;
	Node left,right;
	public Node(int key) {
		data = key;
		left = null;
		right = null;
	}
}
public class BOUNDARY_traversal_inBinary_tree {

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
		ArrayList<Integer> al = printboundary(root);
		for(int i = 0;i< al.size() ;i++) {
			System.out.print(al.get(i)+" ");
		}
		
	}
	static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}
	static void addleftBoundary(Node root,ArrayList<Integer> res) {
		Node cur = root.left;
		while(cur != null) {
			if(!isLeaf(cur))
				res.add(cur.data);
			if(cur.left != null) 
				cur = cur.left;
			else
				cur = cur.right;
		}
	}
	static void addrightBoundary(Node root,ArrayList<Integer> res) {
		Node cur = root.right;
		ArrayList<Integer> tmp = new ArrayList<>();
		while(cur != null) {
			if(!isLeaf(cur))
				tmp.add(cur.data);
			if(cur.right != null)
				cur = cur.right;
			else
				cur = cur.left;
		}
		for(int i = tmp.size()-1 ;i >=0 ;i--) 
			res.add(tmp.get(i));
	}
	static void addleaves(Node root,ArrayList<Integer> res) {
		if(isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if(root.left != null)
			addleaves(root.left, res);
		if(root.right != null)
			addleaves(root.right, res);
	}
	static ArrayList<Integer> printboundary(Node root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(!isLeaf(root))
			ans.add(root.data);
		addleftBoundary(root, ans);
		addleaves(root, ans);
		addrightBoundary(root, ans);
		return ans;
	}

}

















