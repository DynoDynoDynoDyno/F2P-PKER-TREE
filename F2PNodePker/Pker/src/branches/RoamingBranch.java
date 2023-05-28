package branches;

import leafs.FindTargetLeaf;
import leafs.AttackPlayerLeaf;  // Import AttackPlayerLeaf
import leafs.RoamingLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.wrappers.interactive.Player;

public class RoamingBranch extends Branch {
    private final Area fightArea;
    private final FindTargetLeaf findTargetLeaf;
    private final AttackPlayerLeaf attackPlayerLeaf; // Add field for AttackPlayerLeaf

    public RoamingBranch(Area fightArea, FindTargetLeaf findTargetLeaf) {
        this.fightArea = fightArea;
        this.findTargetLeaf = findTargetLeaf;
        this.attackPlayerLeaf = new AttackPlayerLeaf(this.findTargetLeaf); // Initialize AttackPlayerLeaf
        addLeaves(new RoamingLeaf(fightArea), findTargetLeaf, attackPlayerLeaf); // Add AttackPlayerLeaf to leaves
    }

    @Override
    public boolean isValid() {
        Player localPlayer = Players.getLocal();
        boolean isInCombat = localPlayer != null && localPlayer.isInCombat();
        return fightArea.contains(localPlayer) && !isInCombat;
    }
}



