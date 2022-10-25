package BinaryTree;

import java.util.*;



public class POST_Order_usiong_one_stack {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(25);
		root.left = new Node(15);
		root.right = new Node(50);
		root.left.left = new Node(10);
		root.left.right = new Node(22);
		root.right.left = new Node(35);
		root.right.right = new Node(70);
		postO1stack(root);
		
	}
	static void postO1stack(Node root) {
		Node cur = root;
		Stack<Node> st = new Stack<>();
		ArrayList<Integer> pOO = new ArrayList<>();  
		Node temp= null;
		
		while(cur != null || !st.isEmpty()) {
			if(cur != null) {
				st.push(cur);
				cur = cur.left;
			}else {
				temp = st.peek().right;
				if(temp == null) {
					temp = st.pop();
					pOO.add(temp.data);
					while(!st.isEmpty() && temp == st.peek().right) {
						temp = st.pop();
						pOO.add(temp.data);
					}
				}else {
					cur = temp;
				}
			}
		}
		for(int i = 0;i < pOO.size() ;i++)
			System.out.print(pOO.get(i)+" ");
		
	}

}
