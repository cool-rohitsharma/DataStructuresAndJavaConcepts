package ImportantInterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8InfyQ {

    public static void main(String[] args) {
        List<Employees> employeesList = Arrays.asList(
                new Employees("Rohit", "M", 29),
                new Employees("Yashika", "F", 1),
                new Employees("Palak", "F", 26)
        );

        // Grouping by gender
        Map<String, List<Employees>> employeeMap = employeesList.stream().collect(Collectors.groupingBy(Employees::getGender));
        employeeMap.forEach((gender, employees) -> {
            System.out.println("Gender :"+gender);
            System.out.println();
            employees.forEach(employees1 -> {
                System.out.println(employees1.getName()+" "+employees1.getAge());
            });
        });
    }
}

class Employees {
    private String name;
    private String gender;
    private int age;

    public Employees(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
