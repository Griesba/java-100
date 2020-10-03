package pack.java9.by.exemple.mastermind;

public class Game {
    final Table table;
    final private Row secretRow;
    boolean finished = false;
    final int nrOfColumns;

    public Game(Table table, Color[] secret) {
        this.table = table;
        this.secretRow = new Row(secret);
        this.nrOfColumns = secretRow.nrOfColumns();
    }

    private boolean itWasAWinningGuess(int positionMatch) {
        return positionMatch == nrOfColumns;
    }

    public void addNewGuess(Row row) {
        if (isFinished()) {
            throw new IllegalArgumentException("You can not guess on a finished game.");
        }
        final int positionMatch = secretRow.nrMatchingPositions(row.positions);
        final int colorMatch = secretRow.nrMatchingColors(row.positions);
        row.setMatch(positionMatch, colorMatch);
        table.addRow(row);
        if (itWasAWinningGuess(positionMatch)) {
            finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }

}
