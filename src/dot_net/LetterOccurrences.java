package dot_net;

public class LetterOccurrences extends Occurrences implements UserInput {
    private final String text;
    private final char letter;

    LetterOccurrences(String rawInput) {
        checkInput(rawInput);

        this.text = rawInput.substring(rawInput.indexOf("\"") + 1, rawInput.lastIndexOf("\""));
        this.letter = rawInput.substring(rawInput.indexOf("\'") + 1, rawInput.lastIndexOf("\'")).charAt(0);
    }

    private void checkInput(String rawInput) {
        isValid(rawInput);
    }

    @Override
    public void isValid(String rawInput) {
        char tempLetter = rawInput.substring(rawInput.indexOf("\'") + 1, rawInput.lastIndexOf("\'")).charAt(0);
        String tempText = rawInput.substring(rawInput.indexOf("\"") + 1, rawInput.lastIndexOf("\""));

        if(!Character.isLetter(tempLetter)) {
            throw new IllegalArgumentException("First argument is not a letter");
        } else if(tempText.equals("")) {
            throw new IllegalArgumentException("Second argument is empty");
        }
    }

    @Override
    public void countOccurrences() {
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(Character.toLowerCase(letter) == text.toLowerCase().charAt(i)) {
                count++;
            }
        }
        printOutputToConsole(String.valueOf(count));
    }
}
