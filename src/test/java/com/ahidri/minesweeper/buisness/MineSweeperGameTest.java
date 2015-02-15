package com.ahidri.minesweeper.buisness;

import com.ahidri.minesweeper.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by ahidri on 13/01/15.
 */
public class MineSweeperGameTest {

    @Test
    public void testCreateNewGame(){
        //Given
        MineSweeperGame game = new MineSweeperGame();

        //When
        game.createNewGame(4, 4, 3);

        //Then
        assertThat(game.getInitializedGrid().getLength()).isEqualTo(4);
        assertThat(game.getInitializedGrid().getLength()).isEqualTo(4);


    }

    @Test
    public void testplay(){
        //Given
        MineSweeperGame game = new MineSweeperGame();
        game.createNewGame(4, 4, 4);

        //When
        game.play(0,0);

        //Then
        Position position = new Position(0, 0);
        if(game.getInitializedGrid().getPositionValue(position) == -1){
            assertThat(game.getCurrentGame()).isNull();
        }
        else if(game.getInitializedGrid().getPositionValue(position) == 0){
            assertThat(game.getCurrentGame()[0][0]).isEqualTo("U");

        }
        else{
            assertThat(game.getCurrentGame()[0][0]).isEqualTo(String.valueOf(game.getInitializedGrid().getPositionValue(position)));
        }

    }
}
