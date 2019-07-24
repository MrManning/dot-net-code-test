package DotNet;

import java.util.stream.IntStream;

public class LetterOccurrences extends Occurrences implements UserInput {
    private String text;
    private char letter;

    LetterOccurrences(String rawInput) throws InvalidInput {
        if(checkInput(rawInput)) {
            this.text = getTextSubstring(rawInput, "\"");
            this.letter = getTextSubstring(rawInput, "\'").charAt(0);
        } else {
            throw new InvalidInput("Invalid input!");
        }
    }

    private String getTextSubstring(String rawInput, String s) {
        return rawInput.substring(rawInput.indexOf(s) + 1, rawInput.lastIndexOf(s));
    }

    private boolean checkInput(String rawInput) {
        return isValid(rawInput);
    }

    @Override
    public boolean isValid(String rawInput) {
        try {
            char tempLetter = getTextSubstring(rawInput, "\'").charAt(0);
            String tempText = getTextSubstring(rawInput, "\"");

            if(!Character.isLetter(tempLetter) || tempText.equals("")) {
                return false;
            }
        } catch(StringIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    @Override
    String countOccurrences() {
        int count = (int) IntStream.range(0, text.length()).filter(i -> Character.toLowerCase(letter) == text.toLowerCase().charAt(i)).count();

        printOutputToConsole(String.valueOf(count));
        return String.valueOf(count);
    }
}
