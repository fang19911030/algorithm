package algorithms;

/**
 * Created by fang on 6/29/17.
 */
import java.util.Comparator;
import java.util.Random;

public class MergeSort {
    private MergeSort(){};

    private static void merge(Comparable[]a, Comparable[]aux, int low, int mid,int high){
        for(int k = low;k<=high;k++){
            aux[k] = a[k];
        }

        int i = low, j = mid+1;
        for(int k=low;k<=high;k++){
            if(i>mid) a[k] = aux[j++];
            else if(j>high) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k]=aux[j++];
        }
    }

    public static void sort(Comparable[]a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[]a, Comparable[]b,int low,int high){
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1,high);
        merge(a,b,low,mid,high);
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    public static void main(String[] args){
        Integer[] n = new Integer[100];
        Random rand = new Random();
        for(int i=0;i<n.length;i++){
            n[i] = rand.nextInt(201);
        }
        sort(n);
        for(Integer t:n){
            System.out.print(t+" ");
        }

    }
}
