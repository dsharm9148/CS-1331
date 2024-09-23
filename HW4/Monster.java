/**
 * Represents an abstract class for a monster.
 * @author Diya Sharma
 * @version 21.0.1
 */

public abstract class Monster {
    protected int frightFactor;

    /**
     * Constructs a Monster object with a given fright factor.
     * @param factor the fright factor of the monster.
     */
    public Monster(int factor) {
        this.frightFactor = factor;
    }

    /**
     * Frightens the player with the monster.
     * @param player the player to frighten.
     */
    public void frighten(Player player) {
        System.out.printf("Suddenly, something appears in front of %s!\n", player.getName());
        System.out.println(toString());
        player.frighten(frightFactor);
    }

    /**
     * Haunts a room layout with the monster.
     * @param roomLayout the layout of rooms.
     * @param player the player in the game.
     */
    public abstract void haunt(Room[][] roomLayout, Player player);
}