import java.util.Scanner;
import static java.lang.Character.getNumericValue;
public class Actions {
    private int whiteSquares;
    private int blackSquares;
    private int probability;

    public Actions(int probability) {
        this.probability = probability;
    }

    private char[][] grid = new char[6][6];
    public void initialBoard(int rows,int columns) {
        System.out.print("\n    A   B   C   D   E");
        for (int row = 1;row <= rows;row++) {
            System.out.print("\n" + row + "  ");
            for (int column = 1;column <= columns;column++) {
                int chance = half();
                if (chance == 1) {
                    grid[row][column] = '⬜';
                    whiteSquares++;
                } else {
                    grid[row][column] = '⬛';
                    blackSquares++;
                }
                System.out.print(grid[row][column] + "  ");
            }
        }
    }

    public void editGrid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter column (A-E) and row (1-5) to toggle the square (e.g., A5):");
        String input = scanner.nextLine().trim().toUpperCase();
        if (input.length() == 2) {
            int column = Character.getNumericValue(input.charAt(0)) - 9;
            int row = Integer.parseInt(input.substring(1));
            if (input.charAt(0) >= 'A' && input.charAt(0) <= 'E' && row >= 1 && row <= 5) {
                toggleSquare(row, column);
            } else {
                System.out.println("Invalid input. Please enter a valid coordinate (e.g., A5).");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid coordinate (e.g., A5).");
        }
    }

    public void toggleSquare(int row, int column) {
        if (row == 1 && (column != 1 && column != 5)) {
            change(row,column);
            change(2,column);
            change(row,column+1);
            change(row,column-1);
        }
        if (row == 5 && (column != 1 && column != 5)) {
            change(row,column);
            change(row-1,column);
            change(row,column+1);
            change(row,column-1);
        }
        if (column == 1 && (row != 1 && row != 5)) {
            change(row,column);
            change(row,2);
            change(row+1,column);
            change(row-1,column);
        }
        if (column == 5 && (row != 1 && row != 5)) {
            change(row,column);
            change(row,column-1);
            change(row+1,column);
            change(row-1,column);
        }
        if (column == 1 && row == 1) {
            change(row,column);
            change(row+1,column);
            change(row,column+1);
        }
        if (column == 1 && row == 5) {
            change(row,column);
            change(row-1,column);
            change(row,column+1);
        }
        if (column == 5 && row == 1) {
            change(row,column);
            change(row,column-1);
            change(row+1,column);
        }
        if (column == 5 && row == 5) {
            change(row,column);
            change(row-1,column);
            change(row,column-1);
        }
        if (row != 1 && row != 5 && column != 1 && column != 5) {
            change(row,column);
            change(row+1,column);
            change(row-1,column);
            change(row,column+1);
            change(row,column-1);
        }
        System.out.print("\n    A   B   C   D   E");
        for (int i = 1;i <=5;i++) {
            System.out.print("\n" + i + "  ");
            for (int j = 1;j <= 5;j++) {
                System.out.print(grid[i][j] + "  ");
            }
        }
    }

    public int getWhiteSquares() {
        return whiteSquares;
    }

    public int getBlackSquares() {
        return blackSquares;
    }

    private int half() {
        return (int) (Math.random() * probability) + 1;
    }

    private void change(int row,int column) {
        if (grid[row][column] == '⬜') {
            grid[row][column] = '⬛';
            whiteSquares--;
            blackSquares++;
        } else if (grid[row][column] == '⬛') {
            grid[row][column] = '⬜';
            whiteSquares++;
            blackSquares--;
        }
    }
}