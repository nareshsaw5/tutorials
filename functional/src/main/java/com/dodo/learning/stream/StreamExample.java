package com.dodo.learning.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays
                .asList(new Employee(1, "Bob", 200), new Employee(2, "John", 300), new Employee(3, "Don", 400),
                        new Employee(4, "Marry", 400), new Employee(5, "Shruthi", 250), new Employee(6, "Kimy", 400));

        List<Employee> highSalary = employeeList.stream() //source to stream
                .filter((emp) -> emp.getSalary() > 300) // intermediate operation
                .filter( (emp) -> emp.getName().startsWith("K")) // another operation or pipeline
                .collect(Collectors.toList()); // Terminal operation
        System.out.println(highSalary);

        // look more into the stream
        Stream<Employee> stream = employeeList.stream();
        Stream<Employee> fitler = stream.filter( (emp)-> emp.getName().equals("John"));
        Stream<Employee> fitler2 = fitler.filter( (emp)-> emp.getName().equals("Marry")); // This will give you IllegalStateException

       /* employeeList.stream().filter( (emp) -> emp.getSalary() > 100)
                .map( (employee -> employee.getName()+" "))
                .collect(Collectors.toList())
                .forEach(System.out::print);*/

      long startTime, endTime,timeTaken;
      startTime = System.currentTimeMillis();
      OptionalDouble averageSalary = employeeList.stream()
                .mapToDouble( (emp) -> emp.getSalary())
                //.mapToDouble( (salary) -> salary.intValue())// unecessary
                .average();
        System.out.println("Average Salary "+averageSalary.getAsDouble());
        endTime = System.currentTimeMillis();
        timeTaken = endTime-startTime;
        System.out.println("Time taken sequentially "+timeTaken);



    }

}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
