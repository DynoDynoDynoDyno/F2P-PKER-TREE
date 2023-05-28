package leafs;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class AttackPlayerLeaf extends Leaf {
    private FindTargetLeaf findTargetLeaf;

    public AttackPlayerLeaf(FindTargetLeaf findTargetLeaf) {
        this.findTargetLeaf = findTargetLeaf;
    }

    @Override
    public boolean isValid() {
        return findTargetLeaf.getTargetPlayer() != null;
    }

    @Override
    public int onLoop() {
        Player targetPlayer = findTargetLeaf.getTargetPlayer();
        log("Found player to attack: " + targetPlayer.getName());
        boolean interactionSuccess = targetPlayer.interact("Attack");
        log("Interaction success: " + interactionSuccess);
        return 50;
    }

}



