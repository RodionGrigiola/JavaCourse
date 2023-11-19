package Figures;

public class Rook extends Figure{
    public Rook(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if (row == row1 || col == col1){
            int rowDirection = Integer.compare(row, row1);
            int colDirection = Integer.compare(col, col1);

            int nextRowMovePosition = row + rowDirection;
            while(Math.abs(row1 - nextRowMovePosition) > 0) {
                if(fields[nextRowMovePosition][col] != null) return false;
            }

            int nextColMovePosition = col + colDirection;
            while(Math.abs(row1 - nextColMovePosition) > 0) {
                if(fields[nextColMovePosition][col] != null) return false;
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, Figure[][] fields) {
        return this.canMove(row, col, row1, col1, fields);
    }
}
