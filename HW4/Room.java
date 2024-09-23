/**
 * Represents a  class for a room.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class Room {

    private Monster monster;
    private Boolean hasSnacks;
    private Boolean hasBeenExplored;
    private Boolean isLocked;

    /**
     * Contructor for room.
     * @param m for monster.
     * @param b for boolean value.
     */
    public Room(Monster m, boolean b) {
        monster = m;
        hasSnacks = b;
        hasBeenExplored = b;
        isLocked = b;
    }
    /**
     * Checks if the room has been explored.
     * @return true if the room has been explored, otherwise false.
     */
    public boolean isExplored() {
        return hasBeenExplored;
    }

    /**
     * Checks if the room is locked.
     * @return true if the room is locked, otherwise false.
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Locks the room.
     */
    public void setIsLocked() {
        isLocked = true;
    }

    /**
     * Sets whether the room has snacks or not.
     * @param b true if the room has snacks, otherwise false.
     */
    public void setHasSnacks(boolean b) {
        hasSnacks = b;
    }

    /**
     * Checks if the room has snacks.
     * @return true if the room has snacks, otherwise false.
     */
    public Boolean getHasSnacks() {
        return hasSnacks;
    }

    /**
     * Sets the monster in the room.
     * @param m the monster to set in the room.
     */
    public void setMonster(Monster m) {
        monster = m;
    }

    /**
     * Gets the monster in the room.
     * @return the monster in the room.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Explores the room.
     * Prints a message if there's nothing interesting in the room.
     */
    public void beExplored() {
        if (monster == null && !hasSnacks) {
            System.out.println("It doesn't look like there's anything here...");
        }
        hasBeenExplored = true;
    }
}
