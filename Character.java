import java.util.Random;
import java.util.Scanner;

/**
 * Base Character class
 * @author ZeSpatule
 * @version a.1.0
 */
public class Character {
    private String name ;
    private int base_health ;
    private int hp ; // health points
    private int sp ; // skill points
    private int strength ; // for basic attacks
    private int power ; // for skills
    private int defense ;
    private int special_defense ;
    private double luck ;

    /**
     * Default Character builder
     */
    public Character(){
    }

    /**
     * Interactively asks and initialise values for a Character object
     */
    public void init() {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in) ;
        // scan.nextLine() ;
            System.out.print("Enter name : ");
            this.name = scan.nextLine() ;
            System.out.print("Enter base health value : ");
            this.base_health = scan.nextInt() ;
            this.hp = this.base_health ;
            System.out.print("Enter skill points value : ");
            this.sp = scan.nextInt() ;
            System.out.print("Enter strength value : ");
            this.strength = scan.nextInt() ;
            System.out.print("Enter power value : ");
            this.power = scan.nextInt() ;
            System.out.print("Enter defense value : ");
            this.defense = scan.nextInt() ;
            System.out.print("Enter special defense value : ");
            this.special_defense = scan.nextInt() ;
            System.out.print("Enter luck value (between 0 and 1) : ") ;
            this.luck = scan.nextFloat() ;
        
    }

    // setters and getters

    // TODO set min and max values for each setter

    /**
     * Sets name
     * @param s
     */
    public void setName(String s) {
        this.name = s ;
    }

    /**
     * Sets health value
     * @param health
     */
    public void setHealth(int health) {
        this.hp = health ;
    }

    /**
     * Sets skill points value
     * @param skill_points
     */
    public void setSkillPoints(int skill_points) {
        this.sp = skill_points ;
    }

    /**
     * Sets strength value
     * @param str
     */
    public void setStrength(int str) {
        this.strength = str ;
    }

    /**
     * Sets power value
     * @param pow
     */
    public void setPower(int pow) {
        this.power = pow ;
    }

    /**
     * Sets defense value
     * @param def
     */
    public void setDefense(int def) {
        this.defense = def ;
    }

    /**
     * Sets special defense value
     * @param spe_def
     */
    public void setSpecialDefense(int spe_def) {
        this.special_defense = spe_def ;
    }

    /**
     * Sets luck value
     * @param l
     */
    public void setLuck(double l) {
        this.luck = l ;
    }

    /**
     * Returns name
     * @return this.name
     */
    public String getName() {
        return this.name ;
    }

    /**
     * Returns base health value
     * @return this.base_health
     */
    public int getBaseHealth() {
        return this.base_health ;
    }

    /**
     * Returns health value
     * @return this.health
     */
    public int getHealth() {
        return this.hp ;
    }

    /**
     * Returns skill points value
     * @return this.sp
     */
    public int getSkillPoints() {
        return this.sp ;
    }

    /**
     * Returns strength value
     * @return this.strength
     */
    public int getStrength() {
        return this.strength ;
    }

    /**
     * Returns power value
     * @return this.power
     */
    public int getPower() {
        return this.power ;
    }

    /**
     * Returns defense value
     * @return this.defense
     */
    public int getDefense() {
        return this.defense ;
    }

    /**
     * Returns special defense value
     * @return this.special_defense
     */
    public int getSpecialDefense() {
        return this.special_defense ;
    }

    /**
     * Returns luck value
     * @return this.luck
     */
    public double getLuck() {
        return this.luck ;
    }


    // Methods

    public boolean isDead() {
        return this.hp <= 0 ;
    }

    public void abandon() {
        this.hp = 0 ;
        System.out.println("You abandonned");
    }

    // TODO add javadoc
    public int physicalAttack(Character target) {
        Random rand = new Random() ;
        double randomDouble = rand.nextDouble() ;
        if (randomDouble < 0.5) {
            randomDouble = 0.5 ;
        }
        return (int)((this.strength - target.getDefense()) * randomDouble) ;
    }

    // TODO add javadoc
    public int specialAttack(Character target) {
        Random rand = new Random() ;
        double randomDouble = rand.nextDouble() ;
        if (randomDouble < 0.7) {
            randomDouble = 0.7 ;
        }
        return (int)((this.power - target.getSpecialDefense()) * randomDouble) ;
    }

    // TODO add javadoc
    public void attack(Character target, int damage) {
        Random rand = new Random() ;
        if (rand.nextDouble() > this.luck) {
            target.setHealth(target.getHealth() - damage) ;
            System.out.println(target.name + " lost " + damage + "hp !");
        }
        else
            System.out.println("The attack missed...");
    }

    public String toString() {
        String s = "~~~~~~~~~~~~~~~~~~~~" + this.name + "~~~~~~~~~~~~~~~~~~~~" ;
        s += "\n" + this.hp + "/" + this.base_health + " | skill points : " + this.sp;
        s +=  "\nStrength : " + this.strength + " | Power : " + this.power ;
        s += "\nDefense : " + this.defense + " | Special defense : " + this.special_defense ;
        s += "\nLuck : " + this.luck ;
        return s ;
    }
}