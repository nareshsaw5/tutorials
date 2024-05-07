package example.stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static List<String> printActivities() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<String> printDistinctActivitiesWithLoop() {
        List<String> list = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (Student student : StudentDataBase.getAllStudents()) {
            List<String> activities = student.getActivities();
            for (String string : activities) {
                if (uniqueValues.add(string)) {
                    list.add(string);
                }
            }
        }
        list.sort(null);
        return list;
    }

    public static List<String> printDistinctActivities() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    public static long printDistinctActivitiesCount() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static long printDistinctActivitiesCountWithLoop() {
        long count = 0L;
        Set<String> uniqueValues = new HashSet<>();
        for (Student student : StudentDataBase.getAllStudents()) {
            List<String> activities = student.getActivities();
            for (String string : activities) {
                if (uniqueValues.add(string)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(printActivities());
        System.out.println(printDistinctActivities());
        System.out.println(printDistinctActivitiesCount());
        System.out.println(printDistinctActivitiesCountWithLoop());
    }
}
