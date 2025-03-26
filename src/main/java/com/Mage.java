package com;


/**
 * Character's subclass
 * Managing class for Mage ingame class
 * @author ZeSpatule
 */
public class Mage extends Character {
    /*
     * Characteristics : 
     * Low hp amount (90-120) with moderate luck stat (0.10-0.20)
     * sp -> 60
     * Moderate strength (35-40) with high power (40-50)
     * Low defense (5-10) with moderate special_defense (10-15)
     * Element
     */

     private Element element ;

     public Mage() {
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
        if (l < 0.1) {
            super.setLuck(0.1) ;
        } else if (l > 0.2) {
            super.setLuck(0.2) ;
        } else {
            super.setLuck(l);
        }
    }


     public void init() {
        System.out.println("Hp (90-120) | Skill points (60)\nStrength (35-40) | Power (40-50)\nDefense (5-10) | Special defense (10-15)\\n" + //
                        "Luck (0.10-0.20)\nElement");

        super.init() ;

        // makes the stats work properly with the class
        this.setBaseHealth(this.getBaseHealth());
        this.setHealth(this.getBaseHealth());
        this.setStrength(this.getStrength());
        this.setPower(this.getPower());
        this.setDefense(this.getPower());
        this.setSpecialDefense(this.getSpecialDefense());
        this.setLuck(this.getLuck());
        System.out.println("--------------------- Mage created ---------------------\n");
     }
}