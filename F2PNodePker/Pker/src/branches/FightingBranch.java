package branches;

import leafs.FindTargetLeaf;
import leafs.AttackPlayerLeaf;
import leafs.EatFoodLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.wrappers.interactive.Player;

public class FightingBranch extends Branch {
    private Area fightArea;
    private AttackPlayerLeaf attackPlayerLeaf;
    private EatFoodLeaf eatFoodLeaf;
    private FindTargetLeaf findTargetLeaf;  // Add this line

    private String foodName; // New field to store the name of the food

    public FightingBranch(String foodName, Area fightArea, FindTargetLeaf findTargetLeaf) {  // Add findTargetLeaf to the constructor
        this.foodName = foodName;
        this.fightArea = fightArea;
        this.findTargetLeaf = findTargetLeaf;  // Initialize findTargetLeaf
        this.attackPlayerLeaf = new AttackPlayerLeaf(this.findTargetLeaf); // Use this.findTargetLeaf here
        this.eatFoodLeaf = new EatFoodLeaf(this.foodName);
        // Add leaves to the branch
        this.addLeaves(attackPlayerLeaf, eatFoodLeaf);
    }

    @Override
    public boolean isValid() {
        // Logic to determine if this branch should be executed.
        Player localPlayer = Players.getLocal();
        return localPlayer != null && localPlayer.isInCombat() && fightArea.contains(localPlayer);
    }
}









