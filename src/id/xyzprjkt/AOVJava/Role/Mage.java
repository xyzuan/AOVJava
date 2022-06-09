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

package id.xyzprjkt.AOVJava.Role;

import id.xyzprjkt.AOVJava.Hero;

interface MagicalDamage {
    double bonusDamage = 0.8;
}
public abstract class Mage extends Hero implements MagicalDamage {

    // Declaring Hero Specifications and Ability
    public double healthPoint = 2500, defense = 200, attackDamage = ( 700 * bonusDamage ) ;

    @Override
    public void summonHero(int upLevel){

        // Set Basic Hero Specifications
        setHealthPoint(healthPoint);
        setDefense(defense);
        setAttackDamage(attackDamage);

        // Leveling Up Hero Specifications
        final double upHealthPoint = 85, upDefense = 10, upAttackDamage = 35;
        for (int tempLevel = 0; tempLevel < upLevel; tempLevel++) {
            setHealthPoint(getHealthPoint() + upHealthPoint);
            setDefense(getDefense() + upDefense);
            setAttackDamage(getAttackDamage() + upAttackDamage);
        } setLevel(upLevel);

    }
}
