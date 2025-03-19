import java.util.Random;
import java.util.Scanner;

// TODO add getters and setters + add javadoc
public class Archer extends Character {
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