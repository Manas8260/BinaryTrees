package BinaryTree;

import java.util.*;
public class Maximum_width_Of_BT {

	public static void main(String[] args) {

	}
	static int widthOFbt(Node root) {
		if(root == null) 
			return 0;
		int ans = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root,0));
		while(!q.isEmpty()) {
			int size = q.size();
			int mmin = q.peek().num;
			int first = 0,last = 0;
			for(int i = 0 ; i< size ;i++) {
				int cur_id = q.peek().num-mmin;
				Node node = q.peek().node;
				
				q.poll();
				
				if(i == 0)first = cur_id;
				if(i == size-1)last = cur_id;
				if(node.left != null) {
					q.add(new Pair(node.left,cur_id*2+1));
				}
				if(node.right != null) {
					q.add(new Pair(node.right, cur_id*2+2));
				}
			}
			ans = Math.max(ans, last-first+1);
		}
		return ans;
	}

}









