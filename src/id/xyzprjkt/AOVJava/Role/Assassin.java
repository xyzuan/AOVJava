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

interface CriticalDamage {
    double bonusDamage = 0.4;
}

public abstract class Assassin extends Hero implements CriticalDamage {

    // Declaring Hero Specifications and Ability
    public double healthPoint = 3000, defense = 300, attackDamage = ( 800 * bonusDamage );

    @Override
    public void summonHero(int upLevel){

        // Set Basic Hero Specifications
        setHealthPoint(healthPoint);
        setDefense(defense);
        setAttackDamage(attackDamage);

        // Leveling Up Hero Specifications
        final double upHealthPoint = 90, upDefense = 15, upAttackDamage = 30;
        for (int tempLevel = 1; tempLevel < upLevel; tempLevel++) {
            setHealthPoint(getHealthPoint() + upHealthPoint);
            setDefense(getDefense() + upDefense);
            setAttackDamage(getAttackDamage() + upAttackDamage);
        } setLevel(upLevel);

    }
}
