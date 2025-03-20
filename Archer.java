import java.util.Random;
import java.util.Scanner;

// TODO add javadoc
public class Archer extends Character {
    // TODO add the requirements to setters and init
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

    @Override
    public void init() {
        super.init() ;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in) ;
        System.out.print("Enter the maximum amount of arrows : ");
        this.nbMaxArrow = scan.nextInt() ;
        this.nbArrow = this.nbMaxArrow ;
        System.out.println("-------------------- Archer created --------------------\n");
    }

    // Setters and getters

    /**
     * Sets the max amount of arrows
     * @param amount
     */
    public void setNbMaxArrow(int amount) {
        this.nbMaxArrow = amount ;
    }

    /**
     * Sets the current amount of arrows available
     * @param amount
     */
    public void setNbArrow(int amount) {
        this.nbArrow = amount ;
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
    public void attack(Character target, int damage) {
        if (nbArrow > 0)
            super.attack(target, damage) ;
        else
            System.out.println("No arrows left...");

        this.nbArrow-- ;
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