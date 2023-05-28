package branches;

import leafs.EatFoodLeaf;
import leafs.FindTargetLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.wrappers.interactive.Player;

public class FightingBranch extends Branch {
    private Area fightArea;
    private EatFoodLeaf eatFoodLeaf;
    private FindTargetLeaf findTargetLeaf;

    private String foodName;

    public FightingBranch(String foodName, Area fightArea, FindTargetLeaf findTargetLeaf) {
        this.foodName = foodName;
        this.fightArea = fightArea;
        this.findTargetLeaf = findTargetLeaf;
        this.eatFoodLeaf = new EatFoodLeaf(this.foodName);
        this.addLeaves(eatFoodLeaf);
    }

    @Override
    public boolean isValid() {
        Player localPlayer = Players.getLocal();
        return localPlayer != null && localPlayer.isInCombat() && fightArea.contains(localPlayer);
    }
}










