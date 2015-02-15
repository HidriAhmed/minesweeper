package com.ahidri.minesweeper.model;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ahidri on 03/02/15.
 */
public class GridTest {

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InFirstRow(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(1, 0), new Position(3, 0),
                new Position(1, 1), new Position(2, 1), new Position(3, 1));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(2, 0));

        //Then
        assertThat(adjascents).hasSize(5);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InFirstColumn(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,0), new Position(0,1),
                new Position(1,1),new Position(2,1),new Position(2,1));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(1, 0));

        //Then
        assertThat(adjascents).hasSize(5);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InTopLeft(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,1), new Position(1,0),
                new Position(1,1));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(0, 0));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InBottomLeft(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(0,1), new Position(1,1),
                new Position(1,2));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(0, 2));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InTopRight(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(2,0), new Position(2,1),
                new Position(3,1));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(3, 0));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InBottomRight(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(3,1), new Position(2,1),
                new Position(2,2));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(3, 2));

        //Then
        assertThat(adjascents).hasSize(3);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }

    @Test
    public void testgetAdjacentsIntoGridWithLengthEquals_3_AndWidthEquals_4ForPosition_InMiddleOfGrid(){

        //Given
        Grid myGrid = new Grid(3,4);
        List<Position> expectedAdjascents = Lists.newArrayList(new Position(1,0), new Position(2,0),
                new Position(3,0),new Position(1,1),new Position(3,1),
                new Position(1,2),new Position(2,2),new Position(3,2));

        //When
        List<Position> adjascents = myGrid.getAdjacents(new Position(2, 1));

        //Then
        assertThat(adjascents).hasSize(8);
        assertThat(adjascents).containsAll(expectedAdjascents);

    }


}
