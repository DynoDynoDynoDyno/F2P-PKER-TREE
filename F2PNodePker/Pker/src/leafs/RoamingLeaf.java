package leafs;


import org.dreambot.api.script.frameworks.treebranch.Leaf;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.interactive.Player;

import static org.dreambot.api.methods.interactive.Players.getLocal;


public class RoamingLeaf extends Leaf {
    private final Area fightArea;
    private long lastRoamTime;

    public RoamingLeaf(Area fightArea) {
        this.fightArea = fightArea;
        this.lastRoamTime = System.currentTimeMillis();
    }

    @Override
    public boolean isValid() {
        // Check if more than 17 seconds have passed since the last roam
        return System.currentTimeMillis() - lastRoamTime >= 17 * 1000;
    }

    @Override
    public int onLoop() {
        Player localPlayer = getLocal();
        Walking.walk(fightArea.getRandomTile());

        // Update lastRoamTime
        lastRoamTime = System.currentTimeMillis();

        return 50; // Arbitrary sleep time between actions
    }
}


