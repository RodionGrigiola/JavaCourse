import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
    final private Figure[][]  fields = new Figure[8][8];
    final private ArrayList<String> takeWhite = new ArrayList<String>(16);
    final private ArrayList<String> takeBlack = new ArrayList<String>(16);

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public boolean move_figure(int row1, int col1, int row2, int col2 ){

        Figure firstFigure = this.fields[row1][col1];
        if(firstFigure == null) {
            System.out.println("Выбранное поле пусто! Выберите поле с фигурой");
            return false;
        }

        if(firstFigure.getColor() != getColorGaming()) {
            System.out.println("Эта фигура вам не принадлежит, своими ходите");
            return false;
        }

        Figure secondFigure = this.fields[row2][col2];

        if (secondFigure == null && firstFigure.canMove(row1, col1, row2, col2, this.fields)){
            move(row1, col1, row2, col2, fields);
            return true;
        }
        else if (secondFigure != null && firstFigure.canAttack(row1, col1, row2, col2, this.fields)){
           attack(row1, col1, row2, col2, this.fields);
           return true;
        }
        return false;
    }

    private boolean check(int kingRow, int kingCol, Figure[][] fields) {
        for (int currentRow = 0; currentRow < 8; currentRow++) {
            for (int currentCol = 0; currentCol < 8; currentCol++) {

                if (fields[currentRow][currentCol].getColor() == fields[kingRow][kingCol].getColor()
                        || fields[currentRow][currentCol] == null) continue;

                if (fields[currentRow][currentCol].canAttack(currentRow, currentCol, kingRow, kingCol, fields))
                    return true;
            }
        }
        return false;
    }

    private boolean mate(int row, int col, int kingRow, int kingCol, Figure[][] fields) {
        // 1) Проверка на то можно ли уйти из под шаха и избежать мата
        for (int availableRowCoef = -1; availableRowCoef < 2; availableRowCoef++ ) {
            for (int availableColCoef = -1; availableColCoef < 2; availableColCoef++) {

                if (kingRow + availableRowCoef > 7 || kingRow + availableRowCoef < 0
                        || kingCol + availableColCoef > 7 || kingCol + availableColCoef < 0
                        || (availableRowCoef == 0 && availableColCoef == 0)) continue;

                if(fields[kingRow + availableRowCoef][kingCol + availableColCoef] == null
                        && !check(kingRow + availableRowCoef, kingCol + availableColCoef, fields))
                    return false;
            }
        }

        // 2) Проверка на возможность защитить короля от шаха и избежать мата
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure figure = this.fields[i][j];
                if (figure == null || figure.getColor() != fields[kingRow][kingCol].getColor()) continue;
                if (figure.getName().equals("K") && check(row, col, fields)) continue;
                if (figure.canAttack(i, j, row, col, fields)) return false;
            }
        }
        return true;
    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
             }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }


    }

    private void move(int row1, int col1, int row2, int col2, Figure[][] fields) {
        System.out.println("move");
        fields[row2][col2] = fields[row1][col1];
        fields[row1][col1] = null;
    }

    private void attack(int row1, int col1, int row2, int col2, Figure[][] fields) {
        System.out.println("attack");
        switch (fields[row2][col2].getColor()){
            case 'w': this.takeWhite.add(fields[row2][col2].getColor() + fields[row2][col2].getName());break;
            case 'b': this.takeBlack.add(fields[row2][col2].getColor() + fields[row2][col2].getName());break;
        }
        fields[row2][col2] = fields[row1][col1];
        fields[row1][col1] = null;
    }

}
