package example.data.constructorreference;

import example.data.Student;

import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;
    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

    }
}
