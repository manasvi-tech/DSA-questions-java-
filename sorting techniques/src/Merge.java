import java.util.ArrayList;

public class Merge {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);  // i - low ensures correct indexing
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);        // left half
        mergeSort(arr, mid + 1, high);   // right half
        merge(arr, low, mid, high);      // merging sorted halves
    }
}
