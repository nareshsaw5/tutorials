package example.optional;

import example.data.Bike;
import example.data.Student;
import example.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
    static String getStudentName(){
        Student student = StudentDataBase.studentSupplier.get();
        if(student != null ){
            return student.getName();
        }
        return null;
    }

    static Optional<String> getStudentNameOptional() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if(studentOptional.isPresent()){
            return studentOptional.map(Student::getName);
        }
        return Optional.empty();
    }

    //flatmap
    static void optionalFlatMap(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> name = studentOptional
                .filter(student -> student.getGpa() >=3.5) // Optional<Student> Optional<Bike>
                .flatMap(Student::getBike) // Optional<Bike>
                .map(Bike::getName);
        System.out.println(name.get());

    }
    public static void main(String[] args) {
        optionalFlatMap();
    }
}
