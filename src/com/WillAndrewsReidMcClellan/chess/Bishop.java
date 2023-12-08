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
        //TODO: Implement bishop-specific movement logic
        return false; //placeholder
    }
}
