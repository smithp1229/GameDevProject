package fight.simplified;

import character.simplified.SimplifiedCharacter;

import java.util.ArrayList;
import java.util.Collections;

public class SimplifiedTurnOrder {
    private SimplifiedArmy army1;
    private SimplifiedArmy army2;

    private ArrayList<SimplifiedCharacter> characterQueue;
    private SimplifiedCharacter activeCharacter;

    public SimplifiedTurnOrder(SimplifiedArmy a1, SimplifiedArmy a2) {
        this.army1 = a1;
        this.army2 = a2;
        this.characterQueue = new ArrayList<SimplifiedCharacter>();
    }

    public void recreateQueue() {
        ArrayList<SimplifiedCharacter> tempList1 = new ArrayList<SimplifiedCharacter>();
        for (int lcv1 = 0; lcv1 < this.army1.size(); lcv1++) {
            SimplifiedCharacter curChar1 = this.army1.get(lcv1);
            int curSpeed1 = curChar1.getSpeed();
            if(!curChar1.isDead()) {
                for(int lcv2 = 0; lcv2 < curSpeed1; lcv2++) {
                    tempList1.add(curChar1);
                }
            }
        }
        ArrayList<SimplifiedCharacter> tempList2 = new ArrayList<SimplifiedCharacter>();
        for (int lcv3 = 0; lcv3 < this.army2.size(); lcv3++) {
            SimplifiedCharacter curChar2 = this.army2.get(lcv3);
            int curSpeed2 = curChar2.getSpeed();
            if(!curChar2.isDead()) {
                for (int lcv4 = 0; lcv4 < curSpeed2; lcv4++) {
                    tempList2.add(curChar2);
                }
            }
        }
        Collections.shuffle(tempList1);
        Collections.shuffle(tempList2);
        this.characterQueue.addAll(tempList1);
        this.characterQueue.addAll(tempList2);
    }

    public void getNextCharacter() {
        if(isCycleOver()) {
            this.recreateQueue();
        }
        this.activeCharacter = this.characterQueue.get(0);
        this.characterQueue.remove(0);
    }

    public SimplifiedCharacter getActiveCharacter() {
        return this.activeCharacter;
    }

    boolean isCycleOver() {
        return (this.characterQueue.size() == 0);
    }
}