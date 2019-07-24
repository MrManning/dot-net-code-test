package DotNet;

import java.util.ArrayList;
import java.util.List;

public class Palindromes implements UserInput {
    private String text;

    Palindromes(String rawInput) throws InvalidInput {
        if(checkInput(rawInput)) {
            this.text = getTextSubstring(rawInput);
        } else {
            throw new InvalidInput("Invalid input!");
        }
    }

    private String getTextSubstring(String rawInput) {
        return rawInput.substring(rawInput.indexOf("\"") + 1, rawInput.lastIndexOf("\""));
    }

    private boolean checkInput(String rawInput) {
        return isValid(rawInput);
    }

    @Override
    public boolean isValid(String rawInput) {
        try {
            String tempText = getTextSubstring(rawInput);

            if(tempText.equals("")) {
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

    boolean isPalindrome() {
        String stripped = text.replaceAll("\\s|\\p{P}", "").toLowerCase();
        for(int i = 0; i < stripped.length(); i++) {
            if(stripped.charAt(i) != stripped.charAt(stripped.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String text) {
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != text.charAt(text.length() - i - 1)) {

                return false;
            }
        }
        return true;
    }

    List<String> findPalindromes() {
        List<String> palindromes = new ArrayList<>();
        String[] separated = text.split("\\s+");

        for(String sep : separated) {
            if(isPalindrome(sep.toLowerCase())) {
                palindromes.add(sep);
            }
        }
        return palindromes;
    }
}
