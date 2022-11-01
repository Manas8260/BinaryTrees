package BinaryTree;

import java.util.*;

public class Node_at_a_distance_of_K {

	public static void main(String[] args) {
		
	}
	static void markParents(Node root,Map<Node,Node>parent_track,Node target) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if(current.left != null) {
				parent_track.put(current.left, root);
				queue.add(current.left);
			}
			if(current.right != null) {
				parent_track.put(current.right, root);
				queue.add(current.right);
			}
		}
	}
	static List<Integer> distanceK(Node root,Node target,int k){
		Map<Node ,Node> parent_track = new HashMap<>();
		markParents(root, parent_track, target);
		Map<Node,Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(target);
		visited.put(target, true);
		int curr_level = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			if(curr_level == k)break;
			
			curr_level++;
			for(int i = 0 ;i < size ;i++) {
				Node current = q.poll();
				if(current.left != null && visited.get(current.left) == null) {
					q.add(current.left);
					visited.put(current.left, true);
				}
				if(current.right != null && visited.get(current.right) == null) {
					q.add(current.right);
					visited.put(current.right, true);
				}
				if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
					q.add(parent_track.get(current));
					visited.put(parent_track.get(current), true);
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			Node curr = q.poll();
			result.add(curr.data);					
		}
		return result;
	}
	
	

}













