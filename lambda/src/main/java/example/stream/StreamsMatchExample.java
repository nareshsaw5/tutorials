package example.stream;

import example.data.StudentDataBase;

public class StreamsMatchExample {

    static boolean allMatch(Double gpa) {
       return StudentDataBase.getAllStudents().stream().allMatch( student -> student.getGpa() >= gpa);
    };

    static boolean anyMatch(Double gpa) {
        return StudentDataBase.getAllStudents().stream().anyMatch( student -> student.getGpa() >= gpa);
    };

    static boolean noneMatch(Double gpa) {
        return StudentDataBase.getAllStudents().stream().noneMatch( student -> student.getGpa() >= gpa);
    };

    public static void main(String[] args) {
        System.out.println("Should return false as all of the student do not have gpa > 3.9 : " +allMatch(3.9));
        System.out.println("Should return true as all of the student have gpa > 3.6 : " +allMatch(3.4));
        System.out.println("Should return true as one of the student have gpa > 4 : " +anyMatch(4.0));
        System.out.println("Should return true as none of the student have gpa > 4 : " +noneMatch(5.0));
    }
}
