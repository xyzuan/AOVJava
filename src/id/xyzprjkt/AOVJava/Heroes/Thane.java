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
