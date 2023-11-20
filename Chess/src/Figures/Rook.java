package Figures;

public class Rook extends Figure {
    public Rook(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if (row == row1 || col == col1) {
            int rowDirection = Integer.compare(row1, row);
            int colDirection = Integer.compare(col1, col);

            int nextRowMovePosition = row + rowDirection;
            while(rowDirection != 0 && Math.abs(row1 - nextRowMovePosition) > 0) {
                if(fields[nextRowMovePosition][col] != null) return false;
                nextRowMovePosition += rowDirection;
            }

            int nextColMovePosition = col + colDirection;
            while(colDirection != 0 && Math.abs(col1 - nextColMovePosition) > 0) {
                if(fields[row][nextColMovePosition] != null) return false;
                nextColMovePosition += colDirection;
            }

            return true;
        }
        return false;
    }
}
