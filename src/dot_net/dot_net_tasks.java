package dot_net;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dot_net_tasks extends OutputPrinter {

    boolean isPalindrome(String input) {
        String stripped = input.replaceAll("\\s|\\p{P}", "").toLowerCase();
        for(int i = 0; i < stripped.length(); i++) {
            if(stripped.charAt(i) != stripped.charAt(stripped.length() - i - 1)) {
                return false;
            }
        }
        return true;
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
}
