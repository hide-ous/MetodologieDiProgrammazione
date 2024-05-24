package lecture18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Map.Entry;

public class ParallelNLPFromWebPage {

    private static final List<String> STOPWORDS = Arrays.asList(
        "a", "an", "the", "and", "or", "but", "is", "are", "was", "were", "in", "on", "at", "to", "of", "this", "that"
    );

    public static void main(String[] args) {
        String urlString = "https://www.gutenberg.org/cache/epub/1513/pg1513.txt"; 

        try {
            URL url = new URL(urlString);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                
                Map<String, Long> wordCounts = reader.lines()
//                    .parallel()
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                    .filter(word -> !STOPWORDS.contains(word))
                    .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

                // Print the word counts, sorted in descending order by frequency
                wordCounts.entrySet().stream()
                    .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(50)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
