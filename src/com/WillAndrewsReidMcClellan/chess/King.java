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
        //TODO: Implement king-specific movement logic
        return false; //placeholder
    }
}
