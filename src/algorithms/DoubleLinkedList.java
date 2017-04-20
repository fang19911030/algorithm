package algorithms;

public class DoubleLinkedList {
	public class Node{
		public int data;
		public Node next;
		public Node pre;
		
		public Node(int x){
			data = x;
			next = null;
			pre = null;
		}
	}
	
	public Node head;
	public Node tail;
	
	public DoubleLinkedList(int x){
		Node n = new Node(x);
		head = n;
		tail = n;
	}
	
	public void add(int i){
		Node n = new Node(i);
		Node cur = tail;
		cur.next = n;
		n.pre = cur;
		tail = n;
	}
	
	public void delete(){
		Node cur = tail;
		tail = cur.pre;
		tail.next = null;
	}
	public void print(){
		Node cur = head;
		while(cur!= null){
			System.out.print(cur.data+" ");
	        cur = cur.next;
		}
	}
	
	public void tailPrint(){
		Node cur = tail;
		while(cur!= null){
			System.out.print(cur.data+" ");
			cur = cur.pre;
		}
	}
	public static void main(String[] args){
		DoubleLinkedList list = new DoubleLinkedList(1);
		for(int i=2;i<25;i++){
			list.add(i);
		}
		list.tailPrint();
	}

}
