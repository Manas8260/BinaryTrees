package BinaryTree;

import java.util.*;

public class ZIG_ZAG_traversal_OR_spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		List<List<Integer>> al = ziglevelOrder(root);
		for(int i = 0 ; i < al.size() ;i++) {
			List<Integer> x = al.get(i);
			for(int j = 0 ; j < x.size() ;j++) {
				System.out.print(x.get(j)+" ");
			}
			System.out.println();
		}
		

	}
	static  List<List<Integer>> ziglevelOrder(Node root){
		
		 List<List<Integer>> result= new LinkedList<>();
		 if(root == null)
			 return result;
		 
		 Queue<Node> nodesQ = new LinkedList<>();
		 nodesQ.add(root);
		 boolean l2r = true; 
		 while(!nodesQ.isEmpty()) {
			 int size = nodesQ.size();
				List<Integer> row = new LinkedList<>();
			 for(int i = 0;i < size ;i++) {
				 if(nodesQ.peek().left != null)nodesQ.add(nodesQ.peek().left);
				 if(nodesQ.peek().right != null)nodesQ.add(nodesQ.peek().right);
				 		 
				 row.add(nodesQ.poll().data);
			 }
			 if(!l2r) {
				 Collections.reverse(row);
			 }
			 result.add(row);
			 l2r = !l2r;//flags
		 }
		 return result;
	}

}
