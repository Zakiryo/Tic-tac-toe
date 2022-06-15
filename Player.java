import java.util.Scanner;

public class Player {
    private final String name;
    private final String symbol;
    private final Scanner sc = new Scanner(System.in);

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void play(Grid grid) {
        System.out.print("It's the turn of " + name + " !\nEnter the number of the cell you want to check : ");
        int selectedCell;
        selectedCell = sc.nextInt() - 1;
        while (selectedCell > 9 || selectedCell < 0 || grid.getCells().get(selectedCell).isOccupied()) {
            System.out.print("Sorry. You can't play on this cell. Please, choose another one : ");
            selectedCell = sc.nextInt();
        }
        grid.getCells().get(selectedCell).useCell(symbol);
        System.out.println(grid.displayGrid());
        grid.isFinished();
    }
}
