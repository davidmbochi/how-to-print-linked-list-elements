package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // using for loop
        LinkedList<String> domesticAnimals = new LinkedList<>(
                List.of("cow", "hen", "goat", "sheep", "donkey"));

        for (int i = 0; i < domesticAnimals.size(); i++) {
            System.out.println(i +" = "+domesticAnimals.get(i));
        }

        // using enhanced for loop
        LinkedList<Integer> numbers = new LinkedList<>(List.of(20,45,80,36,27,100));

        for (Integer integer : numbers) {
            System.out.println(integer);
        }

        //using streams
        LinkedList<String> names = new LinkedList<>(List.of("esther","abdul","james","mary","jamal"));
        names.stream()
                .filter(s -> s.startsWith("j"))
                .forEach(System.out::println);

        //using toString() method
        LinkedList<String> courses = new LinkedList<>(List.of(
                "introduction to java",
                "multithreading basics",
                "JUnit in action"
        ));
        System.out.println(courses.toString());

        //using Iterator
        LinkedList<Character> vowels = new LinkedList<>(List.of('A','E','I','O','U'));
        Iterator<Character> iterator = vowels.iterator();
        iterator.forEachRemaining(System.out::println);

        //print LinkedList with custom objects
        LinkedList<Customer> customers = new LinkedList<>(List.of(
                new Customer("john","doe","john@domain.com"),
                new Customer("esther","anderson","john@domain.com"),
                new Customer("mary","public","mary@domain.com")
        ));
        customers.forEach(System.out::println);

        //How to print Custom singly LinkedList




    }

    static class Customer{
        private String firstName;
        private String lastName;
        private String email;

        public Customer(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


}
