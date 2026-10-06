import java.util.ArrayList;

public class PokeAttacks {
    static ArrayList<Attack> attacks = new ArrayList<>();
    public static void seedAttacks() {



        Attack flameThrower = new DamageAttack("Flamethrower", 55, 95, PokeElement.FIRE);
        attacks.add(flameThrower);
        Attack fireblast = new DamageAttack("Fire blast", 90, 75, PokeElement.FIRE);
        attacks.add(fireblast);
        Attack wingAttack = new DamageAttack("Wing Attack", 40, 100, PokeElement.FIRE);
        attacks.add(wingAttack);

        Attack waterGun = new DamageAttack("Water Gun", 40, 100, PokeElement.WATER);
        attacks.add(waterGun);
        Attack hydroPump = new DamageAttack("Hydro Pump", 90, 75, PokeElement.WATER);
        attacks.add(hydroPump);
        Attack aquaTail = new DamageAttack("Aqua Tail", 60, 90, PokeElement.WATER);
        attacks.add(aquaTail);


        Attack thunderBolt = new DamageAttack("ThunderBolt", 65, 90,PokeElement.ELECTRIC);
        attacks.add(thunderBolt);
        Attack quickAttack = new DamageAttack("Quick Attack", 35, 100, PokeElement.NORMAL);
        attacks.add(quickAttack);
        Attack electroBall = new DamageAttack("Electro Ball",55, 90, PokeElement.ELECTRIC);
        attacks.add(electroBall);


        Attack vineWhip = new DamageAttack("Vine Whip",45,100, PokeElement.GRASS);
        attacks.add(vineWhip);
        Attack razorLeaf = new DamageAttack("Razor Leaf",60,95,PokeElement.GRASS);
        attacks.add(razorLeaf);
        Attack solarBeam = new DamageAttack("Solar Beam",105,70,PokeElement.GRASS);
        attacks.add(solarBeam);


        Attack iceBeam = new DamageAttack("Ice Beam",70, 95,PokeElement.ICE);
        attacks.add(iceBeam);
        Attack iceShard = new DamageAttack("Ice Shard", 40,100,PokeElement.ICE);
        attacks.add(iceShard);
        Attack blizzard = new DamageAttack("Blizzard",105,70,PokeElement.ICE);
        attacks.add(blizzard);


        Attack bodySlam = new DamageAttack("Body Slam", 65, 100, PokeElement.NORMAL);
        attacks.add(bodySlam);
        Attack hyperBeam = new DamageAttack("Hyper Beam", 110, 75, PokeElement.NORMAL);
        attacks.add(hyperBeam);
        Attack crunch = new DamageAttack("Crunch",75,95,PokeElement.NORMAL);
        attacks.add(crunch);











    }





}








