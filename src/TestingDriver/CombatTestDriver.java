package TestingDriver;

import character.simplified.SimplifiedCharacter;
import dummy.simplified.SimplifiedDummy;
import dummy.simplified.SimplifiedPlayerDummy;
import fight.simplified.SimplifiedArena;
import fight.simplified.SimplifiedArmy;

import java.util.Scanner;

public class CombatTestDriver {

    public static void main(String [] args) throws InterruptedException {
        SimplifiedArena testArena;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose combat type: 1) Computer vs Computer, 2) Player vs Computer, 3) Player vs Player");
        int choice = scan.nextInt();
        switch(choice) {
            case 1:
                testArena = createTestArena();
                break;
            case 2:
                testArena = createTestArena2();
                break;
            case 3:
                testArena = createTestArena3();
                break;
            default:
                throw new IllegalArgumentException("Must input '1', '2', or '3'.");
        }
        testArena.runFightTest();
    }

    private static SimplifiedCharacter[] createTestDummies() {
        SimplifiedDummy dummy1 = new SimplifiedDummy();
        dummy1.setName("dummy1");
        SimplifiedDummy dummy2 = new SimplifiedDummy();
        dummy2.setName("dummy2");
        return new SimplifiedCharacter[]{dummy1, dummy2};
    }

    private static SimplifiedCharacter[] createDummies2() {
        SimplifiedPlayerDummy player = new SimplifiedPlayerDummy();
        player.setName("player");
        SimplifiedDummy dummy = new SimplifiedDummy();
        dummy.setName("dummy");
        return new SimplifiedCharacter[]{player, dummy};
    }

    private static SimplifiedCharacter[] createDummies3() {
        SimplifiedPlayerDummy player1 = new SimplifiedPlayerDummy();
        player1.setName("player1");
        SimplifiedPlayerDummy player2 = new SimplifiedPlayerDummy();
        player2.setName("player2");
        return new SimplifiedCharacter[]{player1, player2};
    }

    private static SimplifiedArmy[] createTestArmies() {
        SimplifiedCharacter[] dummies = createTestDummies();
        SimplifiedArmy army1 = new SimplifiedArmy();
        SimplifiedArmy army2 = new SimplifiedArmy();
        army1.addCharacter(dummies[0]);
        army2.addCharacter(dummies[1]);
        return new SimplifiedArmy[]{army1, army2};
    }

    private static SimplifiedArmy[] createTestArmies2() {
        SimplifiedCharacter[] characters = createDummies2();
        SimplifiedArmy army1 = new SimplifiedArmy();
        SimplifiedArmy army2 = new SimplifiedArmy();
        army1.addCharacter(characters[0]);
        army2.addCharacter(characters[1]);
        return new SimplifiedArmy[]{army1, army2};
    }

    private static SimplifiedArmy[] createTestArmies3() {
        SimplifiedCharacter[] characters = createDummies3();
        SimplifiedArmy army1 = new SimplifiedArmy();
        SimplifiedArmy army2 = new SimplifiedArmy();
        army1.addCharacter(characters[0]);
        army2.addCharacter(characters[1]);
        return new SimplifiedArmy[]{army1, army2};
    }

    private static SimplifiedArena createTestArena() {
        SimplifiedArmy[] armies = createTestArmies();
        return new SimplifiedArena(armies[0], armies[1]);
    }

    private static SimplifiedArena createTestArena2() {
        SimplifiedArmy[] armies = createTestArmies2();
        return new SimplifiedArena(armies[0], armies[1]);
    }

    private static SimplifiedArena createTestArena3() {
        SimplifiedArmy[] armies = createTestArmies3();
        return new SimplifiedArena(armies[0], armies[1]);
    }
}