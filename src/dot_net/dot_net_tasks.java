package dot_net;

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
}
