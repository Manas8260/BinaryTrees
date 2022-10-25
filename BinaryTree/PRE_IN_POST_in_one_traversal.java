package BinaryTree;

import java.util.*;
class Pair{
	Node node;
	int num;
	public Pair(Node _node,int _num) {
		node = _node;
		num = _num;
	}
}
public class PRE_IN_POST_in_one_traversal {

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        allOrders(root);
	}
	static void allOrders(Node root) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 1));
		
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();
		if(root == null) return ;
		
		while(!st.isEmpty()) {
			Pair it = st.pop();
			
			if(it.num == 1) {
				pre.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.left != null)
					st.push(new Pair(it.node.left,1));
			}
			else if(it.num == 2) {
				in.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.right != null) {
					st.push(new Pair(it.node.right,1));
				}
			}else if(it.num == 3){
				post.add(it.node.data);
//				st.pop();
			}
		}
			
		
		// print ANSWERS
		System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        
	}

}
