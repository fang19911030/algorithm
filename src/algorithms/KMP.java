package algorithms;

public class KMP {
	public boolean contains(String s1, String s2){
		if(s1==null || s2 == null||s1.length()<s2.length()){
			return false;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int [] next = getNext(str2);
		int index1 = 0;
		int index2 = 0;
		while(index1<str1.length && index2<str2.length){
			if(str1[index1]==str2[index2]){
				index1++;
				index2++;
			}else if(next[index2]>=0){
				index2= next[index2];
			}else{
				index1++;
			}
		}
		if(index2>=str2.length && index1<=str1.length){
			return true;
		}
		return false;
	}
	
	private int[] getNext(char[] str2){
		int[] next = new int[str2.length];
		next[0]=-1;
		next[1]=0;
		int cn = 0;
		int pos =2;
		while(pos< str2.length){
			if(str2[pos-1]==str2[cn]){
				next[pos++]=++cn;
			}else{
				if(next[cn]==-1){
					pos++;
				}else{
					cn = next[cn];
				}
			}
		}
		return next;
	}
	public static void main(String[] args){
		String s1="123455432uxysjenx";
		String s2 = "45543";
		KMP solution = new KMP();
		System.out.println(solution.contains(s1,s2));
	}

}
