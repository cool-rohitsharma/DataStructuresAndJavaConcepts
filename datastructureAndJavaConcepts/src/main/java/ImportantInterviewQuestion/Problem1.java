package ImportantInterviewQuestion;

public class Problem1 {

    /*Find 2nd Minimum in Rotated Sorted Array.
    O(log n)
    Example:
            [4,5,6,7,0,1,2]
    o/p: 1
            [3,4,5,1,2]
    o/p:2*/

    public static int secondMinElement(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0; // Or throw an exception as there's no 2nd minimum
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int minIndex = left;

        if(minIndex == 0){
            return arr[1];
        }

        if(minIndex == n-1){
            return arr[0];
        }

        return Math.min(arr[minIndex+1]%n, arr[0]);
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr1) + ": " + secondMinElement(arr1)); // Output: 1

        int[] arr2 = {3, 4, 5, 1, 2};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr2) + ": " + secondMinElement(arr2)); // Output: 2

        int[] arr3 = {1, 2};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr3) + ": " + secondMinElement(arr3)); // Output: 2

        int[] arr4 = {2, 1};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr4) + ": " + secondMinElement(arr4)); // Output: 2

        int[] arr5 = {1};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr5) + ": " + secondMinElement(arr5)); // Output: 0

        int[] arr6 = {1, 1, 2};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr6) + ": " + secondMinElement(arr6)); // Output: 2

        int[] arr7 = {2, 2, 1};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr7) + ": " + secondMinElement(arr7)); // Output: 2

        int[] arr8 = {2, 1, 2};
        System.out.println("Second minimum in " + java.util.Arrays.toString(arr8) + ": " + secondMinElement(arr8)); // Output: 2
    }
}

final class Singleton{

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}