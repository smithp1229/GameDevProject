package die.simplified;

import java.util.ArrayList;
import java.util.Collections;

public class SimplifiedDie {
    private int sides;

    public SimplifiedDie(int numSides) {
        this.sides = numSides;
    }

    public int roll() {
        return (int) (Math.random() * (this.sides) + 1);
    }

    public int rollWithAdvantage(int advantageStacks) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int lcv = 0; lcv <= advantageStacks; lcv++) {
            rolls.add(roll());
        }
       return Collections.max(rolls);
    }

    public int rollWithDisadvantage(int disadvantageStacks) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int lcv = 0; lcv <= disadvantageStacks; lcv++) {
            rolls.add(roll());
        }
        return Collections.min(rolls);
    }

    public int rollWithModifications(int advantageStacks, int disadvantageStacks) {
        if(advantageStacks > disadvantageStacks) {
            return rollWithAdvantage(advantageStacks - disadvantageStacks);
        } else if (advantageStacks < disadvantageStacks) {
            return rollWithDisadvantage(disadvantageStacks - advantageStacks);
        } else {
            return roll();
        }
    }
}
