package com.ahidri.minesweeper;

import com.ahidri.minesweeper.model.Position;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

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
                if(gridWithMines[i][j] == -1)
                countMines ++;
            }
        }

        assertThat(countMines).isEqualTo(2);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InFirstRow(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(1,0), new Position(3,0),
                new Position(1,1),new Position(2,1),new Position(3,1));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(2,0));

        //Then
        assertThat(adjascents).hasSize(5);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InFirstColumn(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,0), new Position(0,1),
                new Position(1,1),new Position(2,1),new Position(2,1));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(1,0));

        //Then
        assertThat(adjascents).hasSize(5);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InTopLeft(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,1), new Position(1,0),
                new Position(1,1));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(0,0));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InBottomLeft(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,1), new Position(1,1),
                new Position(1,2));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(0,2));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InTopRight(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(2,0), new Position(2,1),
                new Position(3,1));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(3,0));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InBottomRight(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(3,1), new Position(2,1),
                new Position(2,2));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(3,2));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InMiddleOfGrid(){

        //Given
        MineSweeper mineSweeper = new MineSweeper();
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(1,0), new Position(2,0),
                new Position(3,0),new Position(1,1),new Position(3,1),
                new Position(1,2),new Position(2,2),new Position(3,2));

        //When
        List<Position> adjascents = mineSweeper.getAdjacents(3,4,new Position(2,1));

        //Then
        assertThat(adjascents).hasSize(8);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }


}
