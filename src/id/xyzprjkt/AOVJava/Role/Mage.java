package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

interface MagicalDamage {
    double bonusDamage = 0.8;
}

public abstract class Mage extends Hero implements MagicalDamage {

    // Declaring Hero Specifications and Ability
    public double healthPoint = 2500, defense = 200, attackDamage = 700;
    public final double upHealthPoint = 85, upDefense = 10, upAttackDamage = 35;

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
