package java8Concepts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Features {
    /*Lambda Expression
    1. Write a program to sort a list of strings using lambda expressions.
    2. Create a Runnable using a lambda expression and run it in a thread.
    3. Write a lambda function to filter a list of integers and keep only even numbers.
    * */
    /*Functional Interface ->
     1. Implement Predicate, Function, Consumer, and Supplier functional interfaces with examples.
     2. Create a custom functional interface and use it with a lambda expression.
     */
    /*Optional Classes -
    1. Create an example where Optional is used to avoid NullPointerException.
    2. Wrnite a method that returns Optional and handle both present and absent values.
    */
    /*Method reference -
    1. Convert a list of strings to integers using method references.
    2. Use method references for both static and instance methods.
    */



    public static void main(String[] args) {
        //Lambda examples
        //1. List of Strings sorting
        List<String> names = Arrays.asList("John", "Alice", "Bob", "David");
        names.sort(String::compareTo);
        System.out.println("Sorted Names :" + names);

        //2. Runnable with lambda
        Runnable run = () -> System.out.println("Running a thread");
        new Thread(run).start();

        //3. List of even integers with lambda
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        //Functional Interface
        //1.
        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        System.out.println("Test Hi is NotEmpty :" + isNotEmpty.test("HI")); // Predicate provide us test() method

        Function<Double, String> doubleToString = Object::toString;
        System.out.println("Integer to String :"+doubleToString.apply(8.6878980)); //Function provide us apply()

        Consumer<String> greeter = name -> System.out.println("Hi I am "+name);
        greeter.accept("AI"); // Consumer provide us accept()

        Supplier<Double> randomValue = Math :: random;
        System.out.println("Random Value :" + randomValue.get()); // Supplier provide us get()

        if(isNotEmpty.test("Hey")){
            greeter.accept(doubleToString.apply(randomValue.get()));
        }

        //2. custom functional interface
        MathOperation multiplyOperation = (a,b) -> a * b;
        System.out.println(multiplyOperation.operate(4,6));

        Car ignitionOn = status -> status.concat(" Engine");
        System.out.println(ignitionOn.ignition("ON"));

        //Optional
        //1.
        Optional<String> optionalValue = Optional.ofNullable(null);
        System.out.println("Optional Value : "+ optionalValue.orElse("Default Value"));

        //2.
        Optional<String> optionalValueIfPresent = Optional.ofNullable("Human");
        optionalValueIfPresent.ifPresent(val -> System.out.println("Value Exists : "+ val));

        //Java 11
        Optional<List<String>> optionalValueIfAbsent = Optional.of(Arrays.asList("Human", "AI"));
        optionalValueIfAbsent.ifPresentOrElse(list -> list.forEach(System.out::println),
                                                    () -> System.out.println("value is absent"));

        //Method reference
        List<String> numbersToStr = Arrays.asList("1", "2", "3","4");
        numbersToStr.stream().map(Integer::valueOf).forEach(System.out::println);

        //Default Method and static method
        MyInterface interfaceImpl = new InterfaceImpl();
        interfaceImpl.defaultMethod();
        MyInterface.staticMethod();

        //Date and Time API
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date : "+ today);
        LocalDate tenDaysLater = today.plusDays(10);
        System.out.println("Date after 10 days : "+tenDaysLater);



    }
}

@FunctionalInterface
interface MathOperation {

    int operate(int a, int b);
}

@FunctionalInterface
interface Car{

    String ignition(String status);
}

class StaticMethodReferenceExample{

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie","Alice", "Bob", "David");
        names.forEach(StaticMethodReferenceExample::printNames);
    }

    static void printNames(String name){
        System.out.println(name);
    }
}

class InstanceMethodReferenceExample{

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "David");

        InstanceMethodReferenceExample instanceMethodReferenceExample = new InstanceMethodReferenceExample();
        names.forEach(instanceMethodReferenceExample::printNames);
    }

    public void printNames(String name){
        System.out.println(name);
    }
}

interface MyInterface{
    default void defaultMethod(){
        System.out.println("Default method in Interface");
    }
    static void staticMethod(){
        System.out.println("Static method in Interface");
    }
}

class InterfaceImpl implements MyInterface{}

