package com.dodo.learning.practicemore.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceMain {

    public static void main(String[] args) {
        int sum = List.of(3,4,5,6,7,7,8).stream()
                .reduce( (accumulator, number) -> accumulator+number)
                .orElse(0); // takes binary operator(two input) and returns a value
        System.out.println(sum);

        System.out.println("+++++++++++++++++++++++");

        String concatedWord = Arrays.stream(new String[]{"A", "B", "C"})
                .reduce( (accumulator, letter) -> accumulator+","+letter)
                .get();
        System.out.println(concatedWord);

        System.out.println("+++++++++++++++++++++++");

        // get sum of numbers greater than 10
        int sumWithFilter = List.of(4, 10, 4, 11, 13, 7, 19, 18, 6)
                .stream()
                .filter( (number) -> number >= 10)
                .reduce( (accumulator, number) -> accumulator+number)
                .get();
        System.out.println(sumWithFilter);
        System.out.println("+++++++++++++++++++++++");

        // substract all the numbers from first number and get the result
        int remaining = Arrays.stream(new int[]{100, 5 , 5, 10})
                .reduce( (accumulator, number) -> accumulator - number)
                .getAsInt();
        System.out.println(remaining);
        System.out.println("+++++++++++++++++++++++");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Bob"));
        students.add(new Student("John"));
        students.add(new Student("Marry"));
        students.add(new Student("Mohan"));
        students.add(new Student("Shyam"));

        Student student1 = students.stream().reduce((firstStudent, student) -> {
           // System.out.println(student.getName());
            //System.out.println(firstStudent);
            return new Student(firstStudent.getName()+", "+student.getName());
        }).get();
        System.out.println(student1.getName());
        System.out.println("+++++++++++++++++++++++");

        // Get the total marks by using reducer function
        List<Student> studentList  = new ArrayList<>();
        studentList.add(new Student("Bob", 100));
        studentList.add(new Student("Mary", 200));
        studentList.add(new Student("John", 150));

        // get the total marks
        Student studentWithTotalMark = studentList.stream()
                .reduce( (accumulator, student) -> {
                    return new Student(accumulator.getMarks()+student.getMarks());
                }).get();
        System.out.println(studentWithTotalMark.getMarks());

        System.out.println("+++++++++++++++++++++++");

        int sum2 = IntStream.range(1, 10).sum();
        System.out.println(sum2);

        int min = IntStream.range(1, 10).min().getAsInt();
        System.out.println(min);

        int max = IntStream.range(2, 4).max().getAsInt(); // the last param is exclusive one, will not be counted
        System.out.println(max);

    }
}

class Student {
    private String name;
    private int marks;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
