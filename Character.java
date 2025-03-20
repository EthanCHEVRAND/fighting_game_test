import java.util.Random;
import java.util.Scanner;

/**
 * Character management for inline fighting game
 * @author ZeSpatule
 * @version a.1.0
 */
public class Character {
    // TODO add the requirements to setters and init
    /*
     * Stats requirements : 
     * hp -> 90-200
     * base sp -> 30 - 60
     * strength -> 30-50
     * power -> 30-50
     * defense -> 5-25
     * special defense -> 5-25
     * luck -> 0-0.30
     */

    private String name ;
    private int base_health ;
    private int hp ; // health points
    private int sp ; // skill points
    private int strength ; // for basic attacks
    private int power ; // for skills
    private int defense ;
    private int special_defense ;
    private double luck ;
    private boolean canPlay ;
    private int stunDuration ; // a counter to know when to reverse a stun (trap/charged attack)

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
            this.canPlay = true ;
            this.stunDuration = 0 ;
        
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
     * Sets the base hp value
     * @param bhp
     */
    public void setBaseHealth(int bhp) {
        this.base_health = bhp ;
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
     * Sets the canPlay value
     * @param value
     */
    public void setCanPlay(boolean value) {
        this.canPlay = value ;
    }

    /**
     * Sets the stun counter
     * @param value
     */
    public void setStunDuration(int value) {
        this.stunDuration = value ;
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

    /**
     * Returns the stun counter
     * @return this.stunDuration
     */
    public int getStunDuration() {
        return this.stunDuration ;
    }


    // Methods

    /**
     * Returns true if the character is able to play during this turn
     * @return
     */
    public boolean canPlay() {
        return this.canPlay ;
    }

    /**
     * Returns if the Character is dead
     * @return this.hp <= 0
     */
    public boolean isDead() {
        return this.hp <= 0 ;
    }

    /**
     * Kills the player who is giving up by setting their hp to 0 to make the main loop stop
     */
    public void abandon() {
        this.hp = 0 ;
        System.out.println("You abandonned");
    }

    /**
     * At the end of the turn, makes the Character get 5 sp back
     */
    public void getSpBack() {
        this.setSkillPoints(this.getSkillPoints() + 5);
    }

    /**
     * Creates a nice box around the information given
     * @param info
     */
    public void displayInformation(String info) {
        return ;
    }

    /**
     * Calculates the damage done with a physical attack to a certain target
     * @param target
     * @return the damage value
     */
    public int physicalAttack(Character target) {
        Random rand = new Random() ;
        double randomDouble = rand.nextDouble() ;
        if (randomDouble < 0.5) {
            randomDouble = 0.5 ;
        }
        return (int)((this.strength - target.getDefense()) * randomDouble) ;
    }

    /**
     * Calculates the damage of a special attack (maybe useless)
     * @param target
     * @return the damage value
     */
    public int specialAttack(Character target) {
        Random rand = new Random() ;
        double randomDouble = rand.nextDouble() ;
        if (randomDouble < 0.7) {
            randomDouble = 0.7 ;
        }
        return (int)((this.power - target.getSpecialDefense()) * randomDouble) ;
    }

    /**
     * Make the action of the attack, so either misses or remove the correct amount of damage
     * @param target
     * @param damage
     */
    public boolean attack(Character target, int damage) {
        Random rand = new Random() ;
        if (rand.nextDouble() > this.luck) {
            target.setHealth(target.getHealth() - damage) ;
            System.out.println(target.name + " lost " + damage + "hp !");
        }
        else
            System.out.println("The attack missed...");
        return true ;
    }

    public String toString() {
        String s = "~~~~~~~~~~~~~~~~~~~~" + this.name + "~~~~~~~~~~~~~~~~~~~~" ;
        s += "\n" + this.hp + "/" + this.base_health + " | skill points : " + this.sp;
        s +=  "\nStrength : " + this.strength + " | Power : " + this.power ;
        s += "\nDefense : " + this.defense + " | Special defense : " + this.special_defense ;
        s += "\nLuck : " + Math.round(this.luck*100) / 100.0 ;
        return s ;
    }
}