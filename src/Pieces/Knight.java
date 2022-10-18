package Pieces;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(int x, int y, boolean colour) {
        super(x, y, colour);
    }

    @Override
    public ArrayList<Point> generateValidMoves() {
        ArrayList<Point> validMoves = new ArrayList<>();

        validMoves.add(new Point(-2, 1));
        validMoves.add(new Point(-2, -1));
        validMoves.add(new Point(-1, 2));
        validMoves.add(new Point(-1, -2));
        validMoves.add(new Point(1, 2));
        validMoves.add(new Point(2, 1));
        validMoves.add(new Point(2, -1));
        validMoves.add(new Point(1, -2));

        return null;
    }

    @Override
    public boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board) {
        return false;
    }

    @Override
    public String toString() {
        return "Kn " + (super.colour?"W":"B");
    }
}
