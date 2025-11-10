package logic.menu.drinkMenu.drinks;

import logic.menu.Item;

public class Chai implements Item, TeaPumps {
    @Override
    public String description() {
        return "Chai Latte + " + "\n\t " + pumps() + " chai pumps";
    }

    @Override
    public double cost() {
        return 4.95;
    }

    @Override
    public int pumps() {
        return 2;
    }
}
