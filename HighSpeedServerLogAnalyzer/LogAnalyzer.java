import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogAnalyzer {

    private Path filePath;

    public LogAnalyzer(String fileName) {
        filePath = Path.of(fileName);
    }

    // Display all logs
    public void displayLogs() throws IOException {

        Files.lines(filePath)
                .forEach(System.out::println);
    }

    // Count total logs
    public void countTotalLogs() throws IOException {

        long total = Files.lines(filePath).count();

        System.out.println("Total Log Entries : " + total);
    }

    // Count status codes using Regular Expressions
    public void countStatusCodes() throws IOException {

        Pattern pattern = Pattern.compile("\\b\\d{3}\\b");

        Map<String, Long> statusCodes =
                Files.lines(filePath)
                        .flatMap(line -> {

                            Matcher matcher = pattern.matcher(line);

                            Stream.Builder<String> builder = Stream.builder();

                            while (matcher.find()) {
                                builder.add(matcher.group());
                            }

                            return builder.build();
                        })
                        .collect(Collectors.groupingBy(
                                code -> code,
                                Collectors.counting()
                        ));

        System.out.println("\nStatus Code Frequency");

        statusCodes.forEach((code, count) ->
                System.out.println(code + " -> " + count));
    }

    // Count destination requests
    public void countDestinations() throws IOException {

        Map<String, Long> destinations =
                Files.lines(filePath)
                        .map(line -> {

                            String[] parts = line.split(" ");

                            if (parts.length >= 3) {
                                return parts[2];
                            }

                            return "Unknown";
                        })
                        .collect(Collectors.groupingBy(
                                destination -> destination,
                                Collectors.counting()
                        ));

        System.out.println("\nDestination Requests");

        destinations.forEach((destination, count) ->
                System.out.println(destination + " -> " + count));
    }
}