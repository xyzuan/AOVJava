package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

public abstract class Tank extends Hero {

    // Declaring Hero Specifications and Ability
    double healthPoint = 2500, defense = 200, attackDamage = 700;
    double upHealthPoint = 200, upDefense = 15, upAttackDamage = 20;

    @Override
    public void setHealthPoint(double healthPoint) {
        healthPoint = this.healthPoint;
        super.setHealthPoint(healthPoint);
    }

    @Override
    public void setDefense(double defense) {
        defense = this.defense;
        super.setDefense(defense);
    }

    @Override
    public void setAttackDamage(double attackDamage) {
        attackDamage = this.attackDamage;
        super.setAttackDamage(attackDamage);
    }
}
