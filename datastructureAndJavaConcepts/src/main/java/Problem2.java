import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {

/*
    Q. Given Input: Parallel Stream = {11, 22, 33, 44}

    Should sorted and display output as {44, 11, 33, 22} using Java8 Streams
*/

    public static List<Integer> getRotatedArr(List<Integer> arrList){
        Collections.rotate(arrList,1);
        return arrList;
    }

    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(11, 22, 33, 44);
        List<Integer> resList = getRotatedArr(arrList);
        System.out.println(resList);
    }
}
