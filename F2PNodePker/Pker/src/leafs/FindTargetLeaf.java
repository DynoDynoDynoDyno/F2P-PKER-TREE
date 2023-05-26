package leafs;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Leaf;
import org.dreambot.api.wrappers.interactive.Player;

public class FindTargetLeaf extends Leaf {
    private Player targetPlayer;

    @Override
    public boolean isValid() {
        return Players.getLocal().getInteractingCharacter() == null && !Players.getLocal().isInCombat();
    }

    @Override
    public int onLoop() {
        // If not interacting with a player and not in combat, find a new target
        targetPlayer = Players.closest(p -> p != null && !p.equals(Players.getLocal()) &&
                Math.abs(p.getLevel() - Players.getLocal().getLevel()) <= Combat.getWildernessLevel() &&
                !p.isInCombat());
        return Calculations.random(600, 800);
    }
}


