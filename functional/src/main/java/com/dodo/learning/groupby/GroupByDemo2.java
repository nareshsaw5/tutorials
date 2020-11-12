package com.dodo.learning.groupby;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByDemo2 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Department it = new Department("IT");
        Department finance = new Department("Finance");
        Department hr = new Department("HR");
        employees.add(new Employee("John", "Manager", it));
        employees.add(new Employee("Marry", "Developer", it));
        employees.add(new Employee("Bob", "Developer", finance));
        employees.add(new Employee("Kelly", "Developer", finance));
        employees.add(new Employee("Ganesh", "Developer", hr));
        employees.add(new Employee("Shilpi", "Manager", hr));

        // we need number of employees grouped by department
        Map<Department, Long> groupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.counting()));
        groupByDepartment.forEach( (department, count) -> System.out.println(department.getName() +": "+ count));
        System.out.println("+++++++++++++++++++");

        // we need  now grouped by designation
        Map<Employee, Long> groupByDesignation = employees.stream()
                //.sorted( (e1, e2) -> e1.getDepartment().getName().compareTo(e2.getDepartment().getName()))
                //.sorted( Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(employee -> employee
                        , Collectors.counting()));
        groupByDesignation.forEach( (employee, count) -> System.out.println(employee.getDepartment().getName()+" - "+employee.getDesignation() +": "+count));
        System.out.println("+++++++++++++++++++");

        // sort it
        List<Employee> sortedEmployeeByName = employees.stream().sorted().collect(Collectors.toList());
        sortedEmployeeByName.forEach( employee -> System.out.println(employee.getDepartment().getName() +" "+employee.getName()) );
        System.out.println("+++++++++++++++++++");

        Map<Employee, Long> sortedEmployeeByDepartment = employees.stream()
                .sorted((e1, e2) -> e1.getDepartment().compareTo(e2.getDepartment()))
                .collect(Collectors.groupingBy(employee -> employee, Collectors.counting()));
        sortedEmployeeByDepartment.forEach(
                ( (employee, count) ->
                        System.out.println(employee.getDepartment().getName()+" - "+count)));
        System.out.println("+++++++++++++++++++");




    }
}
