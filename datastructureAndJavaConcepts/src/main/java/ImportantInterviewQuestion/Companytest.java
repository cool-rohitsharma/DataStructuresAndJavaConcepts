package ImportantInterviewQuestion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Companytest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ron", "Sharma", "Delhi"),
                new Employee(2, "Ron", "Sharma", "Delhi"),
                new Employee(2, "Rob", "Sharma", "Mumbai"),
                new Employee(3, "Shyam", "Sharma", "Delhi")
        );

        // Convert list to map using id as key and employee object as value
        Map<Integer, Employee> employeeMap = employees.stream()
                                                            .collect(Collectors
                                                                    .toMap(Employee::getId, Function.identity(),
                                                                            (existing, replacement) -> existing));

        System.out.println(employeeMap);
    }
}

class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String city;

    public Employee(int id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "ImportantInterviewQuestion.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
