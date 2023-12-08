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
        //TODO: Implement rook-specific movement logic
        return false; //placeholder
    }
}
