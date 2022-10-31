package BinaryTree;

public class Child_Sum_Property {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(40);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
		changeTree(root);
		System.out.println("       "+root.data);
		System.out.println("   "+root.left.data+"        "+root.right.data);
		System.out.println(root.left.left.data+"    "+root.left.right.data+"  "+root.right.left.data+"   "+root.right.right.data);
		
	}
	static void changeTree(Node root) {
		if(root == null)
			return ;
		int child = 0;
		if(root.left != null) child += root.left.data;
		if(root.right != null)child+= root.right.data;
		
		if(child >= root.data)
			root.data = child;
		else {
			if(root.left != null)
				root.left.data = root.data;
			if(root.right != null)
				root.right.data = root.data;
		}
		
		changeTree(root.left);
		changeTree(root.right);
		
		int tot = 0;
		if(root.left != null) tot+= root.left.data;
		if(root.right != null)tot += root.right.data;
		if(root.left != null || root.right != null)
			root.data = tot;
	
	}
}
