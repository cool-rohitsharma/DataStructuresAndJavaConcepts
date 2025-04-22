package java8Concepts.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

// the max and min salary from a list of employees
public class MaxAndMin {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 6000)
        );

        Optional<Employee> minSalary = employees.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)));
        Optional<Employee> maxSalary = employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println("Min Salary :"+minSalary.get().salary);
        System.out.println("Max Salary :"+maxSalary.get().salary);

        Map<String, Integer> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));
        employeeMap.forEach((s, integer) -> {
            System.out.println(s+" -> "+integer);
        });
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}



