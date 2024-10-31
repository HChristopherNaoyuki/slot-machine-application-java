package Solution;

import java.util.Random;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class SlotMachineApp
{
    protected String[][] reels; // 2D array to store symbols
    protected double balance;
    protected double betAmount;

    // Constructor to initialize the slot machine
    public SlotMachineApp(double initialBalance, double betAmount)
    {
        this.balance = initialBalance;
        this.betAmount = betAmount;
        int numRows = (int) (initialBalance / betAmount);
        this.reels = new String[numRows][4];
        initializeReels(); // Initialize reels
    }

    protected void initializeReels()
    {
        Random random = new Random();
        
        for (String[] reel : reels)
        {
            for (int col = 0; col < 4; col++)
            {
                // Assign random symbols for Classic Slot Machine
                int randomValue = random.nextInt(4) + 1;
                switch (randomValue)
                {
                    case 1 -> reel[col] = "CLOVER";
                    case 2 -> reel[col] = "GOLD$$";
                    case 3 -> reel[col] = "LEPRECHAUN";
                    case 4 -> reel[col] = "QUESTIONMARK?";
                }
            }
        }
    }

    protected void displayReels()
    {
        for (int row = 0; row < reels.length; row++)
        {
            System.out.print("Row " + (row + 1) + ": ");
            
            for (int col = 0; col < 4; col++)
            {
                System.out.print(reels[row][col]);
                
                if (col < 3)
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    protected double calculateWin()
    {
        for (String[] reel : reels)
        {
            String symbol = reel[0];
            boolean isWinningRow = true;
            for (int col = 1; col < 4; col++)
            {
                if (!reel[col].equals(symbol))
                {
                    isWinningRow = false;
                    break;
                }
            }
            if (isWinningRow)
            {
                return betAmount * 10; // Win: Same symbol in this row
            }
        }
        return 0; // No win
    }

    protected double calculateFruitWin(boolean isTest)
    {
        if (isTest || (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SATURDAY 
                && LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(21, 30))))
        {
            String symbol = reels[0][0];

            for (String[] reel : reels)
            {
                for (int col = 0; col < 4; col++)
                {
                    if (!reel[col].equals(symbol))
                    {
                        return 0; // No win if any row doesn't match
                    }
                }
            }
            return 1000; // Win 1000 on Saturday after 9:30 PM with matching symbols in all rows
        }
        return 0; // No win
    }

    public void play(boolean isFruitMachine)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("<< Welcome to the Slot Machine >>");
            
            while (balance >= betAmount)
            {
                System.out.println("Your Balance: R" + balance);
                System.out.println("Bet Amount: R" + betAmount);
                System.out.print("Press ENTER to spin the reels or 'C' to cash out: ");
                String input = scanner.nextLine();
                
                if (input.equalsIgnoreCase("c"))
                {
                    break;
                }
                
                balance -= betAmount; // Deduct bet amount
                initializeReels(); // Initialize reels
                displayReels(); // Display reels
                
                double winAmount;
                
                if (isFruitMachine)
                {
                    winAmount = calculateFruitWin(false); // Normal calculation
                }
                else
                {
                    winAmount = calculateWin(); // Classic calculation
                }
                
                if (winAmount > 0)
                {
                    System.out.println("CONGRATULATIONS >>> You WON: R" + winAmount);
                }
                else
                {
                    System.out.println("NO win this time :(");
                }
                
                balance += winAmount; // Update balance
            }
            
            System.out.println("Cash Out complete... GAME OVER! Your final balance: R" + balance);
        }
    }

    public static void main(String[] args)
    {
        SlotMachineApp classicSlotMachine = new SlotMachineApp(100.0, 10.0);
        classicSlotMachine.play(false); // Play Classic Slot Machine

        // Uncomment the line below to play the Fruit Slot Machine
        // SlotMachineApp fruitSlotMachine = new SlotMachineApp(100.0, 10.0);
        // fruitSlotMachine.play(true); // Play Fruit Slot Machine
    }
}
