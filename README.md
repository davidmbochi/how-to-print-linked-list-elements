### How to print LinkedList in Java
`LinkedList` is a data structure used to store different types of elements. It is different from other types of `List` such as `ArrayList` in that it is bidirectional meaning that it can be traversed in both forward and backward directions.

LinkedList provides different methods to modify the List such as `add()`, `remove()` and `get()`. This tutorial covers the different ways that can be used to retrieve elements from a LinkedList.

It has three implementations of the constructor and we are going to use one that accepts a [Collection](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html) of elements to ensure we have some data to work with.

### Table of contents
- [pring LinkedList using a for loop](###print-linkedlist-using-a-for-loop)
- [print LinkedList using Enhanced for loop](###-print-linkedlist-using-enhanced-for-loop)
- [print LinkedList using streams](###print-linkedlist-using-streams)
- [print LinkedList using toString() method](###print-linkedlist-using-tostring()-method)
- [print LinkedList using Iterator](###print-linkedlist-using-iterator)
- [print LinkedList using custom objects](###print-linkedlist-using-custom-objects)
- [How to print a custom singly LinkedList](###how-to-print-a-custom-singly-linkedlist)

### Print LinkedList using a for loop
The most common method of printing out elements in a List is by using a for-loop. Since LinkedList is an implementation of a List we can use a for loop to get elements that are stored in each index of the LinkedList.

Just as with other Lists, a Linked List starts from index `0` and we can use the `size()` method to get the total number of elements in the List.

For each iteration of the for loop, pass the index to the `get(index)` method which will return the element in the specific address.

<pre code="java">
        // using for loop
        LinkedList<String> domesticAnimals = new LinkedList<>(
                List.of("cow", "hen", "goat", "sheep", "donkey"));

        for (int i = 0; i < domesticAnimals.size(); i++) {
            System.out.println(i +" = "+domesticAnimals.get(i));
        }
</pre>
Output:
<div class="content-box-green" style="display: block; ">
    0 = cow<br>
    1 = hen<br>
    2 = goat<br> 
    3 = sheep<br> 
    4 = donkey 
</div>

### Print LinkedList using Enhanced for loop
An enhanced for loop is an alternative to a for-loop. It makes the code readable as it is short and descriptive. It also reduces the chances of getting a bug in your code by eliminating errors such as index out of bound which is prone to occur in a for-loop.

Most developers consider using an enhanced for loop as a best practice due to the above-mentioned advantages. Enhanced for-loop cannot traverse elements backward because it does not support index operations compared to a for-loop.

An enhanced for loop can be used to iterate through a LinkedList to print out the elements in the List. The type of variable of the enhanced for loop will be similar to that being passed to the LinkedList.

<pre code="java">
        // using enhanced for loop
        LinkedList<Integer> numbers = new LinkedList<>(List.of(20,45,80,36,27,100));

        for (Integer integer : numbers) {
            System.out.println(integer);
        }
</pre>
Output:
<div class="content-box-green">
20<br>
45<br>
80<br>
36<br>
27<br>
100
</div>

### Print LinkedList using streams
The Java stream was introduced in Java 8 and makes use of functional programming to operate on a collection of elements.

Streams use aggregate operations with several intermediate operations such as `filter()` and `map()` to return a stream of elements that meet certain criteria.

The final operation of the stream is terminal and no other intermediate operation can be executed after this stage on the List.

To print out elements in a LinkedList using streams you only need to use the `forEach()` after the intermediate operations.

This terminal operation accepts a [Consumer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Consumer.html) which is simply a functional interface with a single argument and returns no result.

In this method we will use a LinkedList with a List of names and then filter names that start with the letter `J` and finally print them using the `forEach()` method.

<pre code="java">
        //using streams
        LinkedList<String> names = new LinkedList<>(List.of("esther","abdul","james","mary","jamal"));
        names.stream()
                .filter(s -> s.startsWith("j"))
                .forEach(System.out::println);
</pre>
Output:
<div class="content-box-green">
james<br>
jamal<br>
</div>

### Print LinkedList using toString() method
The `toString()` method is overridden from the `Object` class which is the base class for all classes in Java.

This method returns a collection of strings of the objects in a square bracket separated by commas.

The `String` class uses the static method `valueOf(Object)` to return a string for each object in the LinkedList.

Since we are using `String` in the LinkedList you only need to call the `toString()` method but when using custom objects ensure that you declare the method.

To see the `toString()` method in action, we will create a LinkedList with a list of courses and then print them using the standard print statement method.

<pre code="java">
        //using toString() method
        LinkedList<String> courses = new LinkedList<>(List.of(
                "introduction to java",
                "multithreading basics",
                "JUnit in action"
        ));
        System.out.println(courses.toString());

</pre>
Output:
<div class="content-box-green">
[introduction to java, multithreading basics, JUnit in action]
</div>

### Print LinkedList using Iterator
LinkedList inherits the iterator functionality from [AbstractList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractList.html) which implements the [Iterable](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Iterable.html) interface.

The `iterator()` returns an [Iterator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html) which allows us to print out the elements in the LinkedList using the `forEachRemaining()` method from the Iterator class.

The `forEachRemaining()` method accepts a `Consumer` and the default implementation checks whether there is another element in the list and accepts it if `true`.

For each element iterated, the method will execute the desired operation such as printing out the elements but will `throw` a `NullPointerException` if the action is null.

We will use a LinkedList with all the vowels, return an Iterator from the List then print out the vowels using the `forEachRemaining()` method of the Iterator.

<pre code="java">
        //using Iterator
        LinkedList<Character> vowels = new LinkedList<>(List.of('A','E','I','O','U'));
        Iterator<Character> iterator = vowels.iterator();
        iterator.forEachRemaining(System.out::println);
</pre>
Output:
<div class="content-box-green">
A<br>
E<br>
I<br>
O<br>
U<br>
</div>

### Print LinkedList using custom objects
In a real-life situation, you are usually required to create your custom objects that will be used in the LinkedList compared to using `String`, `Integer` and `Character` and other Java reference types.

An example of a real-life situation where you will need to create custom objects includes implementing continuous stock prices, browser history, and video or image player.

Some implementations such as browser history and media players require a doubly LinkedList to enable viewing previous and next items in the List.

Implementation of continuous stock prices leverages a singly LinkedList which you will learn how is created in this article.

We will make use of a customer class with first name, last name, and email as its properties.

<pre code="java">
// customer class       
class Customer{
        private String firstName;
        private String lastName;
        private String email;

        public Customer(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
        // Generate Getters, Setters and toString()
}
</pre>

After creating the customer class, create a LinkedList in the main method with a List of customer instances and print out the list using the `forEach()` method.

<pre code="java">
        //print LinkedList with custom objects
        LinkedList<Customer> customers = new LinkedList<>(List.of(
                new Customer("john","doe","john@domain.com"),
                new Customer("esther","anderson","john@domain.com"),
                new Customer("mary","public","mary@domain.com")
        ));
        customers.forEach(System.out::println);
</pre>

Output:

<div class="content-box-green">
Customer{firstName='john', lastName='doe', email='john@domain.com'}<br>
Customer{firstName='esther', lastName='anderson', email='john@domain.com'}<br>
Customer{firstName='mary', lastName='public', email='mary@domain.com'}<br>
</div>

### How to print a custom singly LinkedList
The Java built-in LinkedList is doubly by default and in this article, you are going to create a custom singly LinkedList, add elements and print out the elements.

A `singly` LinkedList is a List that only keeps track of the next element with the last element pointing to `null`.

When iterating through the List in the singly LinkedList it throws a `NullPointerException` after getting to the last element. Print out the result to the console to prevent the LinkedList from throwing an `Exception`.

The LinkedList will hold its data and an object to the next element. We will use student objects with only the name as the data to an element in the List.

<pre code="java">
class Student{
        private String name;

        public Student(String name) {
            this.name = name;
        }
        //Generate toString()
}
</pre>

After creating the student class, create a custom LinkedList class with the student and pointer to the next student as the properties.

Create a constructor that only accepts a student class. The student class will be used as the data for the node.

<pre code="java">
public class SinglyLinkedList {

    private Student student;
    private SinglyLinkedList nextStudent;

    public SinglyLinkedList(Student student) {
        this.student = student;
        this.nextStudent = null;
    }
}
</pre>

Create the main method in the `SinglyLinkedList` class and create `5` nodes with the first node pointing to the second, second to third, third to fourth, and fourth to fifth.

<pre code ="java">
SinglyLinkedList firstStudent = new SinglyLinkedList(new Student("abdul"));
SinglyLinkedList secondStudent = new SinglyLinkedList(new Student("bilal"));
SinglyLinkedList thirdStudent = new SinglyLinkedList(new Student("canon"));
SinglyLinkedList fourthStudent = new SinglyLinkedList(new Student("doreen"));
SinglyLinkedList fifthStudent = new SinglyLinkedList(new Student("eden"));

firstStudent.nextStudent = secondStudent;
secondStudent.nextStudent = thirdStudent;
thirdStudent.nextStudent = fourthStudent;
fourthStudent.nextStudent = fifthStudent;
</pre>

In `SinglyLinkedList` class, create the print student method to print out the elements in the LinkedList. 

The method first checks if the first node is null and if true, prints the list is empty to the console.

The initial student is a node that tracks the current position of the List and increments each time the check for `null` passes.

The students will be printed out for each node in the List and the last element will be null to show that there are no other nodes in the LinkedList.

<pre code="java">
 public static void printStudents(SinglyLinkedList firstStudent){
        SinglyLinkedList initialStudent;
        if (firstStudent == null){
            System.out.println("the list is empty");
        }
        initialStudent = firstStudent;

        while (initialStudent != null){
            System.out.println(initialStudent.student);
            initialStudent = initialStudent.nextStudent;
        }

        System.out.println(initialStudent);
    }

</pre>

Finally, call the print student method in the main method after node creation and pass the first node as the parameter to the method.

<pre code="java">
printStudents(firstStudent);
</pre>

Output:

<div class="content-box-green">
Student{name='mary'}<br>
Student{name='bilal'}<br>
Student{name='susan'}<br>
Student{name='doreen'}<br>
Student{name='eden'}<br>
null
</div>

### Conclution
In this tutorial, you have learned the different ways that you can leverage to print out the elements of a LinkedList. The methods covered include using a for loop, enhanced for loop, streams, toString(), Iterator, custom objects, and lastly custom singly LinkedList.











