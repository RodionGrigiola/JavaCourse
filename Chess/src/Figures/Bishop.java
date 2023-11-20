package Figures;

public class Bishop extends Figure{
    public Bishop(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
       if (Math.abs(row - row1) == Math.abs(col - col1)) {
           int rowDirection = row < row1 ? 1 : -1;
           int colDirection = col < col1 ? 1 : -1;

           int nextRowMovePosition = row + rowDirection;
           int nextColMovePosition = col + colDirection;

           while(Math.abs(row1 - nextRowMovePosition) > 0 && Math.abs(col1 - nextColMovePosition) > 0) {
               if(fields[nextRowMovePosition][nextColMovePosition] != null) return false;
               nextRowMovePosition += rowDirection;
               nextColMovePosition += colDirection;
           }
           return true;
       }
        return false;
    }

}
