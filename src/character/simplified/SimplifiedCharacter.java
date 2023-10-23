package character.simplified;

import java.util.ArrayList;

public abstract class SimplifiedCharacter {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;

    protected int armor;

    protected int advantage;

    protected int disadvantage;

    protected int speed;

    protected ArrayList<SimplifiedCharacter> enemies;

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getArmor() {
        return this.armor;
    }

    public int getAdvantage() { return this.advantage;}

    public int getDisadvantage() { return this.disadvantage;}

    public String getName() { return this.name; }

    public int getSpeed() {return this.speed;}

    public void healXHealth(int x) {
        if(this.currentHealth + x < maxHealth) {
            this.currentHealth = (this.currentHealth + x);
        } else {
            this.currentHealth = this.maxHealth;
        }
    }

    public void takeXDamage(int x) {
        if(this.armor >=  x) {
            this.armor -= x;
        } else {
            int dif = x - this.armor;
            this.armor = 0;
            this.currentHealth -= dif;
        }
    }

    public void setArmor(int x) {
        this.armor = x;
    }

    public void setAdvantage(int x) {
        this.advantage = x;
    }

    public void setDisadvantage(int x) {
        this.disadvantage = x;
    }

    public void setEnemies(ArrayList<SimplifiedCharacter> enemies) {
        this.enemies = enemies;
    }

    public void setSpeed(int x) {
        this.speed = x;
    }

    public boolean isDead() {
        return (this.currentHealth <= 0);
    }

    public abstract void takeTurn(boolean report);
}
