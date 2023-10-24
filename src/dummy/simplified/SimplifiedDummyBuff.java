package dummy.simplified;

import ability.simplified.SimplifiedSpell;
import die.simplified.SimplifiedDie;

public class SimplifiedDummyBuff extends SimplifiedSpell {

    public SimplifiedDummyBuff() {
        super.name = "SimplifiedDummyBuff";
        super.description = "Apply One Stack of Advantage to a Character.";
        this.advantage = 0;
        this.disadvantage = 0;
    }

    @Override
    public String useAbility() {
        this.target.setAdvantage(this.target.getAdvantage() + 1);
        return ("*" + this.user.getName() + " used " + this.name + " giving it one advantage!*");
    }
}
