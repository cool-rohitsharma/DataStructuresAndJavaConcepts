
import java.util.Arrays;
// asked in Oracle
public class MergeSortingAlgo {

    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left+right)/2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }

    static void merge(int[] arr, int left, int middle, int right){
        int n1 = middle + 1 - left;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle+1, rightArray, 0, n2);

        int i=0, j = 0, k = left;
        while (i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = leftArray[i];
            k++;
            i++;
        }

        while(j<n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {23,43,87,92,11,12};
        mergeSort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
}
