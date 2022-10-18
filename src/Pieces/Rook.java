package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(int x, int y, boolean colour) {
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

        return validMoves;
    }

    @Override
    public String toString() {
        return "Rk " + (super.colour?"W":"B");
    }
}
