package com.WillAndrewsReidMcClellan.chess;

public class Pawn extends Piece
{
    //constructor
    public Pawn(boolean isWhite)
    {
        super(isWhite);
    }

    //checks if pawn can move to a specified position
    @Override
    public boolean validMove(Board board, int startX, int startY, int endX, int endY)
    {
        //pawns can move only forward one square, with two options on its first move
        //pawns can capture only diagonally forward
        if (startX == endX && board.getPiece(endX, endY) == null)
        {
            if (this.isWhite() && startY == 1 && endY - startY <= 2) return true;
            if (!this.isWhite() && startY == 6 && startY - endY <= 2) return true;
            return Math.abs(startY - endY) == 1;
        }
        else if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1)
        {
            return board.getPiece(endX, endY) != null && board.getPiece(endX, endY).isWhite() != this.isWhite();
        }
        return false;
    }
}