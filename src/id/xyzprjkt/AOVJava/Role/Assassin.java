package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

interface CriticalDamage {
    double bonusDamage = 0.4;
}

public abstract class Assassin extends Hero implements CriticalDamage {

    // Declaring Hero Specifications and Ability
    double healthPoint = 3000, defense = 300, attackDamage = 800;
    double upHealthPoint = 90, upDefense = 15, upAttackDamage = 30;

    // Special Assassin Specifications
    public void critDmg() {
        attackDamage += attackDamage * bonusDamage;
    }

    // Basic Assasin Specifications
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
