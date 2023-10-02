package map.simplified;

import java.util.HashMap;
import java.util.Set;

public class SimplifiedMapPathRequirements {

    private HashMap<Character, SimplifiedMapPathRequirementPair> myReqs;

    public SimplifiedMapPathRequirements() throws IllegalMapRequirementPairException {
        myReqs = new HashMap<>();
        this.initializeDefaultReqs();
    }

    private void initializeDefaultReqs() throws IllegalMapRequirementPairException {
        SimplifiedMapPathRequirementPair defaultPair = SimplifiedMapPathRequirementPair.createDefaultRequirementPair();
        this.myReqs.put('S', defaultPair);
        this.myReqs.put('T', defaultPair);
        this.myReqs.put('R', defaultPair);
        this.myReqs.put('E', defaultPair);
        this.myReqs.put('M', defaultPair);
        this.myReqs.put('B', defaultPair);
    }

    public void setRequirementBySymbol(char sym, int min, int max) throws IllegalMapRequirementPairException {
        SimplifiedMapPathRequirementPair newPair = new SimplifiedMapPathRequirementPair(min, max);
        this.myReqs.put(sym, newPair);
    }

    public SimplifiedMapPathRequirementPair getRequirementBySymbol(char sym) {
        return this.myReqs.getOrDefault(sym, null);
    }

    public void setShopRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('S', min, max);
    }

    public void setShopRequirement(int min) throws IllegalMapRequirementPairException {
        this.setShopRequirement(min, -1);
    }

    public void setTreasureRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('T', min, max);
    }

    public void setTreasureRequirement(int min) throws IllegalMapRequirementPairException {
        this.setTreasureRequirement(min, -1);
    }

    public void setRestRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('R', min, max);
    }

    public void setRestRequirements(int min) throws IllegalMapRequirementPairException {
        this.setRestRequirement(min, -1);
    }

    public void setEnemyRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('E', min, max);
    }

    public void setEnemyRequirement(int min) throws IllegalMapRequirementPairException {
        this.setEnemyRequirement(min, -1);
    }

    public void setMinibossRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('M', min, max);
    }

    public void setMinibossRequirement(int min) throws IllegalMapRequirementPairException {
        this.setMinibossRequirement(min, -1);
    }

    public void setBossRequirement(int min, int max) throws IllegalMapRequirementPairException {
        this.setRequirementBySymbol('B', min, max);
    }

    public void setBossRequirement(int min) throws IllegalMapRequirementPairException {
        this.setBossRequirement(min, -1);
    }

    public SimplifiedMapPathRequirementPair getShopRequirement() {
        return this.getRequirementBySymbol('S');
    }

    public SimplifiedMapPathRequirementPair getTreasureRequirement() {
        return this.getRequirementBySymbol('T');
    }

    public SimplifiedMapPathRequirementPair getRestRequirement() {
        return this.getRequirementBySymbol('R');
    }

    public SimplifiedMapPathRequirementPair getEnemyRequirement() {
        return this.getRequirementBySymbol('E');
    }

    public SimplifiedMapPathRequirementPair getMinibossRequirement() {
        return this.getRequirementBySymbol('M');
    }

    public Set<Character> getReqKeyset() {
        return this.myReqs.keySet();
    }
}

