import java.util.ArrayList;
import java.util.Random;
public class HorrorCharacterApp
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        ArrayList<HorrorCharacter> hcs = new ArrayList<>();
        ArrayList<HorrorCharacter> fledCharacters = new ArrayList<>();
        Vampire v = new Vampire("Goober", 25, Vampire.accessVampireVulnerabilities(), 10, true, false, 2);
        Zombie z = new Zombie("Floobus", 15, Zombie.accessZombieVulnerabilities(), 15, true);
        Werewolf w = new Werewolf("Globtron", 30, Werewolf.accessWerewolfVulnerabilities(), 8, false, 3);

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
