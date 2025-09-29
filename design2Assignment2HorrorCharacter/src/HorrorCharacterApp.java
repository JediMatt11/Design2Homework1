import java.util.ArrayList;
import java.util.Random;

/**
 * Main app for showing HorrorCharacter functionality and HorrorCharacter subclass's functionality
 */
public class HorrorCharacterApp
{
    /**
     *Creates a random object, an arrayList of HorrorCharacters utilizing polymorphism, and three horror character sublass objects
     * makes a 1 in 3 chance to do nothing, or transform a vampire object using the Transformable inteface, or transform a Werewolf object
     * randomizes a target for each horror character in the ArrayList to attack
     * if the target is the current horror character, it instead flees
     * if the target is another horror character that has fled, it states they cannot be attacked
     * if neither of these situations is the case, the target is attacked using the current horror character's overridden attack method
     */
    public static void main(String[] args)
    {
        Random rng = new Random();
        ArrayList<HorrorCharacter> hcs = new ArrayList<>();
        ArrayList<HorrorCharacter> fledCharacters = new ArrayList<>();
        Vampire v = new Vampire("Vampiretron", 25, Vampire.accessVampireVulnerabilities(), 10, true, false, 2);
        Zombie z = new Zombie("Zombaly", 15, Zombie.accessZombieVulnerabilities(), 15, true);
        Werewolf w = new Werewolf("Wolfy", 30, Werewolf.accessWerewolfVulnerabilities(), 8, false, 3);

        hcs.add(v);
        hcs.add(z);
        hcs.add(w);

        int chance = rng.nextInt(3);
        switch (chance)
        {
            case 0:
                v.transform();
                System.out.println("Vampire has transformed into a humanoid.");
                break;
            case 1:
                w.transform();
                System.out.println("Werewolf has transformed under the full moon.");
                break;
            default:
                break;
        }

        for (HorrorCharacter hc : hcs)
        {
            HorrorCharacter target;
            target = hcs.get(rng.nextInt(hcs.size()));
            if (target == hc)
            {
                hc.flee();
                fledCharacters.add(hc);
                System.out.println(hc.getClass().getName() + " flees.");
            }
            else if (fledCharacters.contains(target))
            {
                System.out.println("Target " + target.getClass().getName() + " has fled, and cannot be attacked.");
            }
            else
            {
                hc.attack(target);
                System.out.println("Target " + target.getClass().getName() + " now has " + target.getCurHealth() + " health left!");
            }
        }
    }
}
