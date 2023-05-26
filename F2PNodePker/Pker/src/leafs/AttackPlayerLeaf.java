package leafs;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class AttackPlayerLeaf extends Leaf {
    private Player targetPlayer;

    public AttackPlayerLeaf(Player targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    @Override
    public boolean isValid() {
        return targetPlayer != null;
    }

    @Override
    public int onLoop() {
        log("Found player to attack: " + targetPlayer.getName());
        targetPlayer.interact("Attack");
        return Calculations.random(600, 800);
    }
}



