package ability.simplified;

import character.simplified.SimplifiedCharacter;

public abstract class SimplifiedAbility {
    protected String name;
    protected SimplifiedCharacter user;
    protected SimplifiedCharacter target;

    protected String description;

    protected int advantage;

    protected int disadvantage;

    public String getName() {
        return this.name;
    }

    public SimplifiedCharacter getTarget() {
        return this.target;
    }

    public String getDescription() {
        return this.description;
    }

    public int getAdvantage() {
        return this.advantage;
    }

    public int getDisadvantage() {
        return this.disadvantage;
    }

    public void setTarget(SimplifiedCharacter c) {
        this.target = c;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setAdvantage(int adv) {
        this.advantage = adv;
    }

    public void setDisadvantage(int dis) {
        this.disadvantage = dis;
    }

    public void setUser (SimplifiedCharacter ch) {this.user = ch;}

    public abstract String useAbility(int adv, int dis);
}
