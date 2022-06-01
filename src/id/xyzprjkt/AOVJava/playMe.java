package id.xyzprjkt.AOVJava;

import id.xyzprjkt.AOVJava.Heroes.*;
public class playMe {
    public static void main(String[] args) {

        System.out.println("\nWelcome to, Arena Of Valor\nJava Edition");

        int round = 0;

        // Player 1 Instance Variable
        Murad murad = new Murad();

        // Player 2 Instance Variable
        Thane thane = new Thane();

        // Hero Murad
        murad.initHero();
        murad.upLevel(1);
        murad.checkStatus("Murad");

        // Hero Thane
        thane.initHero();
        thane.upLevel(1);
        thane.checkStatus("Thane");

        // Attack Begins
        do {
            round++;
            System.out.printf("\n=========== Round  %d ===========", round);

            murad.attack("Murad", "Thane",
                    murad.getAttackDamage(), thane.getDefense(),
                    thane.getHealthPoint());
            thane.setHealthPoint(murad.damageKontol);

            if (thane.getHealthPoint() < 0) {
                thane.setLifeStatus(false);
            }

            thane.attack("Thane", "Murad",
                    thane.getAttackDamage(), murad.getDefense(),
                    murad.getHealthPoint());
            murad.setHealthPoint(thane.damageKontol);


            if (murad.getHealthPoint() < 0){
                murad.setLifeStatus(false);
            }
        } while ( murad.isLifeStatus() == true && thane.isLifeStatus() == true );

        System.out.println("\n========= Match Result =========");
        if (murad.isLifeStatus() == false && thane.isLifeStatus() == true){
            System.out.println("Thane Win the Game");
        } else if (thane.isLifeStatus() == false && murad.isLifeStatus() == true ) {
            System.out.println("Murad Win the Game");
        }

    }
}
