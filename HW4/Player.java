/**
 * Represents the class for Player.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class Player {
    private static String name;
    private static int maxCourage = 150;
    private static int currentCourage;
    private int currentRow;
    private int currentColumn;
    private int previousRow;
    private int previousColumn;

    /**
     * Constructs a Player object with a given name and mansion size.
     * @param n the name of the player.
     * @param mansionSize the size of the mansion.
     */
    public Player(String n, int mansionSize) {
        name = n;
        currentCourage = maxCourage;
        currentRow = mansionSize / 2;
        currentColumn = mansionSize / 2;
        previousRow = currentRow;
        previousColumn = currentColumn;
    }

    /**
     * Reduces the player's courage based on the fright factor.
     * @param fright the fright factor.
     */
    public void frighten(int fright) {
        currentCourage -= fright;
        if (currentCourage < 0) {
            currentCourage = 0;
        }
        System.out.printf("%s got scared and lost some courage!"
            + " %d/%d remaining...\n", name, currentCourage, maxCourage);
    }

    /**
     * Looks for snacks in the room and increases the player's courage if found.
     * @param room the room to search for snacks.
     */
    public void lookForSnacks(Room room) {
        if (room.getHasSnacks()) {
            room.setHasSnacks(false);
            currentCourage += 25;
            if (currentCourage > maxCourage) {
                currentCourage = maxCourage;
            }
            System.out.printf("%s ate a Scooby Snack they found in the room and felt a little more confident."
                + " Courage increased to %d/%d.\n", name, currentCourage, maxCourage);
        }
    }

    /**
     * Sets the current row position of the player.
     * @param row the row position to set.
     */
    public void setCurrentRow(int row) {
        currentRow = row;
    }

    /**
     * Sets the current column position of the player.
     * @param column the column position to set.
     */
    public void setCurrentColumn(int column) {
        currentColumn = column;
    }

    /**
     * Sets the previous row position of the player.
     * @param row the row position to set.
     */
    public void setPreviousRow(int row) {
        previousRow = row;
    }

    /**
     * Sets the previous column position of the player.
     * @param column the column position to set.
     */
    public void setPreviousColumn(int column) {
        previousColumn = column;
    }

    /**
     * Gets the current column position of the player.
     * @return the current column position.
     */
    public int getCurrentColumn() {
        return currentColumn;
    }

    /**
     * Gets the current row position of the player.
     * @return the current row position.
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * Gets the previous column position of the player.
     * @return the previous column position.
     */
    public int getPreviousColumn() {
        return previousColumn;
    }

    /**
     * Gets the previous row position of the player.
     * @return the previous row position.
     */
    public int getPreviousRow() {
        return previousRow;
    }

    /**
     * Gets the name of the player.
     * @return the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current courage level of the player.
     * @return the current courage level.
     */
    public int getCurrentCourage() {
        return currentCourage;
    }
}