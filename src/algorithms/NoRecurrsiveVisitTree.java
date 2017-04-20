package algorithms;
import java.util.*;

public class NoRecurrsiveVisitTree {
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		
		public Node(int x){
			val = x;
		}
	}
	
	public static void PostOrder(Node root){
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			root = s1.pop();
			s2.push(root);
			if(root.right != null){
				s1.push(root.right);
			}
			if(root.left != null){
				s1.push(root.left);
			}
		}
		while(!s2.isEmpty()){
			System.out.print(s2.pop().val+" ");
		}
	}
	
	public static void preOrder(Node root){
		Stack<Node> s1 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			root = s1.pop();
			System.out.print(root.val+" ");
			if(root.right != null){
				s1.push(root.right);
			}
			if(root.left != null){
				s1.push(root.left);
			}
		}
	}
	
	public static void main(String[] args){
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		System.out.println("Post order: ");
		preOrder(root);
	}

}
