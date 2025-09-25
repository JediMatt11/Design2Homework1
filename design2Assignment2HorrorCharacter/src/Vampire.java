import java.util.ArrayList;

public class Vampire extends HorrorCharacter implements Transformable
{
    private boolean isDaytime;
    private boolean isHumanoid;
    private int attackMultiplierHumanoid;
    public Vampire(String initName, int initHealth, ArrayList<Vulnerability> initVulnerabilities, int initMaxPower, boolean initIsDaytime, boolean initIsHumanoid, int initAttackMultiplierHumanoid)
    {
        super(initName, initHealth, initVulnerabilities, initMaxPower);
        isDaytime = initIsDaytime;
        isHumanoid = initIsHumanoid;
        attackMultiplierHumanoid = initAttackMultiplierHumanoid;
    }

    @Override
    public void attack(HorrorCharacter target)
    {
        if (target.getCanAttack())
        {
            int baseAttack = getPower() * (target.getVulnerabilities().contains(Vulnerability.Ice) ? 2 : target.getVulnerabilities().contains(Vulnerability.Magic) ? 2 : 1); //decreases target's health by Vampire object's power multiplied by 2 if the target has a vulnerability to ice or magic
            if (isHumanoid)
            {
                target.setCurHealth(target.getCurHealth() - baseAttack * attackMultiplierHumanoid);
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
        if (isDaytime)
        {
            super.flee(); //Vampires are more dangerous at night, so they will only want to flee a battle in the daytime
        }
    }

    public void transform()
    {
        isHumanoid = !isHumanoid;
    }

    public static ArrayList<Vulnerability> accessVampireVulnerabilities()
    {
        ArrayList<Vulnerability> accessible = new ArrayList<>();
        accessible.add(Vulnerability.holyWater);
        accessible.add(Vulnerability.Sunlight);
        return accessible;
    }

}
