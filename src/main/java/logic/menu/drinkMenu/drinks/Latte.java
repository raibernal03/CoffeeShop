package logic.menu.drinkMenu.drinks;

import logic.menu.Item;

public class Latte implements Item, EspressoShots {
    @Override
    public String description() {
        return "";
    }

    @Override
    public double cost() {
        return 4.25;
    }

    @Override
    public int espressoShots() {
        return 1;
    }
}
