package com.WillAndrewsReidMcClellan.chess;

public class Knight extends Piece
{
    //constructor
    public Knight(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if knight can move to a specified position
    @Override
    public boolean validMove(Board board, int startX, int startY, int endX, int endY)
    {
        // Check if the destination is within the board boundaries
        if (endX < 0 || endX >= 8 || endY < 0 || endY >= 8)
        {
            return false;
        }

        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);

        // Check if the move follows the L-shaped pattern
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2)))
        {
            return false;
        }

        Piece destinationPiece = board.getPiece(endX, endY);

        // Check if the destination square is occupied by a piece of the same color
        if (destinationPiece != null && destinationPiece.isWhite() == this.isWhite())
        {
            return false;
        }

        return true;
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_n" + color + "t60.png";
    }
}
