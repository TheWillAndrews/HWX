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
        //TODO: Implement knight-specific movement logic
        return false; //placeholder
    }
}
