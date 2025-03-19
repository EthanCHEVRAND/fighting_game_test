class Game {
    public static void main (String[] args) {
        Character perso = new Character() ;
        Archer perso2 = new Archer() ;
        perso.init() ;
        perso2.init() ;
        System.out.println(perso);
        System.out.println(perso2);
        perso.attack(perso2, perso.physicalAttack(perso2)) ;
        System.out.println(perso) ;
        System.out.println(perso2);
        perso2.attack(perso, perso2.fireArrow(perso)) ;
        System.out.println(perso) ;
        System.out.println(perso2);
        perso2.passiveSkill() ;
        System.out.println(perso2);
    }

    public static void endTurnActions() {
        // TODO do this function when the actions are defined
    }
}