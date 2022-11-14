package Console;

import Chess.ChessBoard;
import Chess.ChessPiece;
import Chess.Pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void SetUp960Game(ChessBoard board) {
        //pawns
        for(int i = 0; i < 8; i++){
            board.getBoardArray()[1][i].setPiece(new Pawn(ChessPiece.PieceColor.Black));
            board.getBoardArray()[6][i].setPiece(new Pawn(ChessPiece.PieceColor.White));
        }
        generateRank();
        for(int i = 0; i < 8; i++){

            board.getBoardArray()[0][i].setPiece((ChessPiece) whitePieces.get(i));
            List<Object> blackPieces = new ArrayList<Object>(whitePieces);
            Collections.copy(blackPieces, whitePieces);
            board.getBoardArray()[7][i].setPiece((ChessPiece) blackPieces.get(i));
        }
    }

    private static List<Object> whitePieces = Arrays.asList(new Rook(ChessPiece.PieceColor.White),new Knight(ChessPiece.PieceColor.White),new Bishop(ChessPiece.PieceColor.White),new Queen(ChessPiece.PieceColor.White),new King(ChessPiece.PieceColor.White),new Bishop(ChessPiece.PieceColor.White),new Knight(ChessPiece.PieceColor.White),new Rook(ChessPiece.PieceColor.White));



    public static List<Object> generateRank(){
        do{
            Collections.shuffle(whitePieces);
            System.out.println(whitePieces);
        }while(!check(whitePieces.toString().replaceAll("[^\\p{Upper}]", ""))); //List.toString adds some human stuff, remove that
        return whitePieces;
    }


    private static boolean check(String rank){
        if(!rank.matches(".*R.*K.*R.*")) return false;			//king between rooks
        if(!rank.matches(".*B(..|....|......|)B.*")) return false;	//all possible ways bishops can be placed
        return true;
    }
}
