package com.ahidri.minesweeper.buisness;


import com.ahidri.minesweeper.model.Grid;
import com.ahidri.minesweeper.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ahidri on 12/01/15.
 */
public class MineSweeperInitializer {

    public Grid initMines(int length, int width, int minesNumber) {
        //int[][] gridWithMines = this.createEmptyGrid(length, width);
        Grid gridWithMines = new Grid(length, width);

        Random rand = new Random();
        while(minesNumber > 0){
            int randomRow = rand.nextInt(length-1);
            int randomColumn = rand.nextInt(width-1);
            Position position = new Position(randomRow, randomColumn);

            if(!gridWithMines.isMine(position)) {
                gridWithMines.addMine(position);

                //update grid with computed adjacent mines
                List<Position> adjacents = gridWithMines.getAdjacents(new Position(randomColumn, randomRow));
                for (Position adjacent : adjacents) {
                    if(!gridWithMines.isMine(adjacent)){
                        gridWithMines.updateAdjacentOfMine(adjacent);
                    }
                }
                minesNumber--;
            }
        }
        return gridWithMines;
    }





}
