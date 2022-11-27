import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        final Grid grid = new Grid();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Hi! Thanks for playing my Tic-tac-toe.\n" +
                    "Please, enter the names of the 2 players.\n");

            System.out.print("Player 1 (X) : ");
            final String name1 = sc.next();
            final Player p1 = new Player(name1, "X");

            System.out.print("Player 2 (O) : ");
            final String name2 = sc.next();
            final Player p2 = new Player(name2, "O");

            while (!grid.isFinished()) {
                p1.play(grid);
                if (grid.isFinished()) {
                    System.out.println(name1 + " won the game! Thanks for playing.");
                    break;
                }
                grid.isFull();
                p2.play(grid);
                if (grid.isFinished()) {
                    System.out.println(name2 + " won the game! Thanks for playing.");
                    break;
                }
                grid.isFull();
            }
        }
    }
}
