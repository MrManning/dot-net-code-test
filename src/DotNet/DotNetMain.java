package DotNet;

import java.util.Scanner;

public class DotNetMain {
    public static void main(String[] args) {
        while(true) {
            System.out.print("\nOptions: \n" +
                    "Task 1 - Letter occurrences \n" +
                    "Task 2 - Palindrome check \n" +
                    "Task 3a - Word occurrences \n" +
                    "Task 3b - Censor words \n" +
                    "Task 3c - Censor palindrome word \n" +
                    "exit 0 - Leave program"
            );
            System.out.print("\n\nPlease enter task value: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch(input) {
                case "0": {
                    System.exit(0);
                    break;
                }
                case "1": {
                    System.out.println("\nChosen: Task 1 - Letter occurrences");
                    Occurrences occur;

                    while(true) {
                        System.out.print("Enter letter and text: ");

                        try {
                            occur = new LetterOccurrences(scanner.nextLine());
                            break;
                        } catch(InvalidInput invalidInput) {
                            System.err.print(invalidInput.getMessage() + "\n");
                        }
                    }

                    occur.countOccurrences();
                    break;
                }
                case "2": {
                    System.out.println("\nChosen: Task 2 - Palindrome check");
                    Palindromes palindromes;

                    while(true) {
                        System.out.print("Enter text: ");

                        try {
                            palindromes = new Palindromes(scanner.nextLine());
                            break;
                        } catch(InvalidInput invalidInput) {
                            System.err.print(invalidInput.getMessage() + "\n");
                        }
                    }

                    System.out.println(palindromes.isPalindrome());
                    break;
                }
                case "3a": {
                    System.out.println("\nChosen: Task 3a - Word occurrences");
                    Occurrences occur;

                    while(true) {
                        System.out.print("Enter censored words and text: ");

                        try {
                            occur = new WordOccurrences(scanner.nextLine());
                            break;
                        } catch(InvalidInput invalidInput) {
                            System.err.print(invalidInput.getMessage() + "\n");
                        }
                    }

                    occur.countOccurrences();
                    break;
                }
                case "3b": {
                    System.out.println("\nChosen: Task 3b - Censor words");
                    Censor censor;

                    while(true) {
                        System.out.print("Enter censored words and text: ");

                        try {
                            censor = new Censor(scanner.nextLine());
                            break;
                        } catch(InvalidInput invalidInput) {
                            System.err.print(invalidInput.getMessage() + "\n");
                        }
                    }

                    System.out.println(censor.censorWords(censor.getCensoredWords(), censor.getText()));
                    break;
                }
                case "3c": {
                    System.out.println("\nChosen: Task 3c - Censor palindrome word");
                    Palindromes palindromes;
                    Censor censor = new Censor();

                    while(true) {
                        System.out.print("Enter text: ");

                        try {
                            palindromes = new Palindromes(scanner.nextLine());

                            break;
                        } catch(InvalidInput invalidInput) {
                            System.err.print(invalidInput.getMessage() + "\n");
                        }
                    }

                    System.out.println(censor.censorWords(palindromes.findPalindromes(), palindromes.getText()));
                    break;
                }
                default: {
                    System.out.println("Select existing option!");
                }
            }
        }
    }
}
