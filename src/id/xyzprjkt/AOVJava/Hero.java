/*
 * Copyright (C) 2022 xyzuan ( Jody Yuantoro )
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.xyzprjkt.AOVJava;

public abstract class Hero {

    private double healthPoint, attackDamage, realDamage, damageTaken, defense;
    private int level = 1;
    private boolean lifeStatus = true;


    public void attack (String p1_name, Hero attacker, String p2_name, Hero target){
        // Main Attack Function
        System.out.printf("\n=== %s Turn ===\n", p1_name); spawnIntro();
        reviewDamage(attacker.getAttackDamage(), target.getDefense());
        setDamageTaken(target.getHealthPoint() - attacker.getRealDamage());

        // Avoid Killed Hero to have Negative Health Point
        if (attacker.getDamageTaken() <= 0){
            attacker.setDamageTaken(0);
        }

        // Damage & HP Information
        System.out.printf("%s Real Damage\t: %.1f ATK\n", p1_name, attacker.getRealDamage());
        System.out.printf("%s HP Remaining\t: %.1f HP\n", p2_name, attacker.getDamageTaken());
    }

    public abstract void summonHero(int upLevel);
    public void reviewDamage(double attackDamage, double defense){
        setRealDamage(attackDamage - defense);
    }

    public void checkStatus(String hero){
        System.out.println("\n=== " + hero + " ===");
        System.out.printf("Level : %d\n", getLevel());
        System.out.printf("Attack damage\t\t : %.1f\t\t Life status : %b\nHealth point\t\t : %.1f\t\t Defense : %.1f\n",
                           getAttackDamage(), isLifeStatus(), getHealthPoint(), getDefense());
    }
    public abstract void spawnIntro();

    // Setter Getter
    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(boolean lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public double getRealDamage() {
        return realDamage;
    }

    public void setRealDamage(double realDamage) {
        this.realDamage = realDamage;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(double damageTaken) {
        this.damageTaken = damageTaken;
    }
}
