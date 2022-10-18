import Pieces.*;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class ChessGame {

    Piece[][] board = new Piece[8][8];

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
    }

    public boolean movePiece(int initialX, int initialY, int destinationX, int destinationY){
        //Check if the move is in the set of possible moves for said piece
        //Also checks if there is another piece in the way for longer moves
        if(board[initialX][initialY].validMove(destinationX,destinationY, board)&& !board[initialX][initialY].pieceInTheWay(destinationX,destinationY, board)){
            board[destinationX][destinationY] = board[initialX][initialY];
            board[initialX][initialY] = null;
            board[initialX][initialY].setPosition(destinationX,destinationY);
            return true;
        }
        return false;
    }
}
