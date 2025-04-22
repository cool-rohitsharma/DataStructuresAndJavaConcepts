package java8Concepts.scenariobasedquestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*

1. Employee Data Processing with Streams
You have a list of Employee objects, each containing id, name, salary, and department.
Write a program using Java 8 Streams to:

i) Find the department with the highest average salary.
ii) Retrieve the top 3 highest-paid employees.
iii) Group employees by department and find the highest-paid employee in each department.
iv) Find employees whose names contain at least one vowel (a, e, i, o, u).

*/
public class Problem1 {

    public static void main(String[] args) {
        List<Employees> employeesList = Arrays.asList(
                new Employees(1, "Alice", 65000.445, "HR"),
                new Employees(2, "Bb", 45000.454, "ENGG"),
                new Employees(3, "Charlie", 25000.5, "HR"),
                new Employees(4, "David", 15000.678, "Finance"),
                new Employees(5, "Elle", 30000.94, "Sales"),
                new Employees(6, "Fox", 43000.445, "ENGG")
        );
        //i) Find the department with the highest average salary.
        Map.Entry<String, Double> highestAvgSalary = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.averagingDouble(Employees::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println("Department with the highest average salary :"+highestAvgSalary);

        //Retrieve the top 3 highest-paid employees.
        List<Employees> highestPaidEmployees = employeesList.stream()
                                    .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                                            .limit(3)
                                                    .collect(Collectors.toList());

        System.out.println("The top 3 highest-paid employees :"+highestPaidEmployees);

        //Group employees by department and find the highest-paid employee in each department.
        Map<String, Optional<Employees>> highestPaidByDept = employeesList.stream()
                .collect(Collectors
                        .groupingBy(Employees::getDepartment,
                                Collectors.maxBy(Comparator
                                        .comparingDouble(Employees::getSalary))));
        System.out.println("Highest Paid Employees per department :"+highestPaidByDept);

        //Employees whose names contain at least one vowel
        List<Employees> namesWithVowel =employeesList.stream()
                .filter(e -> e.getName().matches(".*[aeiouAEIOU].*"))
                .collect(Collectors.toList());

        System.out.println("Names contain at least one vowel "+namesWithVowel);

    }
}

class Employees{

    private int id;
    private String name;
    private double salary;
    private String department;

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public Employees() {
    }

    public Employees(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
