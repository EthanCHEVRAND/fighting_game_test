import java.util.Random;
import java.util.Scanner;
/**
 * Character's subclass
 * Managing class for Tank ingame class
 * @author ZeSpatule
 */
public class Tank extends Character {
    /*
     * Characteristics : 
     * High hp amount (175-200) with very low luck stat (0-0.02)
     * sp -> 30-45
     * Moderate strength (35-40) with low power (30-35)
     * high defense (20-25) with moderate special_defense (10-15)
     * Max shield : 30-50
     */

    private int maxShield ;
    private int shield ;

    public Tank() {
    }

    /**
     * Sets base health to proper value
     */
    @Override
    public void setBaseHealth(int bhp) {
        if (bhp < 175) {
            super.setBaseHealth(175);
        } else if (bhp > 200) {
            super.setBaseHealth(200);
        } else {
            super.setBaseHealth(bhp);
        }
    }

    /**
     * Sets strength to the proper value
     */
    @Override
    public void setStrength(int str) {
        if (str < 35) {
            super.setStrength(35);
        } else if (str > 40) {
            super.setStrength(40);
        } else {
            super.setStrength(str);
        }
    }

    /**
     * Sets power to proper value
     */
    @Override
    public void setPower(int pow) {
        if (pow < 30) {
            super.setPower(30);
        } else if (pow > 35) {
            super.setStrength(35);
        } else {
            super.setStrength(pow);
        }
    }

    /**
     * Sets defense to proper value
     */
    @Override
    public void setDefense(int def) {
        if (def < 20) {
            super.setDefense(20) ;
        } else if (def > 25) {
            super.setDefense(25) ;
        } else {
            super.setDefense(def) ;
        }
    }

    /**
     * Sets special defense to proper value
     */
    @Override
    public void setSpecialDefense(int spe_def) {
        if (spe_def < 10) {
            super.setSpecialDefense(10);
        } else if (spe_def > 15) {
            super.setSpecialDefense(15);
        } else {
            super.setSpecialDefense(spe_def);
        }
    }

    /**
     * Sets luck to proper value
     * @param l
     */
    @Override
    public void setLuck(double l) {
        if (l < 0) {
            super.setLuck(0) ;
        } else if (l > 0.02) {
            super.setLuck(0.02) ;
        } else {
            super.setLuck(l);
        }
    }

    /**
     * Sets max shield to proper value
     * @param value
     */
    public void setMaxShield(int value) {
        if (value < 30)
            this.maxShield = 30 ;
        else if (value > 50)
            this.maxShield = 50 ;
        else 
            this.maxShield = value ;
    }

    /**
     * Sets the shield to the value
     * @param value
     */
    public void setShield(int value) {
        if (value <= this.maxShield)
            this.shield = value ;
        else
            this.shield = this.maxShield ;
    }

    /**
     * returns the max amount of shield
     * @return this.maxShield
     */
    public int getMaxShield() {
        return this.maxShield ;
    }

    /**
     * Returns the current amount of shield
     * @return this.shield
     */
    public int getShield() {
        return this.shield ;
    }

    @Override
    public void init() {
        System.out.println("Hp (175-200) | Skill points (30-45)\nStrength (35-40) | Power (30-35)\nDefense (20-25) | Special defense (10-15)\nMax shield (30-50)\nLuck (0-0.02)");
        super.init() ;

        @SuppressWarnings({ "ressource", "resource" })
        Scanner scan = new Scanner(System.in) ;

        System.out.print("Enter the maximum possible shield value : ");
        int value = scan.nextInt() ;
        this.setMaxShield(value) ;
        this.shield = 0 ;

        // makes the stats work properly with the class
        this.setBaseHealth(this.getBaseHealth());
        this.setHealth(this.getBaseHealth());
        this.setStrength(this.getStrength());
        this.setPower(this.getPower());
        this.setDefense(this.getPower());
        this.setSpecialDefense(this.getSpecialDefense());
        this.setLuck(this.getLuck());
        System.out.println("--------------------- Tank created ---------------------\n");
    }

    
    public boolean activateShield() {
        if (this.getSkillPoints() >= 15) {
            this.setShield((this.getPower() * this.getDefense()) / 25) ; 
            return true ;
        } else {
            System.out.println("Not enough skill points...");
            return false ;
        }
    }

    public int chargedAttack(Character target) {
        if (this.getSkillPoints() >= 15) {
            Random rand = new Random() ;
            int damage = (int)((this.getStrength() - target.getDefense()) * rand.nextDouble(3.0, 4.0)) ;
            setCanPlay(false);
            System.out.println(this.getName() + " is stunned for 1 turn.");
            return damage ;
        } else {
            System.out.println("Not enough skill points...");
            return 0 ;
        }
    }

    @Override
    public String toString() {
        String s = super.toString() ;
        s += " | Shield : " + this.getShield() + "/" + this.getMaxShield() ;
        s += "\n" ;
        for (int i = 0 ; i < 40+this.getName().length() ; i++)
            s += "~" ;
        return s ;
    }
}