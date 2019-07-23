// TODO Change me
package dot_net;

import java.util.Scanner;

// Todo Change me
public class dot_net_main {
    public static void main(String[] args) throws InvalidInput {
        while(true) {
            System.out.print("\nOptions: \n" +
                    "Task 1 - Letter occurrences \n" +
                    "Task 2 - Palindrome check \n" +
                    "Task 3a - Word occurrences \n" +
                    "Task 3b - Censor words \n" +
                    "Task 3c - Censor palindrome word \n" +
                    "exit 0 - Leave program"

            //        Task 3d - file input (either a file browser or by entering the filename), text input (from command line or application input), voice input (possibly using sphinx or something similar)
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

                    // do {
                    //     System.out.print("Enter text: ");
                    //     input = scanner.nextLine();
                    // } while(!checkInput(input));
                    //
                    // System.out.println(tasks.isPalindrome(input));

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

                    // while(true) {
                    //     try {
                    //         System.out.print("Enter censored words and text: ");
                    //         input = scanner.nextLine();
                    //
                    //         text = input.substring(input.indexOf("and \"") + 5, input.lastIndexOf("\""));
                    //         censoredWords = Arrays.asList(input.substring(input.indexOf("{") + 1, input.indexOf("}"))
                    //                 .replaceAll("\"|\\s", "")
                    //                 .split(","));
                    //
                    //         if(checkInput(text) && !(censoredWords.size() == 1 && "".equals(censoredWords.get(0)))) {
                    //             break;
                    //         }
                    //
                    //     } catch(StringIndexOutOfBoundsException e) {
                    //         System.out.println("Invalid input! try again\n");
                    //     }
                    // }
                    //
                    // System.out.println(tasks.censor(censoredWords, text));

                    break;
                }
                case "3c": {
                    System.out.println("\nChosen: Task 3c - Censor palindrome word");

                    // while(true) {
                    //     try {
                    //         System.out.print("Enter text: ");
                    //         input = scanner.nextLine();
                    //
                    //         text = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));
                    //
                    //         if(checkInput(text)) break;
                    //     } catch(StringIndexOutOfBoundsException e) {
                    //         System.out.println("Invalid input! try again\n");
                    //     }
                    // }
                    //
                    // System.out.println(tasks.censorPalindrome(text));

                    break;
                }
                default: {
                    System.out.println("Select existing option!");
                }
            }
        }
    }
}
