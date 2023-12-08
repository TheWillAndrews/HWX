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
        //TODO: Implement queen-specific movement logic
        return false; //placeholder
    }
}
