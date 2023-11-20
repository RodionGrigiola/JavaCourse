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

        Figure secondFigure = this.fields[row2][col2];
        if (secondFigure == null && firstFigure.canMove(row1, col1, row2, col2, this.fields)){
            System.out.println("move");
            this.fields[row2][col2] = firstFigure;
            this.fields[row1][col1] = null;
            return true;
        }
        else if (secondFigure != null && firstFigure.canAttack(row1, col1, row2, col2, this.fields)){
            System.out.println("attack");
           switch (secondFigure.getColor()){
                case 'w': this.takeWhite.add(secondFigure.getColor() + secondFigure.getName());break;
                case 'b': this.takeBlack.add(secondFigure.getColor() + secondFigure.getName());break;
           }
           this.fields[row2][col2] = firstFigure;
           this.fields[row1][col1] = null;
           return true;
        }
        return false;
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


}
