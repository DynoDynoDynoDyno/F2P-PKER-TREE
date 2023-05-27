package branches;

import leafs.AttackPlayerLeaf;
import leafs.EatFoodLeaf;
import leafs.FindTargetLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.wrappers.interactive.Player;

    public class FightingBranch extends Branch {
        private  Area fightArea;
        private AttackPlayerLeaf attackPlayerLeaf;
        private EatFoodLeaf eatFoodLeaf;
        private FindTargetLeaf findTargetLeaf;

        private Player targetPlayer;  // New field to store the target player
        private String foodName;  // New field to store the name of the food

        public FightingBranch(Player targetPlayer, String foodName, Area fightArea, FindTargetLeaf findTargetLeaf) {
            this.foodName = foodName;
            this.fightArea = fightArea;
            this.attackPlayerLeaf = new AttackPlayerLeaf(findTargetLeaf);  // Pass FindTargetLeaf to AttackPlayerLeaf
            this.eatFoodLeaf = new EatFoodLeaf(this.foodName);
            this.findTargetLeaf = findTargetLeaf;

            // Add leaves to the branch
            this.addLeaves(attackPlayerLeaf, eatFoodLeaf, findTargetLeaf);
        }

        @Override
        public boolean isValid() {
            // Logic to determine if this branch should be executed.
            Player localPlayer = Players.getLocal();
            return localPlayer != null && localPlayer.isInCombat() && fightArea.contains(localPlayer);
        }
    }







