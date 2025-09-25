import java.util.ArrayList;

public class Zombie extends HorrorCharacter
{
    private boolean isDaytime;
    public Zombie(String initName, int initHealth, ArrayList<Vulnerability> initVulnerabilities, int initMaxPower, boolean initIsDaytime)
    {
        super(initName, initHealth, initVulnerabilities, initMaxPower);
        isDaytime = initIsDaytime;
    }

    @Override
    public void attack(HorrorCharacter target)
    {
        if (target.getCanAttack())
        {
            target.setCurHealth(target.getCurHealth() - (getPower() * (target.getVulnerabilities().contains(Vulnerability.Sword) ? 2 : target.getVulnerabilities().contains(Vulnerability.holyWater) ? 2 : 1))); //decreases target's health by Zombie object's power multiplied by 2 if the target has a vulnerability to swords or holy water
        }
    }

    @Override
    public void flee()
    {
        if (isDaytime)
        {
            super.flee(); //Zombies can't survive sunlight but otherwise always attack, so they will only want to flee a battle in the daytime
        }
    }

    public static ArrayList<Vulnerability> accessZombieVulnerabilities()
    {
        ArrayList<Vulnerability> accessible = new ArrayList<>();
        accessible.add(Vulnerability.Sword);
        accessible.add(Vulnerability.Fire);
        return accessible;
    }

}
