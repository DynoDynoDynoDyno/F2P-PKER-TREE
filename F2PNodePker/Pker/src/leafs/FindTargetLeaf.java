package leafs;

import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Leaf;
import org.dreambot.api.wrappers.interactive.Player;

import static org.dreambot.api.utilities.Logger.log;

public class FindTargetLeaf extends Leaf {
    private Player targetPlayer;  // Make this an instance variable

    @Override
    public boolean isValid() {
        return Players.getLocal().getInteractingCharacter() == null && !Players.getLocal().isInCombat();
    }

    @Override
    public int onLoop() {
        // If not interacting with a player and not in combat, find a new target
        targetPlayer = Players.closest(p -> p != null && !p.equals(Players.getLocal()) &&
                p.getLevel() >= (Players.getLocal().getLevel() - Combat.getWildernessLevel()) &&
                p.getLevel() <= (Players.getLocal().getLevel() + Combat.getWildernessLevel()) &&
                !p.isInCombat());
        targetPlayer.interact("Attack");

        // Logging statements
        log("Local Player: " + (Players.getLocal() != null ? Players.getLocal().getName() : "None"));
        log("Wilderness Level: " + Combat.getWildernessLevel());
        log("Target Player: " + (targetPlayer != null ? targetPlayer.getName() : "None"));

        return 50;
    }

    // Add a getter method for targetPlayer
    public Player getTargetPlayer() {
        return targetPlayer;
    }
    public int getLocalPlayerCombatLevel() {
        // Return local player's combat level
        return Players.getLocal().getLevel();
    }

    public int getWildernessLevel() {
        // Return wilderness level
        return Combat.getWildernessLevel();
    }
    public boolean isLocalPlayerInCombat() {
        // Return whether the local player is in combat
        return Players.getLocal().isInCombat();
    }

}


