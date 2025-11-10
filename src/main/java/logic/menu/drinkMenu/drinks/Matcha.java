package logic.menu.drinkMenu.drinks;

import logic.menu.Item;

public class Matcha implements Item, TeaPumps {
    @Override
    public String description() {
        return "Matcha Latte"
                + "\n\t" + pumps() + "matcha ";
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
