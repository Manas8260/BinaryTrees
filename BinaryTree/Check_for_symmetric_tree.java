package BinaryTree;

public class Check_for_symmetric_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public boolean isSymmetric(Node root) {
		return root == null || isSymmetrichelp(root.left,root.right);
		
	}
	public boolean isSymmetrichelp(Node left,Node right) {
		if(left == null || right == null) {
			return left == right;
		}
		if(left.data != right.data)return false;
		
		return isSymmetrichelp(left.left, right.right)&&isSymmetrichelp(left.right, right.left);
	}

}
