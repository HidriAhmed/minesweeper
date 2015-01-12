package com.ahidri.minesweeper;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ahidri on 12/01/15.
 */
public class MineSweeperTest {

    @Test
    public void testCreateGridWithLengthEquals_2_AndWidthEquals_2AndEmptyMines(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();

        //When
        int[][] grid = mineSweeper.createEmptyGrid(2, 2);

        //Then
        assertThat(grid[0].length).isEqualTo(2);
        assertThat(grid[1].length).isEqualTo(2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertThat(grid[i][j]).isEqualTo(0);
            }
        }

    }

    @Test
    public void testCreateGridWithLengthEquals_3_AndWidthEquals_4And_2_Mines(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();

        //When
        int[][] gridWithMines = mineSweeper.initMines(3,4,2);

        //Then
        assertThat(gridWithMines[0].length).isEqualTo(4);
        assertThat(gridWithMines[1].length).isEqualTo(4);
        assertThat(gridWithMines[2].length).isEqualTo(4);

        int countMines = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                countMines += gridWithMines[i][j];
            }
        }

        assertThat(countMines).isEqualTo(2);

    }
}
