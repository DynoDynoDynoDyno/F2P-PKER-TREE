package branches;

import leafs.FindTargetLeaf;
import leafs.RoamingLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.wrappers.interactive.Player;

public class RoamingBranch extends Branch {
    private final Area fightArea;
    private final FindTargetLeaf findTargetLeaf;


    public RoamingBranch(Area fightArea, FindTargetLeaf findTargetLeaf) {
        this.fightArea = fightArea;
        this.findTargetLeaf = findTargetLeaf;

        addLeaves(new RoamingLeaf(fightArea), findTargetLeaf);
    }

    @Override
    public boolean isValid() {
        Player localPlayer = Players.getLocal();
        boolean isInCombat = localPlayer != null && localPlayer.isInCombat();
        return fightArea.contains(localPlayer) && !isInCombat;
    }

}



