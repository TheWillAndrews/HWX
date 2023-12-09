package com.WillAndrewsReidMcClellan.chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI
{
    private Board board;
    private boolean whiteTurn;
    private JFrame frame;
    private JPanel chessboardPanel;
    private JButton[][] chessboardButtons = new JButton[8][8];
    private Piece selectedPiece;
    private int selectedRow = -1;
    private int selectedCol = -1;
    Color lightColor = new Color(240, 217, 181); // Light square color
    Color darkColor = new Color(181, 136, 99);   // Dark square color

    // Initializes a new game with GUI
    public GameGUI()
    {
        board = new Board();
        whiteTurn = true; // White always goes first
        initializeGUI();
    }

    // Initialize the GUI components
    private void initializeGUI()
    {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        chessboardPanel = createChessboardPanel();
        frame.add(chessboardPanel, BorderLayout.CENTER);
        frame.validate();
        frame.repaint();
        updateGUI(); // Initial call to set up the board
        frame.setVisible(true);
    }

    // Creates and returns the chessboard panel
    private JPanel createChessboardPanel()
    {
        JPanel panel = new JPanel(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                JButton button = new JButton();
                chessboardButtons[row][col] = button;

                // Set the background color based on the square's position
                if ((row + col) % 2 == 0)
                {
                    button.setBackground(lightColor);
                }
                else
                {
                    button.setBackground(darkColor);
                }

                button.setOpaque(true);
                button.setBorderPainted(false);

                final int finalRow = row;
                final int finalCol = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        handleButtonClick(finalRow, finalCol);
                    }
                });
                panel.add(button);
            }
        }
        return panel;
    }

    // Update GUI to reflect the current state of the board
    private void updateGUI()
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                Piece piece = board.getPiece(row, col);
                JButton button = chessboardButtons[row][col];
                if (piece != null)
                {
                    // Use an ImageIcon to display the piece on the button
                    ImageIcon icon = new ImageIcon(getClass().getResource(piece.getImagePath()));
                    button.setIcon(icon);
                }
                else
                {
                    button.setIcon(null);
                }
            }
        }
        // Additional GUI updates can be done here (turn indicator, status messages, etc.)
    }

    // Handles button click on the chessboard
    private void handleButtonClick(int row, int col)
    {
        if(selectedPiece == null && board.getPiece(row, col) != null && board.getPiece(row, col).isWhite() == whiteTurn)
        {
            // Clear existing highlights when a new piece is selected
            clearHighlights();

            // Select the piece if it belongs to the current player
            selectedPiece = board.getPiece(row, col);
            selectedRow = row;
            selectedCol = col;
            highlightPossibleMoves(selectedPiece, row, col); // GUI method to show possible moves
        }
        else if(selectedPiece != null)
        {
            // Try to move the piece
            if(selectedPiece.validMove(board, selectedRow, selectedCol, row, col))
            {
                board.movePiece(selectedRow, selectedCol, row, col); // Update the board state
                updateGUI(); // Refresh the GUI to reflect the new board state
                switchTurns(); // Change the turn
            }
            else
            {
                displayInvalidMoveMessage(); // GUI method to inform the user
            }
            // Clear highlights and reset selection regardless of whether the move was valid
            clearHighlights();
            selectedPiece = null;
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    private void switchTurns()
    {
        whiteTurn = !whiteTurn;
        // Update the turn indicator on the GUI
    }

    private void clearHighlights()
    {
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                if ((r + c) % 2 == 0)
                {
                    chessboardButtons[r][c].setBackground(lightColor); // Light square color
                }
                else
                {
                    chessboardButtons[r][c].setBackground(darkColor); // Dark square color
                }
            }
        }
    }

    private void highlightPossibleMoves(Piece piece, int row, int col)
    {
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                if (piece.validMove(board, row, col, r, c))
                {
                    chessboardButtons[r][c].setBackground(Color.YELLOW); // Example highlighting
                }
            }
        }
    }

    private void displayInvalidMoveMessage()
    {
        // Display a message dialog or some other indicator that the move was invalid
        JOptionPane.showMessageDialog(frame, "Invalid move, try again.", "Invalid Move", JOptionPane.ERROR_MESSAGE);
    }

    // Additional methods to check for checkmate and stalemate
    // These would be called within switchTurns or after a move is made to determine game end conditions
}


