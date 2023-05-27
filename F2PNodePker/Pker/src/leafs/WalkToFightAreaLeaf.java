package leafs;


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
        return true;
    }

    @Override
    public int onLoop() {
        // Walk back to the fight area
        Walking.walk(fightArea.getRandomTile());
        log("Not in fight area. Walking back...");
        return 50;
    }
}

