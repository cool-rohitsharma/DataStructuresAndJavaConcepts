package ImportantInterviewQuestion;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesNSortArray {

    // Remove duplicates and Sort unsorted array
    public static int[] processArr(int[] arr){
        Set<Integer> set = new TreeSet<>();
        for(int i: arr){
            set.add(i);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 3, 5, 1};
        System.out.println(Arrays.toString(processArr(arr)));
    }
}
