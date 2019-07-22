package dot_net;

import java.util.*;
import java.util.stream.Collectors;

class dot_net_tasks {
    int letterOccurrences(char letter, String input) {
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if(letter == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPalindrome(String input) {
        String stripped = input.replaceAll("\\s|\\p{P}", "").toLowerCase();
        for(int i = 0; i < stripped.length(); i++) {
            if(stripped.charAt(i) != stripped.charAt(stripped.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> wordOccurrence(List<String> censoredWords, String input) {
        String[] separated = input.split("\\s+");
        // List<String> separated = Arrays.asList(input.split("\\s+"));
        Map<String, Integer> wordCount = new TreeMap<>();

        for(String censored : censoredWords) {
            long count = Arrays.stream(separated).filter(str -> str.contains(censored)).count();
            // long count = separated.stream().filter(str -> str.contains(censored)).count();
            // wordCount.put(censored, (int) count);
            int total = 0;
            System.out.println("word: " + censored + ": " + count);
            for(String words : separated) {
                if(words.contains(censored)) {
                    wordCount.merge(censored, 1, Integer::sum);
                    total++;
                }
            }
        }


        return new ArrayList<>(wordCount.values());
    }
}
