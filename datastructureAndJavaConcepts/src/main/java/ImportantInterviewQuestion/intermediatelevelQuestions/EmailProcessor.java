package ImportantInterviewQuestion.intermediatelevelQuestions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.io.IOException;

import java.util.stream.Stream;

public class EmailProcessor {
    private static final String FILE_PATH = "src/main/resources/email.txt";
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Path.of(FILE_PATH))) {
            // Extract unique email addresses from file
            Set<String> uniqueEmails = lines
                    .flatMap(line -> EMAIL_PATTERN.matcher(line).results().map(MatchResult::group)) // Extract emails
                    .collect(Collectors.toSet()); // Store only unique emails

            // Send message to each unique email in parallel
            uniqueEmails.parallelStream().forEach(EmailProcessor::sendMessage);
            uniqueEmails.parallelStream().forEach(e -> System.out.println("Hi I am Rohit"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String email) {
        // Simulated email sending (replace with actual logic)
        System.out.println("Sending message to: " + email);
    }
}
