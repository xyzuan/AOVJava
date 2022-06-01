package id.xyzprjkt.AOVJava;

import id.xyzprjkt.AOVJava.Heroes.*;

import java.util.Scanner;

public class playMe {

    /*  This Enums are possible case where PvP
        are happens
    */
    enum pvpCase {
        MURADVSTHANE, // or THANEVSMURAD
        MURADVSMGANGA, // or MGANGAVSMURAD
        THANEVSMGANGA, // or MGANGAVSTHANE
    }
    static int p1_hero, p2_hero;
    static int p1_hero_lvl, p2_hero_lvl;

    public static void pickHero(){

        Scanner input = new Scanner(System.in);

        System.out.println("Pilih Hero \n1. Murad\n2. Thane\n3. Mganga");
        System.out.print("Player - 1 : ");
        p1_hero = input.nextInt();
        System.out.print("Player - 1 Hero Level : ");
        p1_hero_lvl = input.nextInt();
        System.out.print("Player - 2 : ");
        p2_hero = input.nextInt();
        System.out.print("Player - 2 Hero Level : ");
        p2_hero_lvl = input.nextInt();

    }

    public static void gameEngine() {

        // Object Instance Variable
        Murad murad = new Murad();
        Thane thane = new Thane();
        Mganga mganga = new Mganga();

        // Enum PvP Possbile Case Variable
        pvpCase pvp = null;

        // General Instance Variable
        int round = 0;

        // Main Game Engine
        System.out.println("\n=========== Battle Start ===========");
        if (p1_hero == 1 && p2_hero == 2 ||
            p1_hero == 2 && p2_hero == 1 ) {

            pvp = pvpCase.MURADVSTHANE;

            // Initialization Murad Basic Status
            murad.initHero(); murad.upLevel(p1_hero_lvl);
            murad.checkStatus("Murad");

            // Initialization Thane Basic Status
            thane.initHero(); thane.upLevel(p2_hero_lvl);
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
                    thane.setHealthPoint(murad.finalHealth);

                    if (thane.getHealthPoint() <= 0) {
                        thane.setLifeStatus(false);
                    }
                }

                // Thane Attack
                if (thane.isLifeStatus()) {
                    thane.attack("Thane", "Murad",
                            thane.getAttackDamage(), murad.getDefense(),
                            murad.getHealthPoint());
                    murad.setHealthPoint(thane.finalHealth);

                    if (murad.getHealthPoint() <= 0) {
                        murad.setLifeStatus(false);
                    }
                }

            } while (murad.isLifeStatus() && thane.isLifeStatus());
        } else if (p1_hero == 1 && p2_hero == 3 ||
                   p1_hero == 3 && p2_hero == 1 ) {

            pvp = pvpCase.MURADVSMGANGA;

            // Initialization Murad Basic Status
            murad.initHero(); murad.upLevel(p1_hero_lvl);
            murad.checkStatus("Murad");

            // Initialization Mganga Basic Status
            mganga.initHero(); mganga.upLevel(p2_hero_lvl);
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
                    mganga.setHealthPoint(murad.finalHealth);

                    if (mganga.getHealthPoint() <= 0) {
                        mganga.setLifeStatus(false);
                    }
                }

                // Mganga Attack
                if (mganga.isLifeStatus()) {
                    mganga.attack("Mganga", "Murad",
                            mganga.getAttackDamage(), murad.getDefense(),
                            murad.getHealthPoint());
                    murad.setHealthPoint(mganga.finalHealth);

                    if (murad.getHealthPoint() <= 0) {
                        murad.setLifeStatus(false);
                    }
                }
            } while (murad.isLifeStatus() && mganga.isLifeStatus());
        } else if (p1_hero == 2 && p2_hero == 3 ||
                   p1_hero == 3 && p2_hero == 2 ) {

            pvp = pvpCase.THANEVSMGANGA;

            // Initialization Thane Basic Status
            thane.initHero(); thane.upLevel(p1_hero_lvl);
            thane.checkStatus("Thane");

            // Initialization Mganga Basic Status
            mganga.initHero();
            mganga.upLevel(p2_hero_lvl);
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
                    mganga.setHealthPoint(thane.finalHealth);

                    if (mganga.getHealthPoint() <= 0) {
                        mganga.setLifeStatus(false);
                    }
                }

                // Mganga Attack
                if (mganga.isLifeStatus()) {
                    mganga.attack("Mganga", "thane",
                            mganga.getAttackDamage(), thane.getDefense(),
                            thane.getHealthPoint());
                    thane.setHealthPoint(mganga.finalHealth);

                    if (thane.getHealthPoint() <= 0) {
                        thane.setLifeStatus(false);
                    }
                }
            } while (thane.isLifeStatus() && mganga.isLifeStatus());
        }

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
        System.out.println("\nWelcome to, Arena Of Valor\nJava Edition");
        pickHero(); gameEngine();
    }
}
