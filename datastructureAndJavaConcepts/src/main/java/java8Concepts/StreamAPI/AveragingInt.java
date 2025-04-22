package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// a list of integers, compute the average
public class AveragingInt {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        double averageValue = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(averageValue);
    }
}
