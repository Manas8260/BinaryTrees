package BinaryTree;

import java.util.*;
//life is a beach aur ,
//mai wave ki talash par hun ;
public class Construct_BT_from_IN_and_post_Order {

	public static void main(String[] args) {
		
				
	}
	static Node buildTree(int []preO,int []inO) {
		Map<Integer,Integer> inMap = new HashMap<>();
		for(int i = 0 ; i < inO.length ;i++)
			inMap.put(inO[i], i);
		
		Node root = buildTree(preO, 0, preO.length-1, inO, 0, inO.length-1, inMap);
		return root;
	}
	static Node buildTree(int[] preO,int preS,int preE,int[]inO,
			int inS,int inE,Map<Integer,Integer> inMap) {
		
		if(preS > preE ||inS > inE)
			return null;
		
		Node root = new Node(preO[preS]);
		
		int inRoot = inMap.get(root.data);
		int numsleft = inRoot - inS;
		
		root.left = buildTree(preO, preS+1, preS+numsleft, inO, inS, inRoot-1, inMap);
		
		root.right = buildTree(preO, preS+numsleft+1, preE, inO, inRoot+1, inE, inMap);
		
		return root;
		
	}

}
