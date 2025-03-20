import java.util.Random;
import java.util.Scanner;

public class Tank extends Character {
    // TODO add the requirements to setters and init
    /*
     * Characteristics : 
     * High hp amount (175-200) with very low luck stat (0-0.2)
     * sp -> 30-45
     * Moderate strength (35-40) with low power (30-35)
     * high defense (20-25) with moderate special_defense (10-15)
     * Max shield : 30-50
     */

    private int maxShield ;
    private int shield ;

    public Tank() {
    }

    @Override
    public void init() {
        super.init() ;

        @SuppressWarnings({ "ressource", "resource" })
        Scanner scan = new Scanner(System.in) ;

        System.out.print("Enter the maximum possible shield value : ");
        this.maxShield = scan.nextInt() ;
        this.shield = 0 ;
        System.out.println("--------------------- Tank created ---------------------\n");
    }

    public void setMaxShield(int value) {
        this.maxShield = value ;
    }

    public void setShield(int value) {
        if (value <= this.maxShield)
            this.shield = value ;
        else
            this.shield = this.maxShield ;
    }

    public int getMaxShield() {
        return this.maxShield ;
    }

    public int getShield() {
        return this.shield ;
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
}