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

import java.util.Scanner;

/*  AOV Heroes
    ( Murad, Thane, Mganga )
*/
import id.xyzprjkt.AOVJava.Heroes.*;

public class playMe {

    /*  This Enums are possible case where PvP
        are happens
    */
    private enum pvpCase {
        MURADVSTHANE, // or THANEVSMURAD
        MURADVSMGANGA, // or MGANGAVSMURAD
        THANEVSMGANGA, // or MGANGAVSTHANE
    }
    private static int h1_hero, h2_hero;
    private static int h1_hero_lvl, h2_hero_lvl;

    // Enum PvP Possible Case Variable
    private static pvpCase pvp;

    // Object Instance Variable
    private final static Murad murad = new Murad();
    private final static Thane thane = new Thane();
    private final static Mganga mganga = new Mganga();

    private static void pickHero(){

        Scanner input = new Scanner(System.in);

        System.out.println("""
                 Pick a Hero\s
                 1. Murad
                 2. Thane
                 3. Mganga
                ========================================""");

        // Initialization Hero 1
        System.out.print("Hero 1 : "); h1_hero = input.nextInt();
        System.out.print("Hero 1 Level : "); h1_hero_lvl = input.nextInt();

        // Initialization Hero 2
        System.out.print("Hero 2 : "); h2_hero = input.nextInt();
        System.out.print("Hero 2 Level : "); h2_hero_lvl = input.nextInt();

        input.close();

    }

    private static void initGameEngine() {

        // General gameEngine Variable
        int round = 0;

        // Main Game Engine
        System.out.println("\n=========== Battle Start ===========");
        if (h1_hero == 1 && h2_hero == 2 ||
            h1_hero == 2 && h2_hero == 1 ) {

            pvp = pvpCase.MURADVSTHANE;

            // Initialization Murad Basic Status
            murad.summonHero(h1_hero_lvl);
            murad.checkStatus("Murad");

            // Initialization Thane Basic Status
            thane.summonHero(h2_hero_lvl);
            thane.checkStatus("Thane");

            // PvP Drivers
            do {
                round++;
                System.out.printf("\n=========== Round  %d ===========", round);

                // Murad Attack
                if (murad.isLifeStatus()) {
                    murad.attack("Murad", "Thane",
                            murad.getAttackDamage(), thane.getDefense(),
                            thane.getHealthPoint());
                    thane.setHealthPoint(murad.getDamageTaken());

                    if (thane.getHealthPoint() <= 0) {
                        thane.setLifeStatus(false);
                    }
                }

                // Thane Attack
                if (thane.isLifeStatus()) {
                    thane.attack("Thane", "Murad",
                            thane.getAttackDamage(), murad.getDefense(),
                            murad.getHealthPoint());
                    murad.setHealthPoint(thane.getDamageTaken());

                    if (murad.getHealthPoint() <= 0) {
                        murad.setLifeStatus(false);
                    }
                }

            } while (murad.isLifeStatus() && thane.isLifeStatus());
            matchResult();
        } else if (h1_hero == 1 && h2_hero == 3 ||
                   h1_hero == 3 && h2_hero == 1 ) {

            pvp = pvpCase.MURADVSMGANGA;

            // Initialization Murad Basic Status
            murad.summonHero(h1_hero_lvl);
            murad.checkStatus("Murad");

            // Initialization Mganga Basic Status
            mganga.summonHero(h2_hero_lvl);
            mganga.checkStatus("Mganga");

            // PvP Drivers
            do {
                round++;
                System.out.printf("\n=========== Round  %d ===========", round);

                // Murad Attack
                if (murad.isLifeStatus()) {
                    murad.attack("Murad", "Mganga",
                            murad.getAttackDamage(), thane.getDefense(),
                            mganga.getHealthPoint());
                    mganga.setHealthPoint(murad.getDamageTaken());

                    if (mganga.getHealthPoint() <= 0) {
                        mganga.setLifeStatus(false);
                    }
                }

                // Mganga Attack
                if (mganga.isLifeStatus()) {
                    mganga.attack("Mganga", "Murad",
                            mganga.getAttackDamage(), murad.getDefense(),
                            murad.getHealthPoint());
                    murad.setHealthPoint(mganga.getDamageTaken());

                    if (murad.getHealthPoint() <= 0) {
                        murad.setLifeStatus(false);
                    }
                }
            } while (murad.isLifeStatus() && mganga.isLifeStatus());
            matchResult();
        } else if (h1_hero == 2 && h2_hero == 3 ||
                   h1_hero == 3 && h2_hero == 2 ) {

            pvp = pvpCase.THANEVSMGANGA;

            // Initialization Thane Basic Status
            thane.summonHero(h1_hero_lvl);
            thane.checkStatus("Thane");

            // Initialization Mganga Basic Status
            mganga.summonHero(h2_hero_lvl);
            mganga.checkStatus("Mganga");

            // PvP Drivers
            do {
                round++;
                System.out.printf("\n=========== Round  %d ===========", round);

                // Thane Attack
                if (thane.isLifeStatus()) {
                    thane.attack("thane", "Mganga",
                            thane.getAttackDamage(), thane.getDefense(),
                            mganga.getHealthPoint());
                    mganga.setHealthPoint(thane.getDamageTaken());

                    if (mganga.getHealthPoint() <= 0) {
                        mganga.setLifeStatus(false);
                    }
                }

                // Mganga Attack
                if (mganga.isLifeStatus()) {
                    mganga.attack("Mganga", "thane",
                            mganga.getAttackDamage(), thane.getDefense(),
                            thane.getHealthPoint());
                    thane.setHealthPoint(mganga.getDamageTaken());

                    if (thane.getHealthPoint() <= 0) {
                        thane.setLifeStatus(false);
                    }
                }
            } while (thane.isLifeStatus() && mganga.isLifeStatus());
            matchResult();
        } else if (h1_hero == h2_hero) {
            System.out.println("[id.xyzprjkt.AOVJava] You can't pick same hero in Hero 1 or 2");
        } else if (h1_hero > 3){
            System.out.println("[id.xyzprjkt.AOVJava] Hero 1 are not listed");
        } else if (h2_hero > 3) {
            System.out.println("[id.xyzprjkt.AOVJava] Hero 2 are not listed");
        }
    }

    public static void matchResult() {
        // Match Result
        System.out.println("\n========= Match Result =========");
        if (pvp == pvpCase.MURADVSTHANE) {
            if (!thane.isLifeStatus() && murad.isLifeStatus()) {
                System.out.println("Thane died in the Game\nMurad Win the Game");
            } else {
                System.out.println("Murad died in the Game\nThane Win the Game");
            }
        } else if (pvp == pvpCase.MURADVSMGANGA) {
            if (!murad.isLifeStatus() && mganga.isLifeStatus()) {
                System.out.println("Murad died in the Game\nMganga Win the Game");
            } else {
                System.out.println("Mganga died in the Game\nMurad Win the Game");
            }
        } else if (pvp == pvpCase.THANEVSMGANGA) {
            if (!thane.isLifeStatus() && mganga.isLifeStatus()) {
                System.out.println("Thane died in the Game\nMganga Win the Game");
            } else {
                System.out.println("Mganga died in the Game\nThane Win the Game");
            }
        }
        System.out.println("================================");
    }

    public static void main(String[] args) {
        System.out.println("""
                ========================================          \s
                 Welcome to, Arena Of Valor
                 Java Edition
                 Made by xyzuan
                ========================================""");
        pickHero();
        if (h1_hero_lvl > 15 || h2_hero_lvl > 15){
            System.out.println("[id.xyzprjkt.AOVJava] You can't set hero level up to 15 LVL");
        } else {
            initGameEngine();
        }
    }
}
