package branches;

import leafs.WalkToFightAreaLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.frameworks.treebranch.Branch;

public class FightAreaBranch extends Branch {
    private WalkToFightAreaLeaf walkToFightAreaLeaf;
    private Area fightArea;

    public FightAreaBranch(Area fightArea) {
        this.fightArea = fightArea;
        this.walkToFightAreaLeaf = new WalkToFightAreaLeaf(fightArea);

        // Add leaves to the branch
        this.addLeaves(walkToFightAreaLeaf);
    }

    @Override
    public boolean isValid() {
        // This branch should be executed if the local player is not in the fight area, and if the local player is not moving
        return !fightArea.contains(Players.getLocal()) && !Players.getLocal().isMoving();
    }
}

