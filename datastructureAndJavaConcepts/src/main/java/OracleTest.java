//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//public class OracleTest {
//
//    public static int[][] intervals(int[][] interval){
//
//        Arrays.sort(interval, Comparator.comparingInt(a -> a[0]));
//
//        List<int[]> mergeSubArr = new ArrayList<>();
//        int[] currentInterval = interval[0];
//        mergeSubArr.add(currentInterval); //[[1, 2],[2, 3]]
//
//        for(int[] intervals: interval){
//
//            int[] start = interval[0];
//            int[] end = interval[1];
//        }
//
//        if()
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
////    Given a collection of time intervals, [start, end], merge and return the overlapping intervals sorted in ascending order of their start times.
////
////
////
////        Example
////
////        intervals = [[7, 7], [2, 3], [6, 11], [1, 2]]
////
////
////
////        The interval [1, 2] merges with [2, 3] while [7, 7] merges with [6, 11].
////        There are no more overlapping intervals. The answer is [[1, 3], [6, 11]].