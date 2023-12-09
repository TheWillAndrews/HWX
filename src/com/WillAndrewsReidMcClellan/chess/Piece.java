/*
Name: Will Andrews
Date: 11/27/2023
Section: COP3252
Assignment: HWX
Due Date: 12/07/2023
About this project: We are asked to work with a partner and write a program to a board game of
our choice, ours being Chess. The program implements a user-friendly GUI and adheres to the all
the rules of a standard chess game.
About this file: Contains the abstract 'Piece' class for our varying subclass chess pieces
Assumptions: NA
All work below was performed by Will Andrews and Reid McClellan
*/

package com.WillAndrewsReidMcClellan.chess;

public abstract class Piece
{
    protected boolean isWhite;
    protected boolean hasMoved; // Track if the piece has moved (useful for pawns, kings, and rooks)

    //constructor for a chess piece
    public Piece(boolean isWhite)
    {
        this.isWhite = isWhite;
        this.hasMoved = false;
    }

    //checks whether the piece is white or not, and returns answer as a boolean value
    public boolean isWhite()
    {
        return isWhite;
    }

    //abstract method to check if a piece can move to a certain position
    public abstract boolean validMove(Board board, int startX, int startY, int endX, int endY);
    public abstract String getImagePath();

    // Method to be called when the piece moves
    public void move(int startX, int startY, int endX, int endY) {
        this.hasMoved = true;
        // Additional logic if needed for specific pieces
    }

    // Method to check if the piece has moved (useful for pawns' first move, castling, etc.)
    public boolean hasMoved() {
        return hasMoved;
    }

    // Additional common methods for chess pieces
}
