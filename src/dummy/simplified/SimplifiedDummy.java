package dummy.simplified;

import ability.simplified.SimplifiedAbility;
import character.simplified.SimplifiedCharacter;

public class SimplifiedDummy extends SimplifiedCharacter {
    SimplifiedAbility [] abilities;
    SimplifiedAbility currentAbility;
    public SimplifiedDummy() {
        super.name = "SimplifiedDummy";
        super.maxHealth = 50;
        super.currentHealth = 50;
        super.armor = 0;
        super.advantage = 0;
        super.disadvantage = 0;
        super.speed = 1;
        this.abilities = createDummyAbilities();
    }

    private SimplifiedAbility[] createDummyAbilities() {
        SimplifiedAbility strike = new SimplifiedDummyStrike();
        SimplifiedAbility block = new SimplifiedDummyBlock();
        SimplifiedAbility buff = new SimplifiedDummyBuff();
        strike.setUser(this);
        block.setUser(this);
        buff.setUser(this);
        return new SimplifiedAbility[]{strike, block, buff};
    }

    private void chooseAbility() {
        int choice = (int) (Math.random() * (9) + 1);
        if(choice <= 5) {
            this.currentAbility = this.abilities[0];
        } else if(choice <= 9) {
            this.currentAbility = this.abilities[1];
        } else {
            this.currentAbility = this.abilities[2];
        }
    }

    private void pickAbilityTargets() {
        if(currentAbility.getName().equals("SimplifiedDummyStrike")) {
            int targetChoice = (int) (Math.random() * (this.enemies.size()));
            currentAbility.setTarget(this.enemies.get(targetChoice));
        } else {
            currentAbility.setTarget(this);
        }
    }

    @Override
    public void takeTurn(boolean report) {
        if(!this.isDead()) {
            this.chooseAbility();
            this.pickAbilityTargets();
            String rep = this.currentAbility.useAbility(this.advantage, this.disadvantage);
            if(report) {
                System.out.println(rep);
            }
        }
    }

    public void setName(String name) {
        super.name = name;
    }
}
