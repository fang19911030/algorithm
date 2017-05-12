/**
 * Created by fang on 5/12/17.
 */
public class DuplicateQuickSort {
    public void sort(int[]a, int l, int r){
        if(l<r){
            int[] q = partition(a, l ,r);
            sort(a,l,q[0]-1);
            sort(a,q[1]+1,r);
        }
    }

    private int[] partition(int[] a, int l, int r){
        int x = a[r];
        int[] res = new int[2];
        int j=l-1;
        for(int i=l;i<r;i++){
            if(a[i]<x){
                j++;
                swap(a,i,j);
            }
        }
        res[0] = j+1;

        for(int i=j+1;i<r;i++){
            if(a[i]==x){
                j++;
                swap(a,i,j);
            }
        }
        res[1] = j+1;

        swap(a,j+1,r);
        return res;
    }

    private void swap(int[]a , int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args){
        int[] nums = {1,5,7,2,8,0,3,5,11,122,1,22,3,4,5,1,4,4,4,4,4,4,5,5,6,6,7,0,3};
        DuplicateQuickSort solution = new DuplicateQuickSort();
        solution.sort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
