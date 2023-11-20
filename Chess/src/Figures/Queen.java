package Figures;

public class Queen extends Figure{
    public Queen(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if((row == row1 && col != col1) ||(row != row1 && col == col1) || (Math.abs(row - row1) == Math.abs(col-col1)) ){
            int rowDirection = Integer.compare(row1, row);
            int colDirection = Integer.compare(col1, col);

            int nextRowMovePosition = row + rowDirection;
            int nextColMovePosition = col + colDirection;

            while(Math.abs(col1 - nextColMovePosition) > 0 || Math.abs(row1 - nextRowMovePosition) > 0) {
                if(fields[nextRowMovePosition][nextColMovePosition] != null) return false;
                nextRowMovePosition += rowDirection;
                nextColMovePosition += colDirection;
            }
            return true;
        }
        return false;
    }
}
