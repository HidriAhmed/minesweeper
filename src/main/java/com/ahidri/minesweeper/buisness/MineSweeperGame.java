package com.ahidri.minesweeper.buisness;

import com.ahidri.minesweeper.model.Position;

import java.util.List;

/**
 * Created by ahidri on 13/01/15.
 */
public class MineSweeperGame {

    private int[][] initializedGrid;
    private String[][] currentGame;
    private int uncoveredCellsNumber;

    public void createNewGame(int length, int width, int minesNumber) {
        MineSweeperInitializer initializer = new MineSweeperInitializer();
        initializedGrid = initializer.initMines(length, width, minesNumber);

        currentGame = new String[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                currentGame[i][j] = "-";
            }
        }
        uncoveredCellsNumber = length * width - minesNumber;

    }

    public void play(int horizontalPos, int verticalPos) {
        if (initializedGrid[verticalPos][horizontalPos] == -1) {
            currentGame = null;
        } else {
            uncoverCell(horizontalPos, verticalPos);
        }
    }

    private void uncoverCell(int horizontalPos, int verticalPos) {
        Position position = new Position(horizontalPos, verticalPos);
        List<Position> adjacents = MineSweeperInitializer.getAdjacents(this.initializedGrid.length, this.initializedGrid[0].length, position);
        if (initializedGrid[verticalPos][horizontalPos] == 0) {
            this.currentGame[verticalPos][horizontalPos] = "U";
            this.uncoveredCellsNumber --;
            for (Position adjacent : adjacents) {
                if(isCoveredCell(adjacent)) {
                    uncoverCell(adjacent.getHorizontalPos(), adjacent.getVerticalPos());
                }
            }
        } else {
            this.currentGame[verticalPos][horizontalPos] = String.valueOf(initializedGrid[verticalPos][horizontalPos]);
        }
    }

    private boolean isCoveredCell(Position adjacent) {
        return !"U".equals(this.currentGame[adjacent.getVerticalPos()][adjacent.getHorizontalPos()]);
    }

    public String toStringCurrentGame(){
        String result = "";
        for (int i = 0; i < this.currentGame[0].length; i++) {
            if(i != 0){
                result += "\n";
            }
            for (int j = 0; j < this.currentGame.length; j++) {
                result += this.currentGame[j][i] ;
            }
        }
        return result;
    }

    public int[][] getInitializedGrid() {
        return initializedGrid;
    }

    public String[][] getCurrentGame() {
        return currentGame;
    }

    public int getUncoveredCellsNumber() {
        return uncoveredCellsNumber;
    }
}
