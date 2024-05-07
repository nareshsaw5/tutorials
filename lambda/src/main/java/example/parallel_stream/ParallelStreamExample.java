package example.parallel_stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    static long checkPerformance(Supplier<Integer> supplier, int numberOfIterations){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations ; i++) {
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
    static int sum_sequential(){
        return IntStream.rangeClosed(1, 1000000)
                .sum();
    }
    static int sum_parallel(){
        return IntStream.rangeClosed(1, 1000000)
                .parallel()
                .sum();
    }

    public static List<String> printDistinctActivities_sequential() {
        long startTime = System.currentTimeMillis();
        List<String> result= StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime-startTime;
        System.out.println("Time taken in sequential "+timeTaken);
        return result;
    }


    public static List<String> printDistinctActivities_parallel() {
        long startTime = System.currentTimeMillis();
        List<String> result= StudentDataBase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime-startTime;
        System.out.println("Time taken in parallel "+timeTaken);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("============");
        System.out.println(checkPerformance(ParallelStreamExample::sum_sequential, 20));
        System.out.println("============");
        System.out.println(checkPerformance(ParallelStreamExample::sum_parallel, 20));

        System.out.println("============");
        printDistinctActivities_sequential();
        System.out.println("============");
        printDistinctActivities_parallel();

    }
}
