package DotNet;

import java.util.*;

public class WordOccurrences extends Occurrences implements UserInput {
    private final String text;
    private final List<String> censoredWords;
    Map<String, Integer> wordCount = new TreeMap<>();

    WordOccurrences(String rawInput) throws InvalidInput {
        if(checkInput(rawInput)) {
            this.text = getTextSubstring(rawInput, "and \"", 5, rawInput.lastIndexOf("\""));
            this.censoredWords = getCensoredWordsSubstring(rawInput);
        } else {
            throw new InvalidInput("Invalid input!");
        }
    }

    private String getTextSubstring(String rawInput, String textToIndex, int startIndex, int endIndex) {
        return rawInput.substring(rawInput.indexOf(textToIndex) + startIndex, endIndex);
    }

    private List<String> getCensoredWordsSubstring(String rawInput) {
        return Arrays.asList(getTextSubstring(rawInput, "{", 1, rawInput.indexOf("}")).replaceAll("\"|\\s", "").split(","));
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
    String countOccurrences() {
        String[] separated = text.toLowerCase().split("\\s+");


        for(String censored : censoredWords) {
            wordCount.put(censored, 0);
            for(String word : separated) {
                if(word.contains(censored)) {
                    wordCount.put(censored, wordCount.get(censored) + 1);
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            output.append(key).append(": ").append(value).append(", ");
        }
        int sum = wordCount.values().stream().mapToInt(i -> i).sum();
        output.append("total: ").append(sum);

        printOutputToConsole(output.toString());
        return output.toString();
    }
}
