

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Person {
    private String name;
    private int age;
    private String city;

    public Person (String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person viet = new Person("Viet", 24, "Turku");
        Person jenna = new Person("Jenna", 22, "Helsinki");
        Person saed = new Person("Saed", 25, "Vantaa");

        people.add(viet);
        people.add(jenna);
        people.add(saed);

        // People sorted by age
        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("People sorted by age (ascending):");
        for (Person person : people) {
            System.out.println(person.name + ", " + person.age + ", " + person.city);
        }

        // Filter people from a specific city 
        String targetCity = "Helsinki";
        people.removeIf(person -> !person.getCity().equals(targetCity));

        System.out.println("People from " + targetCity + ":");
        for (Person person : people) {
            System.out.println(person.name + ", " + person.age + ", " + person.city);
        }

        // Tasks 2
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        // Filtering out Even Numbers
        numbers.removeIf(number -> number % 2 == 0);
        System.out.println("Printing the remaining numbers: ");
        numbers.forEach(number -> System.out.println(number));

        // Doubling the Odd Numbers
        numbers.replaceAll(number -> number * 2);
        System.out.println("Printing the numbers after doubling them: ");
        numbers.forEach(number -> System.out.println(number));

        // Sum the Numbers
        int[] total = {0}; 
        numbers.forEach(number -> total[0] += number);
        System.out.println("The Combined numbers: " + total[0]);
    }
}
