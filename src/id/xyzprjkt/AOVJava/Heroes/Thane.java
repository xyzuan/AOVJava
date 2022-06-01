package id.xyzprjkt.AOVJava.Heroes;

import id.xyzprjkt.AOVJava.Role.Tank;

import java.util.Random;

public class Thane extends Tank {
    @Override
    public void spawnIntro(){
        Random randomTaunt = new Random();
        String[] taunt = {  "Hanya itu saja kemampuanmu?",
                            "Armor ku tidak mungkin pecah",
                            "Saya sangat kuat",
                            "Seranganmu tidak berasa",
                            "Kamu akan mati"
        };

        int rand = randomTaunt.nextInt(taunt.length);
        System.out.println("Thane : " + taunt[rand]);
    }
}
