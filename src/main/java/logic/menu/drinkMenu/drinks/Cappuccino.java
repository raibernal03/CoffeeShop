package logic.menu.drinkMenu.drinks;

import logic.menu.Item;

public class Cappuccino implements Item, EspressoShots {
    @Override
    public String description() {
        return "Cappuccino (" +
                espressoShots() + " espresso shots)";
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
