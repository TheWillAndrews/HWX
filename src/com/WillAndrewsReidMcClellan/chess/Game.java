package com.WillAndrewsReidMcClellan.chess;

public class Game
{
    private Board board;
    private boolean whiteTurn;

    //initializes a new game
    public Game()
    {
        board = new Board();
        whiteTurn = true; //white always goes first
    }

    //starts game loop
    public void startGame()
    {
        // Game loop and logic
        // Example: while (!gameOver) { ... }
    }

    // Additional methods like checkMate, switchTurn, etc.
}
