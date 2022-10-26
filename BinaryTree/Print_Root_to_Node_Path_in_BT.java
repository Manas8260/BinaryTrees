package BinaryTree;

import java.util.ArrayList;
public class Print_Root_to_Node_Path_in_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static boolean getPath(Node root,ArrayList<Integer> a,int x) {
		if(root == null) 
			return false;
		
		a.add(root.data);
		if(root.data == x) 
			return true;
		if(getPath(root.left, a, x)||getPath(root.left, a, x))
			return true;
		
		a.remove(a.size()-1);
		return false;
	}
	static ArrayList<Integer> solve(Node a, int b){
		ArrayList<Integer> al = new ArrayList<>();
		if(a == null)return al;
		getPath(a, al, b);
		return al;
	}
}







