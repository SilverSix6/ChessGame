package Pieces;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {
    private int x, y;
    private boolean firstMove = true;
    private static int numOfPieces = 0;
    private int pieceID;
    private ArrayList<Point> validMoves = new ArrayList<>();

    //The color of the piece:
    //True is white
    //False is black
    boolean colour;

    public Piece(int x, int y, boolean colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
        pieceID = numOfPieces;
        numOfPieces++;
    }

    public void setValidMoves(ArrayList<Point> validMoves) {
        this.validMoves = validMoves;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean getColour() {
        return colour;
    }

    public boolean validMove(int xDestination, int yDestination, Piece[][] board) {
        int deltaX = xDestination - getX();
        int deltaY = yDestination - getY();

        //Negates the deltaX if the piece is black
        //Basically rotates board 180 degrees
        if(!colour){
            deltaX = -deltaX;
            deltaY = -deltaY;
        }


        //Add more moves if there is pieces on the pawns diagonal
        if(this instanceof Pawn){
            if(board[x+1][y+1] != null)
                validMoves.add(new Point(1,1));
            if(board[x+1][y+1] != null)
                validMoves.add(new Point(1,-1));
        }



        //Is the move part of the set of possible moves for the piece and still on the board?
        if(validMoves().contains(new Point(deltaX, deltaY)) && this.x + deltaX >= 0 && this.x + deltaX < 8 && this.y + deltaY >= 0 && this.y + deltaY < 8)
            return true;
        return false;
    }

    public ArrayList<Point> validMoves(){
        return validMoves;
    }
    public abstract ArrayList<Point> generateValidMoves();

    public abstract boolean pieceInTheWay(int destinationX, int destinationY, Piece[][] board);

    @Override
    public abstract String toString();
}
