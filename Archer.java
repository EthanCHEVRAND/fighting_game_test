import java.util.Scanner;

public class Archer extends Character {
    private int nbMaxArrow ;
    private int nbArrow ;


    public Archer() {
        super() ;
    }

    @Override
    public void init() {
        super.init() ;

        Scanner scan = new Scanner(System.in) ;
        System.out.print("Enter the maximum amount of arrows : ");
        this.nbMaxArrow = scan.nextInt() ;
        this.nbArrow = this.nbMaxArrow ;
        System.out.println("-------------------- Archer created --------------------");
    }

}