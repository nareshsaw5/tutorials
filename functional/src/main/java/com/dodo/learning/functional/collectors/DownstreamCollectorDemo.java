package com.dodo.learning.functional.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DownstreamCollectorDemo {

    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/EmployeeData.txt");

        try (Stream<String> lines = Files.lines(path);) {
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordsSplitIterator = words.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordsSplitIterator);
            Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employees = employeeStream.collect(Collectors.toList());

            Map<String, Long> employeeCountByDesignation = employees.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));
            System.out.println(employeeCountByDesignation);

            // lets now find the sum of salary under each group
            Map<String, Double> salaryByDesignationGroup = employees.stream().collect(
                    Collectors.groupingBy(e -> e.getDesignation(), Collectors.summingDouble(e -> e.getSalary())));
            System.out.println(salaryByDesignationGroup);

            Map<String, Optional<Employee>> maxSalary = employees.stream().collect(Collectors
                    .groupingBy(e -> e.getDesignation(), Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
            System.out.println(maxSalary);

            // giving error
           /* Map<String, Optional<Double>> maxSalaryByDesination = employees.stream().collect(Collectors
                    .groupingBy(e -> e.getDesignation(), Collectors
                            .mapping(e -> e.getSalary(), Collectors.maxBy(Comparator.comparing(Function.identity())))));
            System.out.println(maxSalaryByDesination);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
