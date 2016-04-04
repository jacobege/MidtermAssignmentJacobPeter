package Exercise_6_test;

import Exercise_6.IBoard;
import Exercise_6.IPiece;
import Exercise_6.IDie;
import Exercise_6.Player;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class PlayerTest {

    public PlayerTest() {
    }

    /**
     * Test of takeTurn method, of class Player.
     */
    @Test
    public void testTakeTurn() {
        System.out.println("takeTurn");
        
        // Setup
        Mockery context = new Mockery();

        IPiece piece = context.mock(IPiece.class);
        IBoard board = context.mock(IBoard.class);
        IDie die_0 = context.mock(IDie.class);
        IDie[] dice = new IDie[]{die_0, die_0};

        Player player = new Player(board, dice, piece);

        // Expectations
        context.checking(new Expectations() {
            {
                exactly(2).of(die_0).roll();
                int faceValues = exactly(2).of(die_0).getFaceValue();
                int oldLocation = oneOf(piece).getLocation();
                int newLocation = oneOf(board).getSquare(oldLocation, faceValues);
                oneOf(piece).setLocation(newLocation);
            }
        });

        // Execute
        player.takeTurn();
        
        // Verify
        context.assertIsSatisfied();
    }
}