package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(int x, int y, boolean colour) {
        super(x, y, colour);
        setValidMoves(generateValidMoves());
    }

    @Override
    public ArrayList<Point> generateValidMoves() {
        ArrayList<Point> validMoves = new ArrayList<>();

        //North / South
        for(int c = -7; c < 8; c++)
            validMoves.add(new Point(c,0));

        //East / West (Vertical Movements)
        for(int c = -7; c < 8; c++)
            validMoves.add(new Point(c,0));

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
        return "Qn " + (super.colour?"W":"B");
    }
}
