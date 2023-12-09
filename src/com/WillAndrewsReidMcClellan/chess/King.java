package com.WillAndrewsReidMcClellan.chess;

public class King extends Piece
{
    //constructor
    public King(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if king can move to a specified position
    @Override
    public boolean validMove(Board board, int startX, int startY, int endX, int endY)
    {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return (dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0);
        // Add castling logic later
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_k" + color + "t60.png";
    }
}
