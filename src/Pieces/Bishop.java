package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(int x, int y, boolean colour) {
        super(x, y, colour);
        setValidMoves(generateValidMoves());
    }

    @Override
    public ArrayList<Point> generateValidMoves() {
        ArrayList<Point> validMoves = new ArrayList<>();

        //SouthWest to NorthEast diagonal
        for(int c = -7; c < 8; c++)
            validMoves.add(new Point(c,c));

        //NorthWest to SouthEast diagonal
        for(int c = -7; c < 8; c++)
            validMoves.add(new Point(c,-c));

        return validMoves;
    }

    @Override
    public String toString() {
        return "Bi " + (super.colour?"W":"B");
    }
}
