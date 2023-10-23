package fight.simplified;

import character.simplified.SimplifiedCharacter;

import java.util.ArrayList;

public class SimplifiedArmy {
    ArrayList<SimplifiedCharacter> myArmy;
    private String name;
    public SimplifiedArmy() {
        this.myArmy = new ArrayList<SimplifiedCharacter>();
        this.name = "";
    }

    public SimplifiedArmy(ArrayList<SimplifiedCharacter> chars) {
        this.myArmy = chars;
        chooseName();
    }

    public void addCharacter(SimplifiedCharacter ch) {
        this.myArmy.add(ch);
        chooseName();
    }

    private void chooseName() {
        if(this.myArmy.size() == 1) {
            this.name = this.myArmy.get(0).getName();
        } else if(this.myArmy.size() > 1) {
            this.name = (this.myArmy.get(0).getName() + "'s Army");
        } else {
            this.name = "";
        }
    }

    public String getName() {
        chooseName();
        return this.name;
    }

    public ArrayList<SimplifiedCharacter> getCharacters() {
        return this.myArmy;
    }

    public int size() {
        return this.myArmy.size();
    }

    public SimplifiedCharacter get(int index) {
        return this.myArmy.get(index);
    }

    public boolean isDead() {
        for(int lcv = 0; lcv < size(); lcv++) {
            if(!this.get(lcv).isDead()) {
                return false;
            }
        }
        return true;
    }
}
