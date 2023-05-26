import branches.FightAreaBranch;
import branches.FightingBranch;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.frameworks.treebranch.TreeScript;
import org.dreambot.api.wrappers.interactive.Player;

@ScriptManifest(name = "F2P Mage Pker Tree", description = "My first pk bot. TreeScript", author = "Dyno",
        version = 0.1, category = Category.COMBAT, image = "")
public class Main extends TreeScript {
    private FightingBranch fightingBranch;
    private FightAreaBranch fightAreaBranch;

    @Override
    public void onStart() {
        // Initialize your variables

        Player targetPlayer = Players.closest(p -> p != null && !p.equals(Players.getLocal()));
        String foodName = "Trout";
        Area fightArea = new Area(3074, 3546, 3097, 3525);

        fightingBranch = new FightingBranch(targetPlayer, foodName);
        fightAreaBranch = new FightAreaBranch(fightArea);
        addBranches(fightingBranch, fightAreaBranch);
    }


    // ...
}


