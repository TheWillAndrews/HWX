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
        // Check for forward movement
        if (startX == endX) {
            if (board.getPiece(endX, endY) != null) {
                return false; // Can't move forward into a square that's occupied
            }

            if (isWhite()) {
                if (startY == 1 && (endY == startY + 1 || endY == startY + 2)) {
                    return true; // White pawn first move
                } else {
                    return endY == startY + 1; // White pawn regular move
                }
            } else {
                if (startY == 6 && (endY == startY - 1 || endY == startY - 2)) {
                    return true; // Black pawn first move
                } else {
                    return endY == startY - 1; // Black pawn regular move
                }
            }
        }

        // Check for diagonal capturing
        if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
            Piece targetPiece = board.getPiece(endX, endY);
            return targetPiece != null && targetPiece.isWhite() != this.isWhite();
        }

        return false;
        /*
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
         */

    }

    @Override
    public String getImagePath()
    {
        String color = isWhite ? "l" : "d";
        return "/com/WillAndrewsReidMcClellan/chess/PieceImages/Chess_p" + color + "t60.png";
    }
}