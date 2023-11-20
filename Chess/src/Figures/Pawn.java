package Figures;

public class Pawn extends Figure {

    private boolean isFirstStep = true;

    public Pawn(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if (col != col1) return false;
        if (this.isFirstStep) {
            if ((Math.abs(row1 - row) == 2 || Math.abs(row1 - row) == 1)) {
                this.isFirstStep = false;
                return true;
            }
        }
        return Math.abs(row1 - row) == 1 && fields[row1][col1] == null;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, Figure[][] fields) {
        return Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1 && fields[row1][col1].getColor() != this.getColor();
    }
}
