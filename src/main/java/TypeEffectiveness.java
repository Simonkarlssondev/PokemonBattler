public class TypeEffectiveness {

    public static double getMultiplier(PokeElement attackType, PokeElement defenderType) {

        if (attackType == PokeElement.FIRE && defenderType == PokeElement.GRASS){
            return 2.0;
        }



        return 1.0;
    }
}
