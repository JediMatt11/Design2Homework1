import java.util.ArrayList;
import java.util.Random;
public abstract class HorrorCharacter
{
    private String name;
    private int curHealth;
    private int maxHealth;
    private int maxPower;
    private int power;
    private boolean canAttack;
    private ArrayList<Vulnerability> vulnerabilities;

    public HorrorCharacter()
    {
        name = "";
        curHealth = 0;
        maxHealth = 0;
        maxPower = 0;
        power = 0;
        canAttack = true;
        vulnerabilities = new ArrayList<>();
    }

    public HorrorCharacter(String initName, int initHealth, ArrayList<Vulnerability> initVulnerabilities, int initMaxPower)
    {
        name = initName;
        curHealth = initHealth;
        maxHealth = initHealth;
        maxPower = initMaxPower;
        Random rng = new Random();
        power = rng.nextInt(maxPower) + 1;
        canAttack = true;
        vulnerabilities = initVulnerabilities;
    }
    public void attack(HorrorCharacter target)
    {
        if (target.canAttack)
        {
            target.curHealth -= power;
        }
    }

    public void flee()
    {
        canAttack = false;
        curHealth = maxHealth;
    }


    public String toString()
    {
        String hcString = "";
        hcString += "Name: " + name + " Current Health: " + curHealth + " Max Health: " + maxHealth + " Power: " + power + " Max Power: " + maxPower + " Attackable: " + canAttack + " Vulnerabilities: ";
        for (int i = 0; i < vulnerabilities.size(); i++)
        {
            hcString += vulnerabilities.get(i);
            if (i < vulnerabilities.size() - 1)
            {
                hcString += ", ";
            }
        }
        return hcString;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        if (!newName.isEmpty())
        {
            name = newName;
        }
    }

    public int getCurHealth()
    {
        return curHealth;
    }

    public void setCurHealth(int newCurHealth)
    {
        if (newCurHealth > 0)
        {
            curHealth = newCurHealth;
        }
        else
        {
            curHealth = 0;
        }
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int newMaxHealth)
    {
        if (newMaxHealth > 0)
        {
            maxHealth = newMaxHealth;
        }
    }

    public int getMaxPower()
    {
        return maxPower;
    }

    public void setMaxPower(int newMaxPower)
    {
        if (newMaxPower > 0)
        {
            maxPower = newMaxPower;
        }
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int newPower)
    {
        if (newPower > 0)
        {
            power = newPower;
        }
    }

    public ArrayList<Vulnerability> getVulnerabilities()
    {
        return vulnerabilities;
    }

    public void setVulnerabilities(ArrayList<Vulnerability> newVulnerabilities)
    {
        if (!newVulnerabilities.isEmpty())
        {
            vulnerabilities = newVulnerabilities;
        }
    }

    public boolean getCanAttack()
    {
        return canAttack;
    }
}

