package dot_net;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dot_net_tasks {
    int letterOccurrences(char letter, String input) {
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if(Character.toLowerCase(letter) == input.toLowerCase().charAt(i)) {
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

    String wordOccurrence(List<String> censoredWords, String input) {
        String[] separated = input.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new TreeMap<>();
        int total = 0;

        for(String censored : censoredWords) {
            wordCount.put(censored, 0);
            for(String word : separated) {
                // System.out.println("(censored:" + censored + "-word:" + word + ") = " + word.contains(censored));
                if(word.contains(censored)) {
                    wordCount.put(censored, wordCount.get(censored) + 1);
                    total++;
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            output.append(key).append(": ").append(value).append(", ");
        }

        output.append("total: ").append(total);
        return output.toString();
    }

    String censor(List<String> censoredWords, String text) {
        StringBuilder censoredText = new StringBuilder(text);
        for(String censored : censoredWords) {
            Pattern p = Pattern.compile("\\b" + censored.toLowerCase() + "\\b");
            Matcher m = p.matcher(text.toLowerCase());
            while(m.find()) {
                char[] charArr = new char[m.group().length() - 2];
                Arrays.fill(charArr, '$');
                censoredText.replace(m.start() + 1, m.end() - 1, new String(charArr));
            }
        }

        return censoredText.toString();
    }

    String censorPalindrome(String text) {
        List<String> palindromes = new ArrayList<>();
        String[] separated = text.split("\\s+");

        for(String sep : separated) {
            if(isPalindrome(sep)) {
                palindromes.add(sep);
            }
        }

        return censor(palindromes, text);
    }

    //    validateInput
//    storeInput
}
