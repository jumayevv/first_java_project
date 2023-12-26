package Dars;

import java.util.Arrays;

public class q_sort {

    public static void quick_sort(int[] arr, int start,int end){
        if(end-start < 2){
            return;
        }
        int pivot_index = partition(arr,start,end);
        quick_sort(arr,start,pivot_index);
        quick_sort(arr,pivot_index+1,end);
    }
    public static int partition(int[] arr,int start,int end){
        int pivot=arr[start];
        int i=start,j=end;
        while (i<j){
            while(i<j && arr[--j] >=pivot);
            if(i<j){
                arr[i] = arr[j];
            }
            while (i<j && arr[++i] <= pivot);
            if(i<j){
                    arr[j]= arr[i];
                }
          }
        arr[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,54,5,-1,3,1,-5,12};
        quick_sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
