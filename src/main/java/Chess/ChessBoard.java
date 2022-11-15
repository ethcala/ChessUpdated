package Chess;

import Chess.Pieces.*;

import java.util.ArrayList;

public class ChessBoard {
    private final Tile[][] board;

    public ChessBoard(){
        board = new Tile[8][8];
        initializeBoard();
    }

    public Tile[][] getBoardArray(){
        return board;
    }

    private void initializeBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                if (j % 2 + i == 0) board[i][j] = new Tile(Tile.TileColor.Black);
                else board[i][j] = new Tile(Tile.TileColor.White);
            }
        }
    }

    //Will break on boards with no Kings of 'color'. Should never happen.
    public Tuple getKingLocation(ChessPiece.PieceColor color){
        Tuple location = new Tuple(-1,-1);
        for (int x = 0; x <= 7; x++){
            for (int y = 0; y <= 7 ; y++){
                if (!board[y][x].isEmpty()) {
                    ChessPiece piece = board[y][x].getPiece();
                    if (piece.getColor() == color && piece instanceof King){
                       location = new Tuple(x, y);
                    }
                }
            }
        }
        return location;
    }

    public Tuple[] getAllPiecesLocationForColor(ChessPiece.PieceColor color){
        ArrayList<Tuple> locations = new ArrayList<>();
        for (int x = 0; x <= 7; x++){
            for (int y = 0; y <= 7; y++){
               if(!board[y][x].isEmpty() && board[y][x].getPiece().getColor() == color)
                   locations.add(new Tuple(x,y));
            }
        }
        return locations.toArray(new Tuple[0]);//allocate new array automatically.
    }

    public Tile getTileFromTuple(Tuple tuple){
        try {
            return board[tuple.Y()][tuple.X()];
        } catch (ArrayIndexOutOfBoundsException exc) {
            return board[0][0];
        }
    }
}
