import java.util.Scanner;

/**
 * Represents a driver class for running the haunted mansion game.
 * @author Diya Sharma
 * @version 21.0.1
 */
public class MansionDriver {

    /**
     * Main method to start the haunted mansion game.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player name: ");
        String name = scan.nextLine();
        System.out.println("Mansion name: ");
        String mansionName = scan.nextLine();
        System.out.println("Mansion size: ");
        int size = scan.nextInt();
        System.out.println("Percentage of rooms which should contain monsters (out of 100): ");
        int percent = scan.nextInt();
        System.out.println("Number of rooms which should have Scooby Snacks: ");
        int numRooms = scan.nextInt();
        Player player1 = new Player(name, size);
        HauntedMansion mansion1 = new HauntedMansion(mansionName, player1, scan, size, percent, numRooms);
        mansion1.enter();
    }
}
