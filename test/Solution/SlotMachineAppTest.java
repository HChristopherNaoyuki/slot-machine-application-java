package Solution;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SlotMachineAppTest
{
    private SlotMachineApp classicSlotMachine;
    private SlotMachineApp fruitSlotMachine;

    @Before
    public void setUp()
    {
        // Initialize both machines with initialBalance and betAmount
        classicSlotMachine = new SlotMachineApp(100.0, 10.0);
        fruitSlotMachine = new SlotMachineApp(100.0, 10.0);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(100.0, classicSlotMachine.balance, 0.001);
        assertEquals(10.0, classicSlotMachine.betAmount, 0.001);
        assertNotNull(classicSlotMachine.reels);
    }

    @Test
    public void testInitializeReels()
    {
        classicSlotMachine.initializeReels();
        String[][] reels = classicSlotMachine.reels;

        for (String[] row : reels)
        {
            for (String symbol : row)
            {
                assertTrue(isValidClassicSymbol(symbol));
            }
        }
    }

    @Test
    public void testCalculateWinNoWin()
    {
        String[][] nonWinningReels = {
            {"CLOVER", "GOLD$$", "LEPRECHAUN", "QUESTIONMARK?"}
        };
        classicSlotMachine.reels = nonWinningReels;

        double winAmount = classicSlotMachine.calculateWin();
        assertEquals(0.0, winAmount, 0.001);
    }

    @Test
    public void testCalculateFruitWin()
    {
        String[][] winningReels = {
            {"CHERRY", "CHERRY", "CHERRY", "CHERRY"}
        };
        fruitSlotMachine.reels = winningReels;

        double winAmount = fruitSlotMachine.calculateFruitWin(true);
        assertEquals(1000.0, winAmount, 0.001);
    }

    private boolean isValidClassicSymbol(String symbol)
    {
        return symbol.equals("CLOVER") || symbol.equals("GOLD$$") ||
               symbol.equals("LEPRECHAUN") || symbol.equals("QUESTIONMARK?");
    }
}
