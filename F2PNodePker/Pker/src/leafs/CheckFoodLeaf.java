package leafs;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

import static org.dreambot.api.utilities.Logger.log;

public class CheckFoodLeaf extends Leaf {
    private final String foodName;

    public CheckFoodLeaf(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public boolean isValid() {
        return Inventory.count(foodName) <= 4;
    }

    @Override
    public int onLoop() {
        log("Food is 4 or less. Need to go to safe area.");
        return 50;
    }
}


