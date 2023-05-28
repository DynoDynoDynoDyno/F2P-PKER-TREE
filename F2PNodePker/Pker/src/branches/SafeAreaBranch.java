package branches;

import leafs.CheckFoodLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.frameworks.treebranch.Branch;

public class SafeAreaBranch extends Branch {
    private CheckFoodLeaf checkFoodLeaf;
    private Area safeArea;

    public SafeAreaBranch(Area safeArea, CheckFoodLeaf checkFoodLeaf) {
        this.safeArea = safeArea;
        this.checkFoodLeaf = checkFoodLeaf;

        // Add leaves to the branch
        this.addLeaves(checkFoodLeaf);
    }

    @Override
    public boolean isValid() {
        // This branch should be executed if the local player is not in the safe area,
        // the local player is not moving, and the checkFoodLeaf is valid (meaning the bot has 4 or less food)
        return !safeArea.contains(Players.getLocal()) && !Players.getLocal().isMoving() && checkFoodLeaf.isValid();
    }
}


