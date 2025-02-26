package task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.println("---Text File Analyzer---");
        System.out.println("***************************************************");
        System.out.print("Please Enter the file path: ");
        String filePath = scanner.nextLine();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += countWordsInLine(line);
            }

            System.out.println("File Analysis Complete:");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

            System.out.print("Please Enter the word to search for: ");
            String searchWord = scanner.nextLine();
            searchWordInFile(filePath, searchWord);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int countWordsInLine(String line) {
        if (line == null || line.isEmpty()) {
            return 0;
        }
        String[] words = line.trim().split("\\s+");
        return words.length;
    }

    private static void searchWordInFile(String filePath, String searchWord) {
        int occurrenceCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    occurrenceCount++;
                    System.out.println("Found at line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }

            if (occurrenceCount == 0) {
                System.out.println("The word \"" + searchWord + "\" was not found in the file.");
            } else {
                System.out.println("The word \"" + searchWord + "\" was found " + occurrenceCount + " times.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file for word search: " + e.getMessage());
        }
    }
}
