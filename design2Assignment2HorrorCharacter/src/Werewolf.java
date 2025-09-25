import java.util.ArrayList;

public class Werewolf extends HorrorCharacter implements Transformable
{
    private boolean isFullMoon;
    private int attackMultiplierFullMoon;
    public Werewolf(String initName, int initHealth, ArrayList<Vulnerability> initVulnerabilities, int initMaxPower, boolean initIsFullMoon, int initAttackMultiplierFullMoon)
    {
        super(initName, initHealth, initVulnerabilities, initMaxPower);
        isFullMoon = initIsFullMoon;
        attackMultiplierFullMoon = initAttackMultiplierFullMoon;
    }

    @Override
    public void attack(HorrorCharacter target)
    {
        int baseAttack = getPower() * (target.getVulnerabilities().contains(Vulnerability.Sunlight) ? 2 : target.getVulnerabilities().contains(Vulnerability.Fire) ? 2 : 1); //decreases target's health by Werewolf object's power multiplied by 2 if the target has a vulnerability to fire or sunlight
        if (target.getCanAttack())
        {
            if (isFullMoon)
            {
                target.setCurHealth(target.getCurHealth() - baseAttack * attackMultiplierFullMoon);
            }
            else
            {
                target.setCurHealth(target.getCurHealth() - baseAttack);
            }
        }
    }

    @Override
    public void flee()
    {
        if (!isFullMoon)
        {
            super.flee(); //Werewolves are regular people until a full moon, and will not flee only during one
        }
    }

    public void transform()
    {
        isFullMoon = !isFullMoon;
    }

    public static ArrayList<Vulnerability> accessWerewolfVulnerabilities()
    {
        ArrayList<Vulnerability> accessible = new ArrayList<>();
        accessible.add(Vulnerability.Magic);
        accessible.add(Vulnerability.Ice);
        return accessible;
    }


}
