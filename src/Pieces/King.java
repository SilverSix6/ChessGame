package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    public King(int x, int y, boolean colour) {
        super(x, y, colour);
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
    public String toString() {
        return "Ki " + (super.colour?"W":"B");
    }
}
