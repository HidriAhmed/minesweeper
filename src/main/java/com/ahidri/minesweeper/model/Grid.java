package com.ahidri.minesweeper.model;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahidri on 03/02/15.
 */
public class Grid {

    private final int length;
    private final int width;

    private int[][]values;

    public Grid(int length, int width) {
        this.length = length;
        this.width = width;
        values = new int[length][width];
    }

    public boolean isMine(Position position){
        return getPositionValue(position) == -1;
    }

    public int getPositionValue(Position position){
            return this.values[position.getVerticalPos()][position.getHorizontalPos()];
    }

    public void addMine(Position position){
        this.values[position.getVerticalPos()][position.getHorizontalPos()] = -1;
    }

    public void updateAdjacentOfMine(Position position){
        this.values[position.getVerticalPos()][position.getHorizontalPos()]++;
    }

    public List<Position> getAdjacents(Position position){
        int posX = position.getHorizontalPos();
        int posY = position.getVerticalPos();
        Position topLeft = new Position(posX - 1, posY - 1);
        Position topMiddle = new Position(posX, posY - 1);
        Position topRight = new Position(posX + 1, posY - 1);
        Position centerLeft = new Position(posX - 1, posY);
        Position centerRight = new Position(posX + 1, posY);
        Position bottomLeft = new Position(posX - 1, posY + 1);
        Position bottomMiddle = new Position(posX, posY + 1);
        Position bottomRight = new Position(posX +1, posY + 1);
        return filterValidAdjacentToList(topLeft, topMiddle, topRight,
                centerLeft, centerRight, bottomLeft, bottomMiddle, bottomRight);

    }

    public List<Position> filterValidAdjacentToList(Position... positions) {
        List<Position> validAdjacents = new ArrayList<>();
        for (Position position : positions) {
            if (position.isInTheGrid(this.length, this.width)) {
                validAdjacents.add(position);
            }
        }
        return validAdjacents;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
