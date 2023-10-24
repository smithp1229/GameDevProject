package dummy.simplified;

import ability.simplified.SimplifiedSkill;
import die.simplified.SimplifiedDie;

public class SimplifiedDummyBlock extends SimplifiedSkill {
    private SimplifiedDie blockDie;
    public SimplifiedDummyBlock() {
        super.name = "SimplifiedDummyBlock";
        super.description = "Roll a d6. Apply an amount of block to yourself equal to the result";
        super.advantage = 0;
        super.disadvantage = 0;
        this.blockDie = new SimplifiedDie(6);
    }

    @Override
    public String useAbility() {
        int totalAdv = this.advantage + this.user.getAdvantage();
        int totalDis = this.disadvantage + this.user.getDisadvantage();
        int blockArmor = this.blockDie.rollWithModifications(totalAdv, totalDis);
        this.target.setArmor(this.target.getArmor() + blockArmor);
        return ("*" + this.user.getName() + " used " + this.name +
                " giving it " + blockArmor + " armor!*");
    }
}
