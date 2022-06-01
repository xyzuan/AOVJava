package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

interface CriticalDamage {
    double bonusDamage = 0.4;
}

public abstract class Assassin extends Hero implements CriticalDamage {

    // Declaring Hero Specifications and Ability
    public double healthPoint = 3000, defense = 300, attackDamage = 800;
    public final double upHealthPoint = 90, upDefense = 15, upAttackDamage = 30;

    @Override
    public void initHero(){
        setHealthPoint(healthPoint);
        setDefense(defense);
        setAttackDamage(attackDamage);
    }

    @Override
    public void upLevel(int level){
        setLevel(level);
        for (int tempLevel = 1; tempLevel < level; tempLevel++) {
            setAttackDamage(getAttackDamage() + upAttackDamage);
            setDefense(getDefense() + upDefense);
            setHealthPoint(getHealthPoint() + upHealthPoint);
        }
        this.attackDamage = getAttackDamage();
        this.defense = getDefense();
        this.healthPoint = getHealthPoint();
    }
}
