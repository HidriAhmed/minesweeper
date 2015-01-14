package com.ahidri.minesweeper.buisness;


import com.ahidri.minesweeper.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ahidri on 12/01/15.
 */
public class MineSweeperInitializer {


     private int[][] createEmptyGrid(int length, int width) {
        int[][] grid = new int[length][width];
        for(int i= 0 ; i < length; i++){
            for (int j = 0; j < width; j++) {
                grid[i][j] = 0;
            }
        }
        return new int[length][width];
    }


    public int[][] initMines(int length, int width, int minesNumber) {
        int[][] gridWithMines = this.createEmptyGrid(length, width);

        Random rand = new Random();
        while(minesNumber > 0){
            int randomRow = rand.nextInt(length-1);
            int randomColumn = rand.nextInt(width-1);
            if(gridWithMines[randomRow][randomColumn] != -1) {
                // cells with mine
                gridWithMines[randomRow][randomColumn] = -1;

                //update grid with computed adjacent mines
                List<Position> adjacents = getAdjacents(length, width, new Position(randomColumn, randomRow));
                for (Position adjacent : adjacents) {
                    if(gridWithMines[adjacent.getVerticalPos()][adjacent.getHorizontalPos()] != -1){
                        gridWithMines[adjacent.getVerticalPos()][adjacent.getHorizontalPos()]++;
                    }
                }
                minesNumber--;
            }
        }
        return gridWithMines;
    }

    public static List<Position> getAdjacents(int gridLength, int gridWidth, Position position){
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
        return filterValidAdjacentToList(gridLength, gridWidth, topLeft, topMiddle, topRight,
                                  centerLeft, centerRight, bottomLeft, bottomMiddle, bottomRight);

    }

    public static List<Position> filterValidAdjacentToList(int gridLength, int gridWidth,Position... positions) {
        List<Position> validAdjacents = new ArrayList<Position>();
        for (Position position : positions) {
            if (position.isInTheGrid(gridLength, gridWidth)) {
                validAdjacents.add(position);
            }

        }
        return validAdjacents;
    }



}
