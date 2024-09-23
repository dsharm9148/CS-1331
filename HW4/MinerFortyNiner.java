import java.util.Random;

/**
 * Represents the MinerFortyNiner subclass for monster.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class MinerFortyNiner extends Monster {

    private Random rand = new Random();

    /**
     * Constructs a MinerFortyNiner object with a default fright factor of 49.
     */
    public MinerFortyNiner() {
        super(49);
    }

    /**
     * Haunts a room layout with the Miner Forty-Niner monster.
     * Moves the player to a random room in the layout.
     * @param roomLayout the layout of rooms.
     * @param player the player in the game.
     */
    @Override
    public void haunt(Room[][] roomLayout, Player player) {
        player.setPreviousColumn(player.getCurrentColumn());
        player.setPreviousRow(player.getCurrentRow());
        player.setCurrentColumn(rand.nextInt(roomLayout.length - 1));
        player.setCurrentRow(rand.nextInt(roomLayout.length - 1));
        System.out.printf("The miner raises its pickaxe and disappears. "
            + "A hole appears under %s and they fall into another room...\n", player.getName());
    }

    /**
     * Returns a string representation of the Miner Forty-Niner monster.
     * @return a string representation of the Miner Forty-Niner monster.
     */
    @Override
    public String toString() {
        return "OooOoO I am a MinerFortyNiner!!";
    }
}