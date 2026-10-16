package service;

import model.PokeElement;

public class TypeEffectiveness {

    public static double getMultiplier(PokeElement attackType, PokeElement defenderType) {

        if (attackType == PokeElement.NORMAL) {
            return 1.0;
        }
        if (attackType == PokeElement.FIRE && defenderType == PokeElement.GRASS){
            return 2.0;
        }
        if (attackType == PokeElement.WATER && defenderType == PokeElement.FIRE){
            return 2.0;
        }
        if (attackType == PokeElement.GRASS && defenderType == PokeElement.WATER){
            return 2.0;
        }
        if (attackType == PokeElement.ELECTRIC && defenderType == PokeElement.WATER){
            return 2.0;
        }
        if (attackType == PokeElement.FIRE && defenderType == PokeElement.WATER){
            return 0.5;
        }
        if (attackType == PokeElement.WATER && defenderType == PokeElement.GRASS){
            return 0.5;
        }
        if (attackType == PokeElement.GRASS && defenderType == PokeElement.FIRE){
            return 0.5;
        }

        return 1.0;





    }
}
