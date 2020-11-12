package com.dodo.learning.listTomap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapDemo {

    /**
     * Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
     *   Function<? super T, ? extends U> valueMapper)
     * @param books
     * @return
     */
    public static Map<String, String> listToMap(List<Book> books){
        //return books.stream().collect(Collectors.toMap( Book::getIsbn, Book::getName));
        return books.stream().collect(Collectors.toMap( book -> book.getIsbn(), book ->  book.getName()));
    }

    public static Map<String, Book> listToBookMap(List<Book> books){
        return books.stream().collect( Collectors.toMap( book -> book.getIsbn(), book -> book));
    }

    public static Map<String, Book> listToMapWithIdentity(List<Book> books) {
       /* return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> existing));*/
       return books.stream().collect(Collectors.toMap( Book::getName, Function.identity()));
    }

    /**
     * In case of key is duplicate, the above function throws error
     * hence we need to use the the paramter in toMap function - merge function
     *
     * @param books
     * @return
     */
    public static Map<Integer, Book> listToMapWithMerge(List<Book> books) {
        return books.stream()
                .collect(Collectors.toMap(
                        Book::getReleaseYear,
                        Function.identity(),
                        (existing, replacement) -> existing));
    }



    public static Map<String, Employee> personToEmployee(List<Person> personList){
        return personList.stream().collect(Collectors.toMap( person -> person.getName(), person -> new Employee(person.getName())));
    }

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1956, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));

        Map<String, String> booksWithIsbn = listToMap(bookList);
        booksWithIsbn.forEach( (k, v) -> {
            System.out.println(k +" : "+v);
        });


        Map<String, Book> bookMapWithIsbn = listToBookMap(bookList);
        bookMapWithIsbn.forEach( (k, v) -> {
            System.out.println(k +" : "+v);
        });

        System.out.println("------------------------");

        Map<String, Book> booksWithDuplicateKey = listToMapWithIdentity(bookList);

        booksWithDuplicateKey.forEach( (k, v) -> System.out.println(k +":"+v.getIsbn()) );

        System.out.println("------------------------");

        Map<Integer, Book> booksWithouDuplicate = listToMapWithMerge(bookList);
        booksWithouDuplicate.forEach( (key, value) -> System.out.println(key +": "+value));


        System.out.println("------------------------");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Bob"));
        personList.add(new Person("Mary"));
        personList.add(new Person("John"));

        Map<String, Employee> employees = personToEmployee(personList);
        employees.forEach( (key, employee) -> System.out.println(key +" : "+employee));
    }
}

class Book {

    private String name;
    private int releaseYear;
    private String isbn;

    public Book(String name, int releaseYear, String isbn) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override public String toString() {
        return "Book{" + "name='" + name + '\'' + ", releaseYear=" + releaseYear + ", isbn='" + isbn + '\'' + '}';
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Employee{" + "name='" + name + '\'' + '}';
    }
}
