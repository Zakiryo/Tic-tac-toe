import java.util.ArrayList;
import java.util.Objects;

public class Grid {
    private final ArrayList<Cell> Cells;

    public Grid() {
        Cells = new ArrayList<Cell>(9);
        for (int i = 0; i < 9; ++i) {
            Cells.add(new Cell());
        }
    }

    public String displayGrid() {
        StringBuilder grid = new StringBuilder();
        grid.append("\n");
        int counter = 0;
        for (int i = 0; i < 3; ++i) {
            grid.append(Cells.get(counter).getSymbol()).append("|").append(Cells.get(counter + 1).getSymbol()).append("|").append(Cells.get(counter + 2).getSymbol()).append("\n");
            counter += 3;
        }
        return grid.toString();
    }

    public ArrayList<Cell> getCells() {
        return this.Cells;
    }

    public boolean haveSameSymbols(Cell c1, Cell c2, Cell c3) {
        if (Objects.equals(c1.getSymbol(), " ") && Objects.equals(c2.getSymbol(), " ") && Objects.equals(c3.getSymbol(), " "))
            return false;
        return (Objects.equals(c1.getSymbol(), c2.getSymbol())) && (Objects.equals(c2.getSymbol(), c3.getSymbol())) && (Objects.equals(c1.getSymbol(), c3.getSymbol()));
    }

    public boolean isFinished() {
        int counter = 0;
        for (int i = 0; i < 3; ++i) {
            if (haveSameSymbols(Cells.get(counter + 1), Cells.get(counter), Cells.get(counter + 2))) {
                return true;
            }
            counter += 3;
        }
        counter = 0;
        for (int i = 0; i < 3; ++i) {
            if (haveSameSymbols(Cells.get(counter), Cells.get(counter + 3), Cells.get(counter + 6))) {
                return true;
            }
            ++counter;
        }
        return haveSameSymbols(Cells.get(0), Cells.get(4), Cells.get(8)) || haveSameSymbols(Cells.get(2), Cells.get(4), Cells.get(6));
    }

    public void isFull() {
        if (!displayGrid().contains(" ")) {
            System.out.println("The grid is full and nobody won! Thanks for playing.");
            System.exit(0);
        }
    }
}
