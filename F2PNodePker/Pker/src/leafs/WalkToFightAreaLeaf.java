package leafs;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class WalkToFightAreaLeaf extends Leaf {
    private Area fightArea;

    public WalkToFightAreaLeaf(Area fightArea) {
        this.fightArea = fightArea;
    }

    @Override
    public boolean isValid() {
        // This leaf should be executed if the local player is not in the fight area and not moving
        return !fightArea.contains(Players.getLocal()) && !Players.getLocal().isMoving();
    }

    @Override
    public int onLoop() {
        // Walk back to the fight area
        Walking.walk(fightArea.getRandomTile());
        log("Not in fight area. Walking back...");
        return Calculations.random(600, 800);
    }
}

