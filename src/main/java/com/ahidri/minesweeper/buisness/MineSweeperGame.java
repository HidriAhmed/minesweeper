package com.ahidri.minesweeper.buisness;

import com.ahidri.minesweeper.model.Grid;
import com.ahidri.minesweeper.model.Position;

import java.util.List;

/**
 * Created by ahidri on 13/01/15.
 */
public class MineSweeperGame {

    private Grid initializedGrid;
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
        Position position = new Position(horizontalPos, verticalPos);
        if (initializedGrid.isMine(position)) {
            currentGame = null;
        } else {
            uncoverCell(position);
        }
    }

    private void uncoverCell(Position position) {
        List<Position> adjacents = initializedGrid.getAdjacents( position);
        if (initializedGrid.getPositionValue(position) == 0) {
            this.currentGame[position.getVerticalPos()][position.getHorizontalPos()] = "U";
            this.uncoveredCellsNumber --;
            for (Position adjacent : adjacents) {
                if(isCoveredCell(adjacent)) {
                    uncoverCell(adjacent);
                }
            }
        } else {
            this.currentGame[position.getVerticalPos()][position.getHorizontalPos()] = String.valueOf(initializedGrid.getPositionValue(position));
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

    public String toStringInitializedGrid(){
        String result = "";
        for (int i = 0; i < this.initializedGrid.getWidth(); i++) {
            if(i != 0){
                result += "\n";
            }
            for (int j = 0; j < this.initializedGrid.getLength(); j++) {

                result += this.initializedGrid.isMine(new Position(j,i)) ? "*" : "-" ;
            }
        }
        return result;
    }

    public Grid getInitializedGrid() {
        return initializedGrid;
    }

    public String[][] getCurrentGame() {
        return currentGame;
    }

    public int getUncoveredCellsNumber() {
        return uncoveredCellsNumber;
    }
}
