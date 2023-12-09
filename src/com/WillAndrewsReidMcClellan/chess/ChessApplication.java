package com.WillAndrewsReidMcClellan.chess;

import javax.swing.*;

public class ChessApplication
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new GameGUI(); // Set up the game in the Event Dispatch Thread
            }
        });
    }
}
