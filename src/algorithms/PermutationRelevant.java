/**
 * Created by fang on 5/16/17.
 */
public class PermutationRelevant {
    public void subset(int[]A, int k , int start, int currLen,boolean[]used){
        if(currLen == k){
            for(int i=0;i<A.length;i++){
                if(used[i] == true){
                    System.out.print(A[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        if(start==A.length){
            return;
        }
        used[start] = true;
        subset(A,k,start+1,currLen+1,used);
        used[start] = false;
        subset(A,k,start+1,currLen,used);
    }

    public static void main(String[] args){
        PermutationRelevant solution = new PermutationRelevant();
        int[] nums = {1,2,3,4};
        boolean[] B = new boolean[nums.length];
        solution.subset(nums,3,0,0,B);

    }
}
