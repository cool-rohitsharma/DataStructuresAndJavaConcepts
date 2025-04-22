package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group the names using first letter
public class GroupingBy {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Daniel");
        Map<Character, List<String>> groupedName = names.stream()
                                                            .collect(Collectors.groupingBy(e -> e.charAt(0)));
//        names.stream()
//                .collect(Collectors.groupingBy(e -> e.charAt(0))).forEach(((character, strings) -> {
//                    System.out.println(character + "->"+strings);
//                }));
        System.out.println(groupedName);
    }
}
