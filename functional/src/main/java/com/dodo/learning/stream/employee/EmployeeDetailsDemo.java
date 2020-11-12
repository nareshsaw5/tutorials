package com.dodo.learning.stream.employee;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDetailsDemo {

    public static void main(String[] args) {
        Set<Employee> employees = new LinkedHashSet<>();
        employees.add(new Employee(5, "Bob", 200));
        employees.add(new Employee(2, "Rob", 500));
        employees.add(new Employee(6, "John", 800));
        employees.add(new Employee(3, "Dob", 700));
        employees.add(new Employee(1, "Mon", 100));

        // simple iteration
        employees.stream().forEach(System.out::println);
        System.out.println("--------------");

        // To sort, you need to implement Comparator interface and override compareTo function
        Set<Employee> sortedEmployee = employees.stream().
                sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toSet());
        sortedEmployee.forEach(System.out::println);
        System.out.println("--------------");

        // filter employees whose salary is greater than 500
        List<Employee> filteredEmployee = employees.stream().filter((employee -> employee.getSalary() > 500))
                .sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());
        filteredEmployee.forEach(System.out::println);
        System.out.println("--------------");

        // make double of each employee salary by map
        List<Employee> employeeWithDoubleSalary = employees.stream().map((e) -> {
            return new Employee(e.getId(), e.getName(), 2 * e.getSalary());
        }).sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());

        employeeWithDoubleSalary.forEach(System.out::println);
        System.out.println("--------------");

        Map<Integer, Integer> map = List.of(1, 2, 3, 4, 5).stream().collect(Collectors.toMap(e -> e, e -> e));
        map.forEach( (k, v) -> {
            System.out.println(k +", "+v);
        });


    }
}

