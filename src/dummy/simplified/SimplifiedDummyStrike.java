package dummy.simplified;

import ability.simplified.SimplifiedAttack;
import die.simplified.SimplifiedDie;

public class SimplifiedDummyStrike extends SimplifiedAttack{
    private SimplifiedDie attackDie;
    public SimplifiedDummyStrike() {
        super.name = "SimplifiedDummyStrike";
        super.description = "Choose a target. Roll a d10 and deal damage to the chosen target equal to the result.";
        super.advantage = 0;
        super.disadvantage = 0;
        this.attackDie = new SimplifiedDie(10);
    }

    @Override
    public String useAbility() {
        int totalAdv = this.advantage + this.user.getAdvantage();
        int totalDis = this.disadvantage + this.user.getDisadvantage();
        int attackDamage = this.attackDie.rollWithModifications(totalAdv, totalDis);
        this.target.takeXDamage(attackDamage);
        return("*" + this.user.getName() + " used " + this.name + " on " +
                this.target.getName() + " dealing " + attackDamage + " damage!*");
    }
}
