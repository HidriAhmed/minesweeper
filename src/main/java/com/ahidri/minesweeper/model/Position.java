package com.ahidri.minesweeper.model;

/**
 * Created by ahidri on 13/01/15.
 */
public class Position {

    private int horizontalPos;
    private int verticalPos;

    public Position(int horizontalPos, int verticalPos) {

        this.horizontalPos = horizontalPos;
        this.verticalPos = verticalPos;
    }

    public int getHorizontalPos() {
        return horizontalPos;
    }

    public void setHorizontalPos(int horizontalPos) {
        this.horizontalPos = horizontalPos;
    }

    public int getVerticalPos() {
        return verticalPos;
    }

    public void setVerticalPos(int verticalPos) {
        this.verticalPos = verticalPos;
    }

    public boolean isInTheGrid(int gridLength, int gridWidth) {
        return !(this.getHorizontalPos() < 0 || this.getHorizontalPos() >= gridWidth || this.getVerticalPos() < 0 || this.getVerticalPos() >= gridLength);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return horizontalPos == position.horizontalPos && verticalPos == position.verticalPos;

    }

    @Override
    public int hashCode() {
        int result = horizontalPos;
        result = 31 * result + verticalPos;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "horizontalPos=" + horizontalPos +
                ", verticalPos=" + verticalPos +
                '}';
    }
}
