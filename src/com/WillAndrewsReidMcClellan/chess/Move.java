package com.WillAndrewsReidMcClellan.chess;

public class Move
{
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Move(int startX, int startY, int endX, int endY)
    {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    // Getters
    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    // Additional methods or logic if needed
}