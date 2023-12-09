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

        //normal king move
        if ((dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0))
        {
            return true;
        }

        // Castling move
        return canCastle(board, startX, startY, endX, endY);
    }

    private boolean canCastle(Board board, int startX, int startY, int endX, int endY)
    {
        // Castling is only allowed if the king and the rook have not moved
        if (this.hasMoved)
        {
            return false;
        }
        // Ensure that the king is not currently in check
        if (board.isCheck(this.isWhite))
        {
            return false;
        }
        // Castling conditions
        // King's side castling (short castling)
        if (endX == startX && endY == startY + 2)
        {
            return checkRookForCastling(board, startX, startY, true);
        }
        // Queen's side castling (long castling)
        else if (endX == startX && endY == startY - 2)
        {
            return checkRookForCastling(board, startX, startY, false);
        }
        return false;
    }

    private boolean checkRookForCastling(Board board, int kingX, int kingY, boolean kingSide)
    {
        int rookY = kingSide ? 7 : 0;
        Piece rook = board.getPiece(kingX, rookY);

        if (!(rook instanceof Rook) || rook.hasMoved())
        {
            return false;
        }

        // Check if squares between king and rook are empty and not under attack
        int step = kingSide ? 1 : -1;
        for (int y = kingY + step; y != rookY; y += step)
        {
            if (board.getPiece(kingX, y) != null || squareUnderAttack(board, kingX, y))
            {
                return false;
            }
        }

        return true;
    }

    private boolean squareUnderAttack(Board board, int x, int y)
    {
        // You'll need to implement this method to check if a given square (x, y) is under attack
        // This involves checking if any of the opponent's pieces can move to (x, y)
    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_k" + color + "t60.png";
    }
}
