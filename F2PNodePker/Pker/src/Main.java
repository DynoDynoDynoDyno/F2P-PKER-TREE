import branches.FightAreaBranch;
import branches.FightingBranch;
import branches.RoamingBranch;
import leafs.EatFoodLeaf;
import leafs.FindTargetLeaf;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.frameworks.treebranch.TreeScript;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.methods.combat.Combat;


import java.awt.*;

@ScriptManifest(name = "F2P Mage Pker Tree", description = "My first pk bot. TreeScript", author = "Dyno",
        version = 0.1, category = Category.COMBAT, image = "")
public class Main extends TreeScript {
    private FightingBranch fightingBranch;
    private FightAreaBranch fightAreaBranch;
    private RoamingBranch roamingBranch;
    private EatFoodLeaf eatFoodLeaf;
    private FindTargetLeaf findTargetLeaf;  // Make this a class level variable

    @Override
    public void onStart() {
        // Initialize your variables

        String foodName = "Trout";
        Area fightArea = new Area(3087, 3735, 3074, 3723);

        findTargetLeaf = new FindTargetLeaf();
        eatFoodLeaf = new EatFoodLeaf(foodName);

        fightingBranch = new FightingBranch(foodName, fightArea, findTargetLeaf);
        fightAreaBranch = new FightAreaBranch(fightArea);
        roamingBranch = new RoamingBranch(fightArea, findTargetLeaf);

        addBranches(fightingBranch, fightAreaBranch, roamingBranch);
    }

    @Override
    public void onPaint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));

        int y = 40;  // Start y coordinate for text
        int dy = 15; // Amount to increment y coordinate for each line of text
        int x = 10;  // x coordinate for text

        g.drawString("Current HP: " + eatFoodLeaf.getCurrentHPPercent() + "%", x, y);
        y += dy;
        Player targetPlayer = findTargetLeaf.getTargetPlayer();
        g.drawString("Target Player: " + (targetPlayer != null ? targetPlayer.getName() : "None"), x, y);
        y += dy;
        g.drawString("Local Player Combat Level: " + findTargetLeaf.getLocalPlayerCombatLevel(), x, y);
        y += dy;
        g.drawString("Wilderness Level: " + findTargetLeaf.getWildernessLevel(), x, y);
        y += dy;
        g.drawString("In Combat: " + (findTargetLeaf.isLocalPlayerInCombat() ? "Yes" : "No"), x, y);
    }
}



    // ...


