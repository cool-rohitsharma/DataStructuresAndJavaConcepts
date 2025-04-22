package java8Concepts.scenariobasedquestions;

import java.util.Arrays;
import java.util.List;

public class Problem2{


    public static void main(String[] args) {

        List<Product> products = Arrays.asList(new Product(1,"Alice",1293.03),
                new Product(2,"Bob",1002.03),
                new Product(3,"Charlie",1453.03),
                new Product(4,"David",17793.04));

        //SortProductNames sortProductNames=
    }
}

@FunctionalInterface
interface SortProductNames{

    Product sort(int length);

}

class Product{

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
