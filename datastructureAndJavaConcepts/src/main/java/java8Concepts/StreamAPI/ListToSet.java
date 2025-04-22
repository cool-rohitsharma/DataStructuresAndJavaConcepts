package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Convert a list to set using Stream
public class ListToSet {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        Set<Integer> uniqueNum = numbers.stream().collect(Collectors.toSet());
        System.out.println(uniqueNum);

    }
}
