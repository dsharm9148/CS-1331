import java.util.Scanner;

/**
 * Represents the class for HauntedMansion.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class HauntedMansion {
    private static String name;
    private static Player player;
    private static Room[][] rooms;
    private static HauntedHelper h;

    private static Scanner scan = new Scanner(System.in);

    /**
     * Constructs a HauntedMansion object with a given name, player, mansion size, percentage of monsters,
     * and number of rooms with snacks.
     * @param n the name of the haunted mansion.
     * @param p the player in the game.
     * @param size the size of the mansion.
     * @param scan the name of the scanner obj.
     * @param percentMonster the percentage of rooms with monsters.
     * @param numberRoomsWithSnacks the number of rooms with snacks.
     */
    public HauntedMansion(String n, Player p, Scanner scan, int size, int percentMonster, int numberRoomsWithSnacks) {
        name = n;
        player = p;
        rooms = new Room[size + 1][size + 1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                rooms[i][j] = new Room(null, false);
            }
        }
        h = new HauntedHelper(rooms);
        h.selectGoalRoom();
        for (int i = 0; i < (int) ((size * size) * (percentMonster * 0.01)); i++) {
            h.placeMonster();
        }
        for (int i = 0; i < numberRoomsWithSnacks; i++) {
            h.placeSnack();
        }
    }

    /**
     * Method invoked when the player wins the game.
     */
    public void win() {
        System.out.println("Congrats! You won!");
    }

    /**
     * Method invoked when the player loses the game.
     */
    public void lose() {
        System.out.println("Oh no! You lost!");
    }

    /**
     * Moves the player in the haunted mansion.
     */
    public void move() {
        System.out.println("Choose a direction to move: (l, r, u, d, or map)");
        String move = scan.next();
        if (!move.equals("l") && !move.equals("r") && !move.equals("u")
            && !move.equals("d") && !move.equals("map")) {
            System.out.println("Please input a valid option (l, r, u, d, or map)");
        }
        switch (move) {
        case "l":
            if (player.getCurrentColumn() - 1 < 0) {
                System.out.println("There is only a wall in that direction!");
                move();
            }
            if (rooms[player.getCurrentRow()][player.getCurrentColumn() - 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            }
            player.setPreviousColumn(player.getCurrentColumn());
            player.setCurrentColumn(player.getPreviousColumn() - 1);
            break;
        case "r":
            if (player.getCurrentColumn() + 1 >= rooms.length) {
                System.out.println("There is only a wall in that direction!");
                move();
            }
            if (rooms[player.getCurrentRow()][player.getCurrentColumn() + 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            }
            player.setPreviousColumn(player.getCurrentColumn());
            player.setCurrentColumn(player.getPreviousColumn() + 1);
            break;
        case "u":
            if (player.getCurrentRow() - 1 < 0) {
                System.out.println("There is only a wall in that direction!");
                move();
            }
            if (rooms[player.getCurrentRow() - 1][player.getCurrentColumn()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            }
            player.setPreviousRow(player.getCurrentRow());
            player.setCurrentRow(player.getPreviousRow() - 1);
            break;
        case "d":
            if (player.getCurrentRow() + 1 >= rooms.length) {
                System.out.println("There is only a wall in that direction!");
                move();
            }
            if (rooms[player.getCurrentRow() + 1][player.getCurrentColumn()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            }
            player.setPreviousRow(player.getCurrentRow());
            player.setCurrentRow(player.getPreviousRow() + 1);
            break;
        case "map":
            System.out.print(HauntedHelper.createMansionMap(rooms, player.getCurrentRow(), player.getCurrentColumn()));
            break;
        default:
            break;
        }
    }

    /**
     * Enters the haunted mansion and initiates the game.
     */
    public void enter() {
        System.out.printf("%s enters %s. The halls are dimly lit and sounds echo from deeper within...\n%s "
            + "looks behind them only to see the entrance is gone! "
            + "They'll have to find a way out...\n", player.getName(), name, player.getName());
        while (player.getCurrentCourage() > 0) {
            Room currentRoom = rooms[player.getCurrentRow()][player.getCurrentColumn()];
            if (player.getCurrentColumn() == h.getGoalLocationColumn()
                && player.getCurrentRow() == h.getGoalLocationRow()) {
                win();
                break;
            } else {
                System.out.printf("%s looks around the room...\n", player.getName());
                currentRoom.beExplored();
            }
            player.lookForSnacks(currentRoom);
            if (currentRoom.getMonster() != null) {
                currentRoom.getMonster().frighten(player);
                currentRoom.getMonster().haunt(rooms, player);
            } else {
                move();
            }
        }
        if (player.getCurrentCourage() <= 0) {
            lose();
        }
    }
}