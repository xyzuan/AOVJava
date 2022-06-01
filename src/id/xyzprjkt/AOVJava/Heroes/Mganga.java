package id.xyzprjkt.AOVJava.Heroes;

import id.xyzprjkt.AOVJava.Role.Mage;

import java.util.Random;

public class Mganga extends Mage {
    @Override
    public void spawnIntro(){
        Random randomTaunt = new Random();
        String[] taunt = {  "Hanya itu saja kemampuanmu?",
                "Gerakan ku kilat!",
                "Anda akan mati",
                "Anda lawan yang sangat lemah",
                "I will kill you"
        };

        int rand = randomTaunt.nextInt(taunt.length);
        System.out.println("Mganga : " + taunt[rand]);
    }
}
