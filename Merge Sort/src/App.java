// Merge Sort

import java.util.Scanner;

public class App {
    public static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] num1 = new int[n1];
        int[] num2 = new int[n2];
        for(int i=0;i<n1;i++){
            num1[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            num2[i]=arr[mid+1+i];
        }
        int k=l;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(num1[i]<num2[j]){
                arr[k]=num1[i];
                i++;
            }
            else{
                arr[k]=num2[j];
                j++;
            }
            k++;
        }
        while(i!=n1){
            arr[k]=num1[i];
            i++;
            k++;
        }
        while(j!=n2){
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr, int high, int low){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr, mid, low);
            mergeSort(arr, high, mid+1);
            merge(arr,low,mid,high);
        }
        
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr = {9,3,5,73,8,2,7};
        mergeSort(arr, arr.length-1,0);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
