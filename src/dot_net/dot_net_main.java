package dot_net;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dot_net_main {
    public static void main(String[] args) {
        dot_net_tasks tasks = new dot_net_tasks();
        while(true) {
            System.out.print("\nOptions: \n" +
                    "Task 1 - Letter occurrences \n" +
                    "Task 2 - Palindrome check \n" +
                    "Task 3a - Word occurrences \n" +
                    "Task 3b - Censor words \n" +
                    "Task 3c - Censor palindrome word \n" +
                    "exit 0 - Leave program"

            //        Task 3d - Receive censored words from external file, command line (text input), google assistant/siri (voice input)
            );
            System.out.print("\n\nPlease enter task value: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch(input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("\nChosen: Task 1 - Letter occurrences");

                    char letter;
                    String text;
                    while(true) {
                        try {
                            System.out.print("Enter letter and text: ");
                            input = scanner.nextLine();

                            letter = input.substring(input.indexOf("\'") + 1, input.lastIndexOf("\'")).charAt(0);
                            text = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));

                            if(!Character.isLetter(letter) || text.equals("")) {
                                System.out.println("Invalid input! try again\n");
                            } else {
                                break;
                            }
                        } catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid input! try again\n");
                        }
                    }

                    System.out.println(tasks.letterOccurrences(letter, text));
                    break;
                case "2":
                    System.out.println("\nChosen: Task 2 - Palindrome check");

                    do {
                        System.out.print("Enter text: ");
                        input = scanner.nextLine();
                    } while(!checkInput(input));

                    System.out.println(tasks.isPalindrome(input));
                    break;
                case "3a":
                    System.out.println("\nChosen: Task 3a - Word occurrences");

                    List<String> censoredWords;
                    while(true) {
                        try {
                            System.out.print("Enter censored words and text: ");
                            input = scanner.nextLine();

                            censoredWords = Arrays.asList(input.substring(input.indexOf("{") + 1, input.indexOf("}"))
                                    .replaceAll("\"|\\s", "")
                                    .split(","));

                            text = input.substring(input.indexOf("and \"") + 5, input.lastIndexOf("\""));

                            if(checkInput(text)) break;
                        } catch(StringIndexOutOfBoundsException | NegativeArraySizeException e) {
                            System.out.println("Invalid input! try again\n");
                        }
                    }

                    System.out.println(tasks.wordOccurrence(censoredWords, text));
                    break;
                case "3b":
                    System.out.println("\nChosen: Task 3b - Censor words");

                    while(true) {
                        try {
                            System.out.print("Enter censored words and text: ");
                            input = scanner.nextLine();

                            censoredWords = Arrays.asList(input.substring(input.indexOf("{") + 1, input.indexOf("}"))
                                    .replaceAll("\"|\\s", "")
                                    .split(","));

                            text = input.substring(input.indexOf("and \"") + 5, input.lastIndexOf("\""));

                            if(checkInput(text)) break;
                        } catch(StringIndexOutOfBoundsException e) {
                            System.out.println("Invalid input! try again\n");
                        }
                    }

                    System.out.println(tasks.censor(censoredWords, text));
                    break;
                case "3c":
                    System.out.println("\nChosen: Task 3c - Censor palindrome word");

                    while(true) {
                        try {
                            System.out.print("Enter text: ");
                            input = scanner.nextLine();

                            text = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));

                            if(checkInput(text)) break;
                        } catch(StringIndexOutOfBoundsException e) {
                            System.out.println("Invalid input! try again\n");
                        }
                    }

                    System.out.println(tasks.censorPalindrome(text));
                    break;
                default:
                    System.out.println("Select existing option!");
            }
        }
    }

    private static boolean checkInput(String input) {
        if(input.equals("")) {
            System.out.println("Invalid input! try again\n");
        } else {
            return true;
        }
        return false;
    }
}
