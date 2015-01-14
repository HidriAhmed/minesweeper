package com.ahidri.minesweeper;

import com.ahidri.minesweeper.buisness.MineSweeperGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ahidri on 14/01/15.
 */
public class MineSweeperPlayer {
    public static void main(String[] args) {

        //load game parameters
        System.out.println("Welcome to the Mine Sweeper Game ");
        System.out.println("Please enter the grid length: ");
        int length = Integer.parseInt(readStringFromConsole());

        System.out.print("Please enter the grid width: ");
        int width = Integer.parseInt(readStringFromConsole());
        int minesNumber;
        do {
            System.out.println("Please enter the number of mines: ");
            minesNumber = Integer.parseInt(readStringFromConsole());
        }while (minesNumber > length * width);

        System.out.println("Thank you. Now You can start playing, ");

        //Create the game
        MineSweeperGame game = new MineSweeperGame();
        game.createNewGame(length, width, minesNumber);

        do{
            System.out.println(game.printCurrentGame());
            System.out.println("Please enter the horizontal position of the cell to uncover: ");
            int horizontalPos = Integer.parseInt(readStringFromConsole());

            System.out.println("Please enter the vertical position of the cell to uncover: ");
            int verticalPos = Integer.parseInt(readStringFromConsole());

            game.play(horizontalPos, verticalPos);
        }while (game.getCurrentGame() != null && game.getUncoveredCellsNumber() > 0);
        if (game.getUncoveredCellsNumber() == 0){
            System.out.println("Congratulations You won");
        }
        else if(game.getCurrentGame() == null){
            System.out.println("Sorry You lost");
        }
    }

    private static String readStringFromConsole() {
        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userName = null;

        //  read the parameters from the command-line; need to use try/catch with the
        //  readLine() method
        try {
            userName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        return userName;
    }

}
