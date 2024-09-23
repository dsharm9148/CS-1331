//********************************************************************
//  PeterPan.java
//  Driver that gets inputs from the user and outputs translations.
//********************************************************************

import java.util.Scanner;

/**
 * @author Diya Sharma
 * @version 21.0.1
 * Driver class for translating messages into different dialects.
 */
public class PeterPan {
    /**
     * Main method to execute the translation process.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message, repeat;
        Dialect dialect;

        // Sample messages for translation
        String[] messages = {"ARE YOU LISTENING?", "Be very quiet, and get that rabbit!", "Learning Java is very fun!"};
        for (String m : messages) {
            System.err.println("Original Message: " + m);
            System.out.println("Elmer_Fudd Translation: " + new Message(Dialect.ELMER_FUDD, m).translate());
            System.out.println("Pirate Translation: " + new Message(Dialect.PIRATE, m).translate());
            System.out.println("Computer Translation: " + new Message(Dialect.COMPUTER, m).translate() + "\n");
        }

        // Allowing user to input messages for translation
        do {
            System.out.println();
            System.out.println("Enter message to be translated:");
            message = scan.nextLine();

            System.out.println("Choose a dialect: Elmer_Fudd, Pirate, or Computer?");
            dialect = Dialect.valueOf(scan.nextLine().toUpperCase());
            Message message1 = new Message(dialect, message);
            System.out.println("Original: " + message);
            System.out.println("Translated: " + message1.translate());
            System.out.println("Translate another Sentence? (y/n)");
            repeat = scan.nextLine();

        } while (repeat.equals("y"));
        System.out.println("Count of message translations: " + Message.translationTallyString());
    }
}