package com;

import java.util.Scanner;

class Game {
    private int nextAttack ; // stores the next attack damages (useful for stuns)
    private Character active ; // stores the currently playing character
    
    public static void main (String[] args) {
        System.out.println("Welcome to this fighting template");
        Scanner scan = new Scanner(System.in) ;
        System.out.print("Enter option (0 : play | 1 : create a character | 2 : load a character | 3 : quit)\nplayer > ");
        int choice = scan.nextInt() ;
        switch (choice) {
            case 0:
                Tank perso = new Tank() ;
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
                break;

            case 1:
                System.out.println("Not implemented yet");
                break ;

            case 2:
                System.out.println("Not implemented yet");
                break ;

            case 3:
                System.out.println("Not implemented yet");
                break ;
        
            default:
                System.out.println("Invalid option");
                break;
        }
        
        
    }

    public static void endTurnActions() {
        // TODO do this function when the actions are defined
    }
}