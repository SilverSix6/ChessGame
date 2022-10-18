import Exceptions.GameOverException;
import Pieces.*;

import java.util.Arrays;

public class ChessGame {

    Piece[][] board = new Piece[8][8];
    King WhiteKing;
    King BlackKing;

    int Number_Of_CheckMates = 0;

    public ChessGame(){
        constructNewChessBoard();
        printBoard();
    }

    private void printBoard() {
        for(Piece[] row: board){
            System.out.printf(Arrays.toString(row) + "\n");
        }
    }

    private void constructNewChessBoard() {
        //Row 0 Black Pieces
        board[0] = new Piece[]{new Rook(0,0, false),
                new Knight(0,1, false),
                new Bishop(0,2,false),
                new Queen(0, 3, false),
                new King(0,4,false),
                new Bishop(0,5,false),
                new Knight(0,6, false),
                new Rook(0,7, false)};

        //Row 1 Black Pawns
        for(int c = 0; c < 8; c++)
            board[1][c] = new Pawn(0, c, false);

        //Rows 2-5 are empty

        //Row 6 White Pawns
        for(int c = 0; c < 8; c++)
            board[6][c] = new Pawn(0, c, true);

        //Row 7 White Pieces
        board[7] = new Piece[]{new Rook(7,0, true),
                new Knight(7,1, true),
                new Bishop(7,2,true),
                new King(7,3,true),
                new Queen(7, 4, true),
                new Bishop(7,5,true),
                new Knight(7,6, true),
                new Rook(7,7, true)};

        WhiteKing = (King)board[7][3];
        BlackKing = (King)board[0][4];
    }

    public boolean isKingInCheck(boolean color) throws GameOverException {
        //Checks whether the inputted colour king is in check

        //Check over all possible valid moves
        //if there is a valid move that takes the king is in check
        King king;
        if(color){
            king = WhiteKing;
        } else
            king = BlackKing;

        king.setCheck(false);

        //Loop over all the pieces on the board
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                //If there is a valid move to the king and there is no other pieces blocking it
                if(board[x][y].validMove(king.getX(), king.getY(), board)&& !board[x][y].pieceInTheWay(king.getX(), king.getY(), board)){
                    //Then the king is in check
                    king.setCheck(true);
                }
            }
        }

        if(king.isCheck()){
            Number_Of_CheckMates++;
        } else {
            Number_Of_CheckMates = 0;
        }



        if(Number_Of_CheckMates >= 3)
            throw new GameOverException(!king.getColour());


        //if king is in check the king is the only piece that can move
        //must move to location that takes the king out of check


        return king.isCheck();
    }

    public boolean movePiece(int initialX, int initialY, int destinationX, int destinationY) throws GameOverException {
        //Check if the move is in the set of possible moves for said piece
        //Also checks if there is another piece in the way for longer moves

        //If your king is in check, and you are not moving your king than it is an invalid move
        if(isKingInCheck(board[initialX][initialY].getColour()) && !(board[initialX][initialY] instanceof King)){
            return false;
        }

        if(board[initialX][initialY].validMove(destinationX,destinationY, board)&& !board[initialX][initialY].pieceInTheWay(destinationX,destinationY, board)){
            board[destinationX][destinationY] = board[initialX][initialY];
            board[initialX][initialY] = null;
            board[initialX][initialY].setPosition(destinationX,destinationY);
            return true;
        }
        return false;
    }
}
