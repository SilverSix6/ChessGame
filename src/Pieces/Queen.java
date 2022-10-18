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

    //Check whether there is a piece between the source and destination positions
    @Override
    public boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board) {
        Point deltaXY = getDeltaPosition(destinationX,destinationY);

        //iterate over the pieces between source and destination
        //if it runs into a piece then there is a piece in the way, return true
        //if it does not, return false


        //Horizontal/Vertical
        if(deltaXY.x == 0){
            if(deltaXY.y > 0){
                for(int c = 1; c < deltaXY.y; c++)
                    if(board[0][c] != null)
                        return true;
            } else{
                for(int c = -1; c > deltaXY.y; c--)
                    if(board[0][c] != null)
                        return true;
            }
        }

        if(deltaXY.y == 0){
            if(deltaXY.x > 0){
                for(int c = 1; c < deltaXY.x; c++)
                    if(board[0][c] != null)
                        return true;
            } else{
                for(int c = -1; c > deltaXY.x; c--)
                    if(board[0][c] != null)
                        return true;
            }
        }

        //Diagonals
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
        return "Qn " + (super.colour?"W":"B");
    }
}
