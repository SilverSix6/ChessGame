package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    boolean Check = false;

    public King(int x, int y, boolean colour) {
        super(x, y, colour);
    }

    public boolean isCheck() {
        return Check;
    }

    public void setCheck(boolean check) {
        Check = check;
    }

    @Override
    public ArrayList<Point> generateValidMoves() {
        ArrayList<Point> validMoves = new ArrayList<>();

        //Plus
        validMoves.add(new Point(1,0));
        validMoves.add(new Point(-1,0));
        validMoves.add(new Point(0,1));
        validMoves.add(new Point(0,-1));

        //Corners
        validMoves.add(new Point(1,1));
        validMoves.add(new Point(1,-1));
        validMoves.add(new Point(-1,1));
        validMoves.add(new Point(-1,-1));

        return validMoves;
    }

    @Override
    public boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board) {
        return false;
    }


    @Override
    public String toString() {
        return "Ki " + (super.colour?"W":"B");
    }
}
