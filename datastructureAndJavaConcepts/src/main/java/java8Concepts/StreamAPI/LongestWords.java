package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// list of words, find the longest word
public class LongestWords {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "watermelon", "grape");
        String word = words.stream().collect(Collectors.maxBy(Comparator.comparing(String::valueOf))).get();
        System.out.println(word);
    }
}
