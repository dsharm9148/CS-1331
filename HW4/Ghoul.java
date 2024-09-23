/**
 * Represents the Ghoul subclass for Ghost.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class Ghoul extends Ghost {

    /**
     * Constructs a Ghoul object with a default fright factor of 10.
     */
    public Ghoul() {
        super();
    }

    /**
     * Haunts a room layout with the Ghoul monster.
     * Locks the current room's door, preventing further access.
     * Moves the player back to their previous position.
     * @param rooms the layout of rooms.
     * @param player the player in the game.
     */
    @Override
    public void haunt(Room[][] rooms, Player player) {
        Room currentRoom = rooms[player.getCurrentRow()][player.getCurrentColumn()];
        player.setCurrentColumn(player.getPreviousColumn());
        player.setCurrentRow(player.getPreviousRow());
        System.out.printf("The doors slam shut behind %s. It doesn't seem like they "
            + "can be reopened...\n", player.getName());
        currentRoom.setIsLocked();
    }

    /**
     * Returns a string representation of the Ghoul monster.
     * @return a string representation of the Ghoul monster.
     */
    @Override
    public String toString() {
        return "Hello! I am a Ghoul!";
    }
}