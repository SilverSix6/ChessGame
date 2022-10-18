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
    public boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board) {
        Point deltaXY = getDeltaPosition(destinationX,destinationY);

        if(deltaXY.x > 0 && deltaXY.y > 0 ){
            for(int c = 1; c < deltaXY.x; c++){
                if(board[c][c] != null)
                    return true;
            }
        }
        if(deltaXY.x > 0 && deltaXY.y < 0 ){
            for(int c = 1; c < deltaXY.x; c++){
                if(board[c][-c] != null)
                    return true;
            }
        }
        if(deltaXY.x < 0 && deltaXY.y > 0 ){
            for(int c = -1; c > deltaXY.x; c--)
                if(board[c][-c] != null)
                    return true;
        }
        if(deltaXY.x < 0 && deltaXY.y < 0 ){
            for(int c = -1; c > deltaXY.x; c--)
                if(board[c][c] != null)
                    return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bi " + (super.colour?"W":"B");
    }
}
