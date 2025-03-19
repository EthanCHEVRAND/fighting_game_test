class Game {
    public static void main (String[] args) {
        Character perso = new Character() ;
        Character perso2 = new Character() ;
        perso.init() ;
        perso2.init() ;
        System.out.println(perso);
        System.out.println(perso2);
        perso2.attack(perso, perso2.physicalAttack(perso)) ;
        System.out.println(perso) ;
    }
}