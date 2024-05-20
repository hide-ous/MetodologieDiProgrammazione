package lecture18;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.Map.Entry;

public class ParallelNLPExample {

    private static final List<String> STOPWORDS = Arrays.asList(
        "a", "an", "the", "and", "or", "but", "is", "are", "was", "were", "in", "on", "at", "to", "of"
    );

    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. The dog was not amused.";

        // Tokenize, filter stopwords, and count word frequency using parallel streams
        Map<String, Long> wordCounts = Arrays.stream(text.toLowerCase().split("\\W+"))
            .parallel()  // Enable parallel processing
            .filter(word -> !STOPWORDS.contains(word))
            .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        // Print the word counts, sorted in descending order by frequency
        wordCounts.entrySet().stream()
            .parallel()  // Enable parallel processing for sorting and printing
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
