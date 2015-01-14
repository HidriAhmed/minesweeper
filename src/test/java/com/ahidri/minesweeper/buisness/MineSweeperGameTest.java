package com.ahidri.minesweeper.buisness;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by ahidri on 14/01/15.
 */
public class MineSweeperGameTest {

    @Test
    public void testCreateNewGame(){
        //Given
        MineSweeperGame game = new MineSweeperGame();

        //When
        game.createNewGame(4, 4, 3);

        //Then
        assertThat(game.getInitializedGrid().length).isEqualTo(4);
        assertThat(game.getInitializedGrid()[0].length).isEqualTo(4);
        assertThat(game.getInitializedGrid()[1].length).isEqualTo(4);
        assertThat(game.getInitializedGrid()[2].length).isEqualTo(4);
        assertThat(game.getInitializedGrid()[3].length).isEqualTo(4);

    }

    @Test
    public void testplay(){
        //Given
        MineSweeperGame game = new MineSweeperGame();
        game.createNewGame(4, 4, 4);

        //When
        game.play(0,0);

        //Then
        if(game.getInitializedGrid()[0][0] == -1){
            assertThat(game.getCurrentGame()).isNull();
        }
        else if(game.getInitializedGrid()[0][0] == 0){
            assertThat(game.getCurrentGame()[0][0]).isEqualTo("U");

        }
        else{
            assertThat(game.getCurrentGame()[0][0]).isEqualTo(String.valueOf(game.getInitializedGrid()[0][0]));
        }

    }
}
