package TestingDriver;

import character.simplified.SimplifiedCharacter;
import dummy.simplified.SimplifiedDummy;
import fight.simplified.SimplifiedArena;
import fight.simplified.SimplifiedArmy;

import java.util.ArrayList;

public class CombatTestDriver {

    public static void main(String [] args) throws InterruptedException {
        SimplifiedArena testArena = createTestArena();
        testArena.runFightTest();
    }

    private static SimplifiedDummy[] createTestDummies() {
        SimplifiedDummy dummy1 = new SimplifiedDummy();
        dummy1.setName("dummy1");
        SimplifiedDummy dummy2 = new SimplifiedDummy();
        dummy2.setName("dummy2");
        return new SimplifiedDummy[]{dummy1, dummy2};
    }

    private static SimplifiedArmy[] createTestArmies() {
        SimplifiedDummy[] dummies = createTestDummies();
        SimplifiedArmy army1 = new SimplifiedArmy();
        SimplifiedArmy army2 = new SimplifiedArmy();
        army1.addCharacter(dummies[0]);
        army2.addCharacter(dummies[1]);
        return new SimplifiedArmy[]{army1, army2};
    }

    private static SimplifiedArena createTestArena() {
        SimplifiedArmy[] armies = createTestArmies();
        return new SimplifiedArena(armies[0], armies[1]);
    }
}
