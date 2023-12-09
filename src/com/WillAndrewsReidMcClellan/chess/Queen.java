package com.WillAndrewsReidMcClellan.chess;

public class Queen extends Piece
{
    //constructor
    public Queen(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if queen can move to a specified position
    @Override
    public boolean validMove(Board board, int startX, int startY, int endX, int endY)
    {
        // Combine logic of Rook and Bishop
        Rook tempRook = new Rook(isWhite);
        Bishop tempBishop = new Bishop(isWhite);
        return tempRook.validMove(board, startX, startY, endX, endY) || tempBishop.validMove(board, startX, startY, endX, endY);
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_q" + color + "t60.png";
    }
}
