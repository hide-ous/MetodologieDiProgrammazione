package lecture18;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.Map.Entry;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.Map.Entry;

public class ParallelNLPExample {

    private static final List<String> STOPWORDS = Arrays.asList(
        "a", "an", "the", "and", "or", "but", "is", "are", "was", "were", "in", "on", "at", "to", "of", "this", "that"
    );

    public static void main(String[] args) {
        Path filePath = Paths.get("input.txt");

        try (Stream<String> lines = Files.lines(filePath).parallel()) {
            Map<String, Long> wordCounts = lines
                .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                .filter(word -> !STOPWORDS.contains(word))
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

            // Print the word counts, sorted in descending order by frequency
            wordCounts.entrySet().stream()
                .parallel()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
