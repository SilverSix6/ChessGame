package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(int x, int y, boolean colour) {
        super(x, y, colour);
    }


    @Override
    public ArrayList<Point> generateValidMoves() {
        ArrayList<Point> validPoints = new ArrayList<>();
        validPoints.add(new Point(1,0));

        if(isFirstMove())
            validPoints.add(new Point(2,0));

        return validPoints;
    }

    @Override
    public boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board) {
        return false;
    }


    @Override
    public String toString() {
        return "Pn " + (super.colour?"W":"B");
    }
}
