import java.util.*;

public class Dice {
    int limit;
    Random dice;

    public Dice() {
        this.limit=6;
        dice = new Random();
    }

    public Dice(int limit) {
        this.limit = limit;
        dice = new Random();
    }

    public int rollDice(){
        return dice.nextInt(this.limit)+1;
    }
}
