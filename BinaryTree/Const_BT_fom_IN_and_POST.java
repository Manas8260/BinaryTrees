package BinaryTree;

import java.util.*;

public class Const_BT_fom_IN_and_POST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static Node buildTree(int []inO,int []postO) {
		HashMap<Integer,Integer> inMap = new HashMap<>();
		for(int i = 0 ; i < inO.length ;i++)
			inMap.put(inO[i], i);
		
		Node root = buildTreePostIn(inO, 0, inO.length-1, postO, 0, postO.length-1, inMap);
		return root;
	}

	static Node buildTreePostIn(int[]inO,int is,int ie,int [] postO,int ps,int pe,HashMap<Integer,Integer> hm)
	{
		if(ps > pe || is>ie)
			return null;
		Node root= new Node(postO[pe]);
		
		int inRoot = hm.get(postO[pe]);
		int numsleft = inRoot-is;
		
		root.left = buildTreePostIn(inO, is, inRoot-1, postO, ps, ps+numsleft-1, hm);
		root.right = buildTreePostIn(inO, inRoot+1, ie, postO, ps+numsleft, pe-1, hm);
		
		return root;
	}

}
