package logic.menu.drinkMenu.temperature;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class Hot extends Decorator {
    Item item;

    @Override
    public String description() {
        return this.item.description() + "\n\t+ " + "hot";
    }

    @Override
    public double cost() {
        return this.item.cost();
    }
}
