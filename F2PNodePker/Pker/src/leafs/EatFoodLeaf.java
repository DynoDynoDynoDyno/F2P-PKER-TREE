package leafs;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class EatFoodLeaf extends Leaf {
    private final String foodName;
    private int currentHPPercent;

    public EatFoodLeaf(String foodName) {
        this.foodName = foodName;
    }

    // Getter for currentHPPercent
    public int getCurrentHPPercent() {
        return this.currentHPPercent;
    }

    @Override
    public boolean isValid() {
        this.currentHPPercent = Combat.getHealthPercent();  // Update currentHPPercent here
        return currentHPPercent <= 50;
    }

    @Override
    public int onLoop() {
        log("HP is 50% or less. Eating " + foodName);
        Inventory.interact(foodName);
        return 50;
    }
}



