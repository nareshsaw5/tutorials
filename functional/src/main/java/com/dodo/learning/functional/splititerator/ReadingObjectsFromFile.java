package com.dodo.learning.functional.splititerator;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile {


    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/Books.txt");
        try(Stream<String> lines = Files.lines(path);){

            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> spliterator= new BookSplitIterator(baseSpliterator);

            Stream<Book> stream = StreamSupport.stream(spliterator, false);
            stream.forEach(System.out::println);

        }catch(IOException e) {
            System.out.println(e);
        }

    }

}
