package fight.simplified;

import character.simplified.SimplifiedCharacter;
import javafx.util.Pair;

public class SimplifiedArena {
    private SimplifiedArmy army1;
    private SimplifiedArmy army2;
    private SimplifiedTurnOrder turnOrder;

    public SimplifiedArena(SimplifiedArmy a1, SimplifiedArmy a2) {
        this.army1 = a1;
        this.army2 = a2;
        this.turnOrder = new SimplifiedTurnOrder(this.army1, this.army2);
        this.setEnemies();
    }

    public void runFightTest() throws InterruptedException {
        printCharacterStatuses();
        while (!isFightOver()) {
            this.turnOrder.getNextCharacter();
            SimplifiedCharacter activeChar = this.turnOrder.getActiveCharacter();
            if (!activeChar.isDead()) {
                activeChar.takeTurn(true);
                System.out.println();
                printCharacterStatuses();
                Thread.sleep(1500);
            }
        }
        if ((this.army1.isDead()) && (this.army2.isDead())) {
            System.out.println(this.army1.getName() + " and " + this.army2.getName() + "tied the fight!");
        } else if (this.army2.isDead()) {
            System.out.println(this.army1.getName() + " won the fight!");
        } else if (this.army1.isDead()) {
            System.out.println(this.army2.getName() + " won the fight!");
        } else {
            System.out.println("The fight is over, but there is no winner... somehow.");
        }
    }


    boolean isFightOver() {
        return (this.army1.isDead() || this.army2.isDead());
    }

    void setEnemies() {
        for (int lcv1 = 0; lcv1 < this.army1.size(); lcv1++) {
            SimplifiedCharacter currChar = this.army1.get(lcv1);
            currChar.setEnemies(this.army2.getCharacters());
        }
        for (int lcv2 = 0; lcv2 < this.army2.size(); lcv2++) {
            SimplifiedCharacter currChar = this.army2.get(lcv2);
            currChar.setEnemies(this.army1.getCharacters());
        }
    }

    private void printCharacterStatuses() {
        StringBuilder sb = new StringBuilder();
        for(int lcv1 = 0; lcv1 < this.army1.size(); lcv1++) {
            SimplifiedCharacter curChar1 = this.army1.get(lcv1);
            sb.append(curChar1.getName() + "'s health: " + curChar1.getCurrentHealth() + " "
            + curChar1.getName() + "'s Armor: " + curChar1.getArmor() + " "
            + curChar1.getName() + "'s Advantage: " + curChar1.getAdvantage() + '\n');
        }
        for(int lcv2 = 0; lcv2 < this.army2.size(); lcv2++) {
            SimplifiedCharacter curChar2 = this.army2.get(lcv2);
            sb.append(curChar2.getName() + "'s health: " + curChar2.getCurrentHealth() + " "
            + curChar2.getName() + "'s Armor: " + curChar2.getArmor() +  " "
            + curChar2.getName() + "'s Advantage: " + curChar2.getAdvantage() + '\n');
        }
        System.out.println(sb.toString());
    }
}