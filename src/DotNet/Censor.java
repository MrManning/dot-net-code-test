package DotNet;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Censor extends OutputPrinter implements UserInput {
    private String text;
    private List<String> censoredWords;

    Censor() {}

    Censor(String rawInput) throws InvalidInput {
        if(checkInput(rawInput)) {
            this.text = rawInput.substring(rawInput.indexOf("and \"") + 5, rawInput.lastIndexOf("\""));
            this.censoredWords = Arrays.asList(rawInput.substring(rawInput.indexOf("{") + 1, rawInput.indexOf("}")).replaceAll("\"|\\s", "").split(","));
        } else {
            throw new InvalidInput("Invalid input!");
        }
    }

    private boolean checkInput(String rawInput) {
        return isValid(rawInput);
    }

    @Override
    public boolean isValid(String rawInput) {
        try {
            List<String> tempCensoredWords = Arrays.asList(rawInput.substring(rawInput.indexOf("{") + 1, rawInput.indexOf("}")).replaceAll("\"|\\s", "").split(","));
            String tempText = rawInput.substring(rawInput.indexOf("and \"") + 5, rawInput.lastIndexOf("\""));

            if(tempCensoredWords.size() == 1 && "".equals(tempCensoredWords.get(0)) || tempText.equals("")) {
                return false;
            }
        } catch(StringIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    String getText() {
        return text;
    }

    List<String> getCensoredWords() {
        return censoredWords;
    }

    String censorWords(List<String> censoredWords, String text) {
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
}
