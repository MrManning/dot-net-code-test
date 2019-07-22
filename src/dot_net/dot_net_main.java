package dot_net;

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
                    "exit - leave program"

            //        Task 3d - Receive censored words from external file, command line
            );
            System.out.print("\n\nPlease enter task value: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch(input) {
                case "exit":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("\nChosen: Task 1 - Letter occurrences");

                    // OLD
                    // String[] task;
                    // char letter;
                    // while(true) {
                    //     try {
                    //         System.out.print("Enter a letter and string comma separated: ");
                    //         task = scanner.nextLine().split("\\s*,\\s*");
                    //         letter = task[0].charAt(0);
                    //
                    //         if(!Character.isLetter(letter) || task[1].equals("")) {
                    //             System.out.println("Invalid input! try again \n");
                    //         } else {
                    //             break;
                    //         }
                    //     } catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                    //         System.out.println("Invalid input! try again \n");
                    //     }
                    // }

                    // NEW
                    char letter;
                    String sentence;
                    while(true) {
                        try {
                            System.out.print("Enter letter and string: ");
                            input = scanner.nextLine();

                            letter = input.substring(input.indexOf("\'") + 1, input.lastIndexOf("\'")).charAt(0);
                            sentence = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));

                            if(!Character.isLetter(letter) || sentence.equals("")) {
                                System.out.println("Invalid input! try again\n");
                            } else {
                                break;
                            }
                        } catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid input! try again\n");
                            e.printStackTrace();
                        }
                    }

                    System.out.println(tasks.letterOccurrences(letter, sentence));
                    break;
                case "2":
                    System.out.println("\nChosen: Task 2 - Palindrome check");
                    System.out.print("Enter string: ");

                    input = scanner.nextLine();
                    System.out.println(tasks.isPalindrome(input));
                    break;
                case "3a":
                    System.out.println("\nChosen: Task 3a - Word occurrences");
                    System.out.print("Enter list as space separated words followed by comma separated string");
                    System.out.print("Example input: dog cat large, I have a large dog and a small cat");
                    break;
                case "3b":
                    System.out.println("\nChosen: Task 3b - Censor words");
                    break;
                case "3c":
                    System.out.println("\nChosen: Task 3c - Censor palindrome word");
                    break;
                default:
                    System.out.println("Select existing option!");
            }
        }
    }
}
