import java.util.Random;
import java.util.Scanner;

// TODO add javadoc
/**
 * Character's subclass
 * Managing class for Archer ingame class
 * @author ZeSpatule
 */
public class Archer extends Character {
    /*
     * Characteristics : 
     * Low hp amount (90-120) with high luck stat (0.25-0.30)
     * sp -> 45-60
     * Moderate strength (35-40) with high power (40-50)
     * Low defense (5-10) with moderate special_defense (10-15)
     * Max arrows : 10-15
     */

    private int nbMaxArrow ;
    private int nbArrow ;


    public Archer() {
        super() ;
    }

    // Setters and getters

    /**
     * Sets the max amount of arrows
     * @param amount
     */
    public void setNbMaxArrow(int amount) {
        if (amount < 10) {
            this.nbMaxArrow = 10 ;
        } else if (amount > 15) {
            this.nbMaxArrow = 15 ;
        } else {
            this.nbMaxArrow = amount ;
        }
    }

    /**
     * Sets the current amount of arrows available
     * @param amount
     */
    public void setNbArrow(int amount) {
        if (amount < 0) {
            this.nbArrow = 0 ;
        } else if (amount > 15) {
            this.nbArrow = 15 ;
        } else {
            this.nbArrow = amount ;
        }
    }

    /**
     * Sets base health to proper value
     */
    @Override
    public void setBaseHealth(int bhp) {
        if (bhp < 90) {
            super.setBaseHealth(90);
        } else if (bhp > 120) {
            super.setBaseHealth(120);
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
        if (pow < 40) {
            super.setPower(40);
        } else if (pow > 50) {
            super.setStrength(50);
        } else {
            super.setStrength(pow);
        }
    }

    /**
     * Sets defense to proper value
     */
    @Override
    public void setDefense(int def) {
        if (def < 5) {
            super.setDefense(5) ;
        } else if (def > 10) {
            super.setDefense(10) ;
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
        if (l < 0.25) {
            super.setLuck(0.25) ;
        } else if (l > 0.3) {
            super.setLuck(0.3) ;
        } else {
            super.setLuck(l);
        }
    }

    /**
     * Returns the max amount of arrows
     * @return this.nbMaxArrow
     */
    public int getNbMaxArrow() {
        return this.nbMaxArrow ;
    }

    /**
     * Returns the current amount of arrows available
     * @return this.nbArrow
     */
    public int getNbArrow() {
        return this.nbArrow ;
    }

    @Override
    public void init() {
        System.out.println("Hp (90-120) | Skill points (35-50)\nStrength (35-40) | Power (40-50)\nDefense (5-10) | Special defense (10-15)\\n" + //
                        "Luck (0.25-0.3)\nMax arrows (10-15)");
        super.init() ;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in) ;
        System.out.print("Enter the maximum amount of arrows : ");
        int value = scan.nextInt() ;
        this.setNbMaxArrow(value) ;
        this.nbArrow = this.nbMaxArrow ;

        // makes the stats work properly with the class
        this.setBaseHealth(this.getBaseHealth());
        this.setHealth(this.getBaseHealth());
        this.setStrength(this.getStrength());
        this.setPower(this.getPower());
        this.setDefense(this.getPower());
        this.setSpecialDefense(this.getSpecialDefense());
        this.setLuck(this.getLuck());
        System.out.println("-------------------- Archer created --------------------\n");
    }

    // methods

    public int fireArrow(Character target) {
        if (this.nbArrow >= 0 && this.getSkillPoints() >= 15) {
            Random rand = new Random() ;
            int damage = (int)((this.getPower() - target.getSpecialDefense()) * rand.nextDouble(1.0, 2.0)) ;
            this.setSkillPoints(this.getSkillPoints() - 15);
            this.nbArrow-- ;
            System.out.println(this.getName() + " lost 15 skill points and 1 arrow.");
            return damage ;
        } else {
            System.out.println("No arrow left or not enough skill points...");
            return 0 ;
        }    
    }

    public void trap(Character target) {
        if (this.getSkillPoints() >= 15) {
            // makes the opponent stun for one turn
        }
    }

    public boolean passiveSkill() {
        if (this.getSkillPoints() >= 10 ) {
            this.nbArrow += 5 ;
            if (this.nbArrow > this.nbMaxArrow)
                this.nbArrow = this.nbMaxArrow ;

            this.activatePassiveBuff();
            
            this.setSkillPoints(this.getSkillPoints() - 10);
            return true ;
        } else {
            System.out.println("Cannot activate this skill...");
            return false ;
        }
    }

    public double activatePassiveBuff() {
        double addValue = 0.5*this.getLuck() ;
        this.setLuck(this.getLuck() + addValue);
        return addValue ;
    }

    public void deactivatePassiveBuff(double removeValue) {
        this.setLuck(this.getLuck() - removeValue);
    }

    @Override
    public boolean attack(Character target, int damage) {
        if (nbArrow > 0) {
            super.attack(target, damage) ;
            this.nbArrow-- ;
            return true ;
        }
        else
            System.out.println("No arrows left...");
            return false ;

    }

    @Override
    public String toString() {
        String s = super.toString() ;
        s += " | Arrows : " + this.nbArrow + "/" + this.nbMaxArrow ;
        s += "\n" ;
        for (int i = 0 ; i < 40+this.getName().length() ; i++)
            s += "~" ;
        return s ;
    }

}