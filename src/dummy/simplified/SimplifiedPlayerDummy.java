package dummy.simplified;

import ability.simplified.SimplifiedAbility;
import character.simplified.SimplifiedCharacter;

import java.util.Scanner;

public class SimplifiedPlayerDummy extends SimplifiedCharacter {
    SimplifiedAbility [] abilities;
    SimplifiedAbility currentAbility;

    Scanner scan;
    public SimplifiedPlayerDummy() {
        super.name = "SimplifiedPlayerDummy";
        super.maxHealth = 50;
        super.currentHealth = 50;
        super.armor = 0;
        super.advantage = 0;
        super.disadvantage = 0;
        super.speed = 1;
        this.abilities = createDummyAbilities();
        scan = new Scanner(System.in);
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
        System.out.println("Choose Attack: 1: Strike, 2: Block, 3: Buff");
        int choice = scan.nextInt();
        this.currentAbility = this.abilities[choice - 1];
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
            String rep = this.currentAbility.useAbility();
            if(report) {
                System.out.println(rep);
            }
        }
    }

    public void setName(String name) {
        super.name = name;
    }
}
