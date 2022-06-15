public class Cell {
    private String symbol;
    private boolean isOccupied;

    public Cell() {
        this.symbol = " ";
        this.isOccupied = false;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void useCell(String symbol) {
        assert (!this.isOccupied);
        this.isOccupied = true;
        this.symbol = symbol;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }
}
