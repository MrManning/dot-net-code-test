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

                    String[] task;
                    char letter;
                    while(true) {
                        try {
                            System.out.print("Enter a letter and string comma separated: ");
                            task = scanner.nextLine().split("\\s*,\\s*");
                            letter = task[0].charAt(0);

                            if(!Character.isLetter(letter) || task[1].equals("")) {
                                System.out.println("Invalid input! try again \n");
                            } else {
                                break;
                            }
                        } catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid input! try again \n");
                        }
                    }

                    // System.out.println("Letter '" + letter + "' = " + tasks.letterOccurrences(letter, task[1]));
                    System.out.println(tasks.letterOccurrences(letter, task[1]));
                    break;
                case "2":
                    System.out.println("Chosen: Task 2 - Palindrome check");
                    System.out.print("Enter string: ");
                    input = scanner.nextLine();
                    System.out.println(tasks.isPalindrome(input));
                    break;
                case "3a":
                    System.out.println("Chosen: Task 3a - Word occurrences");
                    break;
                case "3b":
                    System.out.println("Chosen: Task 3b - Censor words");
                    break;
                case "3c":
                    System.out.println("Chosen: Task 3c - Censor palindrome word");
                    break;
                default:
                    System.out.println("Select existing option!");
            }
        }
    }
}
