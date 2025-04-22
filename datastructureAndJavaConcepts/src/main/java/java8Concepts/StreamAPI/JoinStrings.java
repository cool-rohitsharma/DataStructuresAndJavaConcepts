package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//list of names, join them into a single comma-separated string
public class JoinStrings {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String namesJoin = names.stream().collect(Collectors.joining(","));
        System.out.println(namesJoin);
    }
}
