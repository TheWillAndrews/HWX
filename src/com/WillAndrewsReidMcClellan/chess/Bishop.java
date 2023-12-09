package com.WillAndrewsReidMcClellan.chess;

public class Bishop extends Piece
{
    //constructor
    public Bishop(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if bishop can move to a specified position
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
        if (dx != dy) return false; // Must move diagonally

        int xDirection = Integer.compare(endX, startX);
        int yDirection = Integer.compare(endY, startY);
        for (int i = 1; i < dx; i++)
        {
            int x = startX + i * xDirection;
            int y = startY + i * yDirection;
            Piece piece = board.getPiece(x, y);
            if (piece != null)
            {
                if (i != dx - 1 || piece.isWhite() == this.isWhite())
                {
                    // Block move if there's a piece on the path or the destination has own piece
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_b" + color + "t60.png";
    }
}
