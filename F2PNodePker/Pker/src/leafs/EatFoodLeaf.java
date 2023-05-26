package leafs;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class EatFoodLeaf extends Leaf {
    private final String foodName;

    public EatFoodLeaf(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public boolean isValid() {
        return Combat.getHealthPercent() <= 50;
    }

    @Override
    public int onLoop() {
        log("HP is 50% or less. Eating " + foodName);
        Inventory.interact(foodName);
        return Calculations.random(600, 800);
    }
}

