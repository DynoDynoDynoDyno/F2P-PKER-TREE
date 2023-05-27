package branches;

import leafs.RoamingLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.wrappers.interactive.Player;


public class RoamingBranch extends Branch {
    private final Area fightArea;


    public RoamingBranch(Area fightArea) {
        this.fightArea = fightArea;

        addLeaves(new RoamingLeaf(fightArea));
    }

    @Override
    public boolean isValid() {
        Player localPlayer = Players.getLocal();

        // Check if the player is in combat
        boolean isInCombat = localPlayer != null && localPlayer.isInCombat();

        // Return true if the player is in the fight area, not in combat
        return fightArea.contains(localPlayer) && !isInCombat;
    }
}

