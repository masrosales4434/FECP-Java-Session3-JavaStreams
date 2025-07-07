package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaStreams {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString(){
            return "Name: "+name +" | Age: "+ age;

        }

    }

    public static void main(String[] args) {

        //Activity 1
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> isOdd = n -> n % 2 == 1;

        List<Integer> result = numList.stream().filter(isOdd).toList();

        System.out.println("Actual Result: " + result);

        //Activity 2
        List<String> nameList = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");

        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> nameResult = nameList.stream().filter(startsWithA).toList();

        System.out.println("Name Actual Result: " + nameResult);

        //Activity 3
        List<Integer> numList2 = Arrays.asList(1,2,3,4,5);

        List<Integer> numList2squared = numList2.stream().map(n -> n * n).toList();

        System.out.println("Squared Numbers: " + numList2squared);

        //Activity 4
        List<Integer> numList3 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> isEven = n -> n%2==0;
        Predicate<Integer> greaterThanFive = n -> n > 5;

        Predicate<Integer> combined = isEven.and(greaterThanFive);

        List<Integer> combinedResult = numList3.stream().filter(combined).toList();

        System.out.println("Combined Result: " + combinedResult);


        //Activity 5

        List<Person> personList = Arrays.asList(new Person("Marvin", 20),
                new Person("Andrew", 22),
                new Person("Bob", 19),
                new Person("Alice", 15),
                new Person("Charlie", 32));


        List<Person> personAgeSorted = personList.stream().sorted(Comparator.comparingInt(Person::getAge))
                .toList();


        List<Person> personNameSorted = personList.stream().sorted(Comparator.comparing(Person::getName)).toList();

        List<Person> personAgeSortedReverse = personList.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
                .toList();

        Consumer<Person> printNameAndAge = person -> System.out.println(person.toString());

        System.out.println("=====Person Sorted by Age=====");

        personAgeSorted.forEach(printNameAndAge);
        System.out.println("======Person Sorted by Name=====");
        personNameSorted.forEach(printNameAndAge);
        System.out.println("=====Person Sorted by Age (reversed)=====");

        personAgeSortedReverse.forEach(printNameAndAge);
    }
}