package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // supplier doesnt' take any parameter and return a value
        Supplier<Student> studentSupplier = () -> {
            return new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"));
        };
        System.out.println(studentSupplier.get());

        // return list of database
        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println(listSupplier.get());
    }
}
