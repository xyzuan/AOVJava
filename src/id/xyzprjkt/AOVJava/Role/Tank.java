package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

public abstract class Tank extends Hero {

    // Declaring Hero Specifications and Ability
    public double healthPoint = 2500, defense = 200, attackDamage = 700;
    public final double upHealthPoint = 200, upDefense = 15, upAttackDamage = 20;

    // Recent Status
    public double HP;

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
    }
}
