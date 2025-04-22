package java8Concepts.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsAndConcepts {

    public static void main(String[] args) {
        List<Integer> streamNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sumOfEvenNum = streamNum.stream()
                                    .filter(x -> x % 2 == 0)
                                    .reduce(0, Integer::sum);
        System.out.println("Sum of Even numbers:"+sumOfEvenNum);
        int sumOfOddSquares = streamNum.stream()
                                        .filter(x -> x % 2 != 0)
                                        .map(x -> x * x)
                                        .reduce(0, Integer::sum);
        System.out.println("Sum of Odd squares numbers : "+ sumOfOddSquares);

        //Joining Strings using Collectors.joining
        List<String> words = Arrays.asList("Hello", "World", "from","java", "8");
        String joined = words.stream().collect(Collectors.joining(" "));
        System.out.println("Joined String : "+joined);

        //Grouping objects with Collectors.groupingBy
        List<Employee> employees = Arrays.asList(new Employee("1","Alice",22, "HR"),
                                                 new Employee("2","Bob", 25,"Engineering"),
                                                 new Employee("3","David", 27,"Engineering"),
                                                 new Employee("4","Charlie", 28,"IT"),
                                                 new Employee("5","Elle", 24,"HR"));

        //Group employee based on departments
        Map<String, List<Employee>> groupedEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employee grouped in departments: "+groupedEmployee);

        //Partitioning a list into evens and odds using Collectors.partitioning
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> oddAndEvenNum = numbers.stream()
                                                            .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Odd and Even ");
    }



static class Employee {

    private String id;
    private String name;
    private int age;
    private String Department;

    public Employee(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.Department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return Department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Department='" + Department + '\'' +
                '}';
    }
}
}