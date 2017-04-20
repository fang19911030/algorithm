package algorithms;

public class TrieTree {
	public class Node{
		public int path;
		public int end;
		public Node[] children;
		
		public Node(){
			this.path = 0;
			this.end =0;
			this.children = new Node[26];
		}
		
	}
	
	
	private Node root;
	
	public TrieTree(){
		root = new Node();
	}
	
	
	public void insert(String s1){
		Node cur =  root;
		char[] str1 = s1.toCharArray();
		for(int i=0;i<str1.length;i++){
			int index = str1[i]-'a';
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
		char[] str1 = s1.toCharArray();
		for(int i = 0;i<str1.length;i++){
			int index = str1[i]-'a';
			if(cur.children[index]==null){
				return false;
			}
			cur = cur.children[index];
			
		}
		return cur.end!=0;
	}
	
	
	public void delete(String s1){
		if(search(s1)){
			Node cur = root;
			char[]str1 = s1.toCharArray();
			for(int i=0;i<str1.length;i++){
				int index = str1[i]-'a';
				if(cur.children[index].path--==1){                       //important
					cur.children[index] =null;
					return;
				}
				cur = cur.children[index];
			}
			cur.end--;
		}
		return;
	}
	
	public int prefixNumber(String pre){
		if(pre == null){
			return 0;
		}
		char[] chs = pre.toCharArray();
		
		Node node = root;
		int index = 0;
		for(int i=0;i<chs.length;i++){
			index = chs[i]-'a';
			if(node.children[index] == null){
				return 0;
			}
			node = node.children[index];
		}
		return node.path;
		
		
	}
	
	public static void main(String[] args){
		TrieTree tree = new TrieTree();
		String s1="dog";
		tree.insert(s1);
		String s2 = "bitch";
		tree.insert(s2);
		String s3 = "cock";
		tree.insert(s3);
		System.out.println(tree.search(s2));
	}
	
	

}
