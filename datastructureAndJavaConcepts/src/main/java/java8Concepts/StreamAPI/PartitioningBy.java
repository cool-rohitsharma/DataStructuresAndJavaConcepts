package java8Concepts.StreamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//list of numbers, partition them into even and odd
public class PartitioningBy {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> evenOrOdd = numbers.stream()
                .collect(Collectors.partitioningBy(integer -> integer % 2 == 0, Collectors.toList()));
        System.out.println(evenOrOdd);
    }
}
