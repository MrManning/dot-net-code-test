package dot_net;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordOccurrences extends Occurrences implements UserInput {
    private final String text;
    private final List<String> censoredWords;

    public WordOccurrences(String rawInput) {
        checkInput(rawInput);

        this.text = rawInput.substring(rawInput.indexOf("and \"") + 5, rawInput.lastIndexOf("\""));
        this.censoredWords = Arrays.asList(rawInput.substring(rawInput.indexOf("{") + 1, rawInput.indexOf("}"))
                .replaceAll("\"|\\s", "")
                .split(","));
    }

    private void checkInput(String rawInput) {
        isValid(rawInput);
    }

    @Override
    public void isValid(String rawInput) {
        List<String> tempWords = Arrays.asList(rawInput.substring(rawInput.indexOf("{") + 1, rawInput.indexOf("}"))
                .replaceAll("\"|\\s", "")
                .split(","));

        String tempText = rawInput.substring(rawInput.indexOf("and \"") + 5, rawInput.lastIndexOf("\""));

        if(tempWords.size() == 1 && "".equals(tempWords.get(0))) {
            throw new IllegalArgumentException("Word list is empty");
        } else if(tempText.equals("")) {
            throw new IllegalArgumentException("Second argument is empty");
        }
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
