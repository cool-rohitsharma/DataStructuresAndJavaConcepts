package java8Concepts.StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String str = "india";
        //Get Frequency
        Map<Character, Long> freqMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
        //Filter out non repeating character by skiping 1
        char secondNonrepeatingChar = freqMap.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .skip(1)
                        .findFirst()
                        .get();
        //System.out.println(secondNonrepeatingChar);

        String str2 = "aabbcdeed";

        char firstNonRepeatingChar = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('0');


        System.out.println(firstNonRepeatingChar);

        int[] arr = {2,3,5,6,7,4,3,5,2};

        int secondRepeatingNumber = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .skip(2)
                    .findFirst()
                    .orElse(0);

        System.out.println(secondRepeatingNumber);

    }
}
