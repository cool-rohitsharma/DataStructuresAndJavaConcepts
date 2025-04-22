package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//list of integers, calculate the sum using Collectors
public class SummingValues {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int summing = numbers.stream().mapToInt(Integer::intValue).sum();
        int summingway2 = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(summing);
        System.out.println(summingway2+"<- Using Collectors");
        System.out.println("Reverse integer :"+revInt(1234));
    }

    public static int revInt(int x){
        int res = 0;
        while(x != 0){
            int r = x%10;
            res = res*10 +r;
            x = x/10;
        }
        return res;
    }
}
