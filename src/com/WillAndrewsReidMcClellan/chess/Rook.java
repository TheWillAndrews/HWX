package com.WillAndrewsReidMcClellan.chess;

public class Rook extends Piece
{
    //constructor
    public Rook(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if rook can move to a specified position
    @Override
    public boolean validMove(Board board, int startX, int startY, int endX, int endY)
    {
        if (startX != endX && startY != endY) return false; // Must move straight

        // Check for obstruction
        int direction = startX == endX ? Integer.compare(endY, startY) : Integer.compare(endX, startX);
        int max = startX == endX ? Math.abs(startY - endY) : Math.abs(startX - endX);
        for (int i = 1; i < max; i++) {
            if (startX == endX)
            {
                if (board.getPiece(startX, startY + i * direction) != null) return false;
            }
            else
            {
                if (board.getPiece(startX + i * direction, startY) != null) return false;
            }
        }
        return true;
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_r" + color + "t60.png";
    }
}
