/*
Name: Will Andrews
Date: 11/27/2023
Section: COP3252
Assignment: HWX
Due Date: 12/07/2023
About this project: We are asked to work with a partner and write a program to a board game of
our choice, ours being Chess. The program implements a user-friendly GUI and adheres to the all
the rules of a standard chess game.
About this file: Contains the 'Board' class that handles the interface and functionality of our
chessboard.
Assumptions: NA
All work below was performed by Will Andrews and Reid McClellan
*/

package com.WillAndrewsReidMcClellan.chess;

public class Board
{
    private Piece[][] board;

    public Board()
    {
        //setting up the board with pieces in starting positions
        board = new Piece[8][8];
        initializeBoard();
    }

    //initializes board and sets up pieces in their initial positions
    private void initializeBoard()
    {
        //setting up white pieces
        board[0][0] = new Rook(true);    //white rook
        board[0][1] = new Knight(true);  //white knight
        board[0][2] = new Bishop(true);  //white bishop
        board[0][3] = new Queen(true);   //white queen
        board[0][4] = new King(true);    //white king
        board[0][5] = new Bishop(true);  //white bishop
        board[0][6] = new Knight(true);  //white knight
        board[0][7] = new Rook(true);    //white rook

        //setting up black pieces
        board[7][0] = new Rook(false);   //black rook
        board[7][1] = new Knight(false); //black knight
        board[7][2] = new Bishop(false); //black bishop
        board[7][3] = new Queen(false);  //black queen
        board[7][4] = new King(false);   //black king
        board[7][5] = new Bishop(false); //black bishop
        board[7][6] = new Knight(false); //black knight
        board[7][7] = new Rook(false);   //black rook

        //loop to set up pawns
        for (int i = 0; i < 8; i++)
        {
            board[1][i] = new Pawn(true);  //white pawns
            board[6][i] = new Pawn(false); //black pawns
        }
    }

    //retrieves a piece from a specific board position
    public Piece getPiece(int x, int y)
    {
        return board[x][y];
    }

    // Additional methods like movePiece, checkStatus, etc.
}
