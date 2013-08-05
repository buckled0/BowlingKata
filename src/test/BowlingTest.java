package test;

import bowlingkata.BowlingGame;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingTest {

    private BowlingGame bg;

    @Before
    public void setUp() throws Exception {
        bg = new BowlingGame();
    }

    private void rollSpare() {
        bg.roll(5);
        bg.roll(5);
    }

    private void rollMany(int n, int pins) {
        for(int i = 0; i < n; i++)
            bg.roll(pins);
    }

    private void rollStrike() {
        bg.roll(10);
    }

    @Test
    public void gutterGame(){
        rollMany(20, 0);
        assertEquals("Rolling a gutter game", 0, bg.score());
    }

    @Test
    public void allOnes(){
        rollMany(20, 1);
        assertEquals("Rolling a game of ones", 20, bg.score());
    }

    @Test
    public void oneSpare(){
        rollSpare();
        bg.roll(3);
        rollMany(17, 0);
        assertEquals("One spare followed by zeroes", 16, bg.score());
    }

    @Test
    public void oneStrike(){
        rollStrike();
        bg.roll(3);
        bg.roll(4);
        rollMany(16, 0);
        assertEquals("One spare then gutter balls", 24, bg.score());
    }
}
