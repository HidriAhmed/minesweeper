package com.ahidri.minesweeper;


import java.util.Random;

/**
 * Created by ahidri on 12/01/15.
 */
public class MineSweeper {


    public int[][] createEmptyGrid(int length, int width) {
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
        for (int i = 0; i < minesNumber ; i++) {
            int randomRow = rand.nextInt(length);
            int randomColumn = rand.nextInt(width);
            if(gridWithMines[randomRow][randomColumn] == 0){
                gridWithMines[randomRow][randomColumn] = 1;
            }
            else {
                i--;
            }
        }
        return gridWithMines;
    }
}
