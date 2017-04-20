package algorithms;

public class TrieTree2 {
	
	public class Node{
		public int path;
		public int end;
		public Node[] children;
		
		public Node(){
			children = new Node[26];
		}
	}
	private Node root;
	
	public TrieTree2(){
		root = new Node();
	}
	
	public void insert(String s1){
		char[] str = s1.toCharArray();
		Node cur = root;
		for(int i=0;i<str.length;i++){
			int index = str[i]-'a';
			if(cur.children[index]==null){
				cur.children[index] = new Node();
			}
			cur = cur.children[index];
			cur.path++;
		}
		cur.end++;
	}
	
	public boolean search(String s1){
		Node cur = root;
		char[] str = s1.toCharArray();
		for(int i=0;i<str.length;i++){
			int index = str[i]-'a';
			if(cur.children[index] == null){
				return false;
			}
			cur = cur.children[index];
		}
		return cur.end != 0;
	}
	
	public void delete(String s1){
		if(search(s1)){
			char[] str = s1.toCharArray();
			Node cur = root;
			for(int i=0; i<str.length;i++){
				int index = str[i]-'a';
				cur = cur.children[index];
				cur.path--;
			}
			cur.end--;
		}
		return;
	}
	
	public static void main(String[] args){
		TrieTree2 tree = new TrieTree2();
		String s1 = "abdaiuhrkjd";
		tree.insert(s1);
		System.out.print(tree.search(s1)+"\n");
		int res = 'A'-'a';
		System.out.println(res);
	}

}
