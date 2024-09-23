/**
 * Represents the Ghost subclass for monster.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class Ghost extends Monster {

    /**
     * Constructs a Ghost object with a default fright factor of 10.
     */
    public Ghost() {
        super(10);
    }

    /**
     * Haunts a room layout with the Ghost monster.
     * Moves the player back to their previous position.
     * @param roomLayout the layout of rooms.
     * @param player the player in the game.
     */
    @Override
    public void haunt(Room[][] roomLayout, Player player) {
        player.setCurrentColumn(player.getPreviousColumn());
        player.setCurrentRow(player.getPreviousRow());
        System.out.printf("%s is teleported back to where they were before. \n", player.getName());
    }

    /**
     * Returns a string representation of the Ghost monster.
     * @return a string representation of the Ghost monster.
     */
    @Override
    public String toString() {
        return "I am a Ghost! Boo!";
    }
}