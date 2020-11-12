package com.dodo.learning.groupby;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByDemo {

    public static void main(String[] args) {

        List<String> items = List.of("Grapes","Orange", "Apple", "Orange", "Papaya", "Grapes", "Guava");

        Map<String, Long> itemsGroupBy = items.stream().collect(Collectors.groupingBy( Function.identity(), Collectors.counting()));
        Map<String, Long> itemsGroupBy1 = items.stream().collect(Collectors.groupingBy( (x)->x, Collectors.counting()));

        itemsGroupBy1.forEach( (key, count) -> {
            System.out.println(key +": "+count);
        });

        System.out.println("+++++++++++++++++++++");

        List<Employee> employees =  new ArrayList<>();
        employees.add(new Employee("John","Manager"));
        employees.add(new Employee("Marry","Developer"));
        employees.add(new Employee("John","Architect"));
        employees.add(new Employee("John","Manager"));

        Map<String, Long> employeesGroupByDesignation = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));

        employeesGroupByDesignation.forEach( (k,v) -> System.out.println(k +": "+v));
        System.out.println("---------------------");

        List<Employee> employeesWithDepartment =  new ArrayList<>();
        Department engineering = new Department("Engineering");
        Department it = new Department("IT");
        employeesWithDepartment.add(new Employee("John","Manager", engineering));
        employeesWithDepartment.add(new Employee("Marry","Developer", engineering));
        employeesWithDepartment.add(new Employee("John","Architect", engineering));
        employeesWithDepartment.add(new Employee("John","Manager", engineering));
        employeesWithDepartment.add(new Employee("Ketty","Manager", it));
        employeesWithDepartment.add(new Employee("Bob","Developer", it));

        Map<String, Long> groupedByDepartment = employeesWithDepartment.stream().collect(
                Collectors.groupingBy((employee) -> {
                    return employee.getDepartment().getName();
                }, Collectors.counting()));

        groupedByDepartment.forEach( (k, v) -> System.out.println(k +": "+v));

    }
}


class Employee implements Comparable {

    private String name;
    private String designation;
    private Department department = new Department();


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public Employee(String name, String designation, Department department) {
        this.name = name;
        this.designation = designation;
        this.department = department ;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", designation='" + designation + '\'' + '}';
    }

    @Override public int compareTo(Object o) {
        Employee other = (Employee)o;
        return name.compareTo(other.name);
    }
}

class Department implements Comparable {

    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Department{" + "name='" + name + '\'' + '}';
    }

    @Override public int compareTo(Object o) {
        return this.name.compareTo(((Department)o).name);
    }
}
