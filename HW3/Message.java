//********************************************************************
//  Message.java
//  Translates user inputted message to corresponding dialects.
//********************************************************************

import java.util.Scanner;

/**
 * @author Diya Sharma
 * @version 21.0.1
 * Translates user-inputted messages to corresponding dialects.
 */
public class Message {
    private Dialect dialect;
    private String message;
    private boolean translateCalled;
    private static int numElmerFudd = 0;
    private static int numPirate = 0;
    private static int numComputer = 0;

    /**
     * Constructs a Message object with the specified dialect and message.
     *
     * @param dialect The dialect to translate the message to.
     * @param message The message to be translated.
     */
    public Message(Dialect dialect, String message) {
        this.dialect = dialect;
        this.message = message;
        this.translateCalled = false;
    }

    /**
     * Translates the message to the specified dialect.
     *
     * @return The translated message.
     */
    public String translate() {
        if (this.translateCalled) {
            return this.message;
        } else {
            this.translateCalled = true;
            if (this.dialect == Dialect.ELMER_FUDD) {
                message = elmerFuddTranslation();
            } else if (this.dialect == Dialect.PIRATE) {
                message = pirateTranslation();
            } else {
                message = computerTranslation();
            }
            return message;
        }
    }

    /**
     * Translates the message to Elmer Fudd's dialect.
     *
     * @return The translated message.
     */
    private String elmerFuddTranslation() {
        numElmerFudd++;
        message = message.replace("l", "w").replace("L", "W").replace("r", "w").replace("R", "W");
        if (message.indexOf("ith") != -1) {
            message = message.replace("ith", "if");
        }
        if (message.indexOf("th") != -1) {
            message = message.replace("th", "d");
        }
        if (message.indexOf("ITH") != -1) {
            message = message.replace("ITH", "IF");
        }
        if (message.indexOf("TH") != -1) {
            message = message.replace("TH", "D");
        }
        return message;
    }

    /**
     * Translates the message to Pirate dialect.
     *
     * @return The translated message.
     */
    private String pirateTranslation() {
        numPirate++;
        String translatedMessage = "";
        Scanner scan = new Scanner(message);
        while (scan.hasNext()) {
            String word = scan.next().toLowerCase();
            switch (word) {
            case "and":
                word = "n'";
                break;
            case "is":
            case "are":
            case "am":
                word = "be";
                break;
            case "my":
                word = "me";
                break;
            case "you":
                word = "ye";
                break;
            default:
                break;
            }
            int i = word.length() - 1;
            while (!Character.isLetter(word.charAt(i))) {
                i -= 1;
            }
            if (word.length() > 3 && (word.substring(i - 2, i + 1).equals("ing"))) {
                word = word.substring(0, i) + "'" + word.substring(i + 1);
            }
            if (word.length() >= 4 && word.startsWith("you")) {
                word = "ye" + word.substring(3);
            }
            translatedMessage += word + " ";
        }
        return "Yarr! " + translatedMessage.substring(0, 1).toUpperCase() + translatedMessage.substring(1);
    }

    /**
     * Translates the message to computer binary.
     *
     * @return The translated message.
     */
    private String computerTranslation() {
        numComputer++;
        String translatedMessage = "";
        Scanner scan = new Scanner(message);
        while (scan.hasNext()) {
            char[] charArrary = scan.next().toCharArray();
            for (char c : charArrary) {
                translatedMessage += Integer.toBinaryString(c) + " ";
            }
        }
        return translatedMessage;
    }
    /**
     * Returns a string containing the tally of translations.
     *
     * @return The tally of translations.
     */
    public static String translationTallyString() {
        return numElmerFudd + " " + numPirate + " " + numComputer;
    }
}
