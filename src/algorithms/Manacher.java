package algorithms;

public class Manacher {
	
	public char[] manacherString(String str){
		char[] charArr = str.toCharArray();
		char[] res = new char[charArr.length*2+1];
		int index =0;
		for(int i=0; i!= res.length;i++){
			res[i]=(i&1)==0? '#':charArr[index++];
		}
		return res;
	}
	
	public int maxLcpsLength(String str){
		if(str == null || str.length()==0){
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index =-1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for(int i=0;i!= charArr.length;i++){
			pArr[i]=pR>i? Math.min(pArr[2*index-i], pR-i):1;
			while(i+pArr[i]<charArr.length && i-pArr[i]>-1){       //i is center expand to left bound and right bound
				if(charArr[i+pArr[i]]==charArr[i-pArr[i]]){
					pArr[i]++;
				}else{
					break;
				}
			}
			if(i+pArr[i]>pR){                                    //update palidrome right bound and corresponding center
				pR = i+pArr[i];
				index =i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max-1;
	}
	
	public static void main(String[] args){
		String s="123454321";
		Manacher solution = new Manacher();
		int res = solution.maxLcpsLength(s);
		System.out.print(res);
	}

}
