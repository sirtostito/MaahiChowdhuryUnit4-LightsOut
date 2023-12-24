import javax.swing.*;
import java.util.Scanner;
    public class Lights {
    private int rows;
    private int columns;

    public Lights(int rows,int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void start() {
        gamePlay();
    }
    public void gamePlay() {
        System.out.println("Welcome to Lights Out. In this game, you will select\nco-ordinates composed of one letter and one number in\na 5-by-5 board with black and white squares. Each time\na coordinate is selected, the squares left, right,\nabove, below it, as well as itself will all be changed into\nthe opposite color as it currently is. Your job is to turn\nall the white squares black. Good luck!");
        String repeat = "y";
        System.out.println(" ");
        while (repeat.equals("y")) {
            Actions acts = new Actions(3);
            acts.initialBoard(rows,columns);
            while (acts.getWhiteSquares() != 0) {
                System.out.println(" ");
                acts.editGrid();
                System.out.println(" ");
                System.out.println("There are currently " + acts.getBlackSquares() + " black squares and " + acts.getWhiteSquares() + " white squares remaining.");
                System.out.println(" ");
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("Congratulations, you successfully turned all the Lights Out!");
            System.out.println("Would you like to play again? y/n");
            repeat = scan.nextLine().toLowerCase();
        }
    }
}
//⬛⬜