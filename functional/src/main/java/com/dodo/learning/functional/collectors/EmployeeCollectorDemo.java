package com.dodo.learning.functional.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EmployeeCollectorDemo {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");
        try(Stream<String> lines = Files.lines(path);){
            Stream<String> words = lines.flatMap( line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordsSplitIterator = words.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordsSplitIterator);
            Stream<Employee> employeeStream  = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employees  = employeeStream.collect(Collectors.toList());

            // collect the list of employee names
            List<String> names = employees.stream()
                    .map( employee -> employee.getName())
                    .collect(Collectors.toList());

            names.stream().forEach(System.out::println);
            // set of designations
            Set<String> employeeDesignationSet = employees.stream().map(employee -> employee.getCity())
                    .collect(Collectors.toSet());
            employeeDesignationSet.forEach(System.out::println);

            Map<Integer, String> nameById = employees.stream().collect(
                    Collectors.toMap( e -> e.getId(), e -> e.getName() )
            );

            nameById.forEach( (k, v) -> {
                System.out.println(k  +": " + v);
            });

            //another flavour with partition
            Map<Boolean, List<Employee>> employeePartitionByGender = employees.stream()
                    .collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));
            List<Employee> maleEmployee = employeePartitionByGender.get(true);
            List<Employee> femaleEmployee = employeePartitionByGender.get(false);
            System.out.println(maleEmployee);
            System.out.println(femaleEmployee);

            Map<String, List<Employee>> employeeByDesignation = employees.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation()));
            List<Employee> architects = employeeByDesignation.get("Architect");
            List<Employee> leads = employeeByDesignation.get("Lead");
            List<Employee> developers = employeeByDesignation.get("Developer");
            System.out.println(architects);
            System.out.println(leads);
            System.out.println(developers);


            //------------
            String employeeNames = employees.stream().map(e -> e.getName()).collect(Collectors.joining(", "));
            System.out.println(employeeNames);


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
