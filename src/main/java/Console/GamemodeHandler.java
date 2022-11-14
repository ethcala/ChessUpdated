package Console;

import Chess.ChessBoard;
import Chess.ChessPiece;
import Chess.Pieces.*;

public class GamemodeHandler {
    public void SetUpRegularGame(ChessBoard board) {
        //pawns
        for(int i = 0; i < 8; i++){
            board.getBoardArray()[1][i].setPiece(new Pawn(ChessPiece.PieceColor.Black));
            board.getBoardArray()[6][i].setPiece(new Pawn(ChessPiece.PieceColor.White));
        }

        //rooks
        board.getBoardArray()[0][0].setPiece(new Rook(ChessPiece.PieceColor.Black));
        board.getBoardArray()[0][7].setPiece(new Rook(ChessPiece.PieceColor.Black));
        board.getBoardArray()[7][0].setPiece(new Rook(ChessPiece.PieceColor.White));
        board.getBoardArray()[7][7].setPiece(new Rook(ChessPiece.PieceColor.White));

        //knight
        board.getBoardArray()[0][1].setPiece(new Knight(ChessPiece.PieceColor.Black));
        board.getBoardArray()[0][6].setPiece(new Knight(ChessPiece.PieceColor.Black));
        board.getBoardArray()[7][1].setPiece(new Knight(ChessPiece.PieceColor.White));
        board.getBoardArray()[7][6].setPiece(new Knight(ChessPiece.PieceColor.White));

        //bishop
        board.getBoardArray()[0][2].setPiece(new Bishop(ChessPiece.PieceColor.Black));
        board.getBoardArray()[0][5].setPiece(new Bishop(ChessPiece.PieceColor.Black));
        board.getBoardArray()[7][2].setPiece(new Bishop(ChessPiece.PieceColor.White));
        board.getBoardArray()[7][5].setPiece(new Bishop(ChessPiece.PieceColor.White));

        //queens
        board.getBoardArray()[0][3].setPiece(new Queen(ChessPiece.PieceColor.Black));
        board.getBoardArray()[7][3].setPiece(new Queen(ChessPiece.PieceColor.White));

        //kings
        board.getBoardArray()[0][4].setPiece(new King(ChessPiece.PieceColor.Black));
        board.getBoardArray()[7][4].setPiece(new King(ChessPiece.PieceColor.White));
    }
}
