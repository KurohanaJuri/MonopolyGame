import java.util.ArrayList;

public class Cup {

    private ArrayList<Die> dice;

    public Cup(int totalDice) {
        if(totalDice < 0)
            throw new RuntimeException("Can't have a negative number of dice.");

        dice = new ArrayList<>();

        for(int i = 0; i < totalDice; ++i)
            dice.add(new Die());
    }

    /**
     * Rolls all the dice in the cup
     */
    public void roll() {
        for(Die die : dice)
            die.roll();
    }

    /**
     * Get all the values of each dice
     * @return total made from the rolls
     */
    public int getTotal() {
        int total = 0;

        for(Die die : dice)
            total += die.getFaceValue();

        return total;
    }
}
