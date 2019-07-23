package dot_net;

import java.util.*;

public class WordOccurrences extends Occurrences implements UserInput {
    private final String text;
    private final List<String> censoredWords;

    WordOccurrences(String rawInput) throws InvalidInput {
        if(checkInput(rawInput)) {
            this.text = getTextSubstring(rawInput, "and \"", 5, rawInput.lastIndexOf("\""));
            this.censoredWords = getCensoredWordsSubstring(rawInput);
        } else {
            throw new InvalidInput("Invalid input!");
        }
    }

    private List<String> getCensoredWordsSubstring(String rawInput) {
        return Arrays.asList(getTextSubstring(rawInput, "{", 1, rawInput.indexOf("}")).replaceAll("\"|\\s", "").split(","));
    }

    private String getTextSubstring(String rawInput, String s, int startIndex, int endIndex) {
        return rawInput.substring(rawInput.indexOf(s) + startIndex, endIndex);
    }

    private boolean checkInput(String rawInput) {
        return isValid(rawInput);
    }

    @Override
    public boolean isValid(String rawInput) {
        try {
            List<String> tempWords = getCensoredWordsSubstring(rawInput);
            String tempText = getTextSubstring(rawInput, "and \"", 5, rawInput.lastIndexOf("\""));

            if(tempWords.size() == 1 && "".equals(tempWords.get(0)) || tempText.equals("")) {
                return false;
            }
        } catch(StringIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    @Override
    void countOccurrences() {
        String[] separated = text.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new TreeMap<>();

        for(String censored : censoredWords) {
            wordCount.put(censored, 0);
            for(String word : separated) {
                if(word.contains(censored)) {
                    wordCount.put(censored, wordCount.get(censored) + 1);
                }
            }
        }

        printOutputToConsole(wordCount);
    }
}
