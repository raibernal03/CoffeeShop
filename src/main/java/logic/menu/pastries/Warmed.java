package logic.menu.pastries;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class Warmed extends Decorator {
    Item item;

    public Warmed(Item item) {
        this.item = item;
    }

    @Override
    public String description() {
        return item.description() +"\n\t+warmed";
    }

    @Override
    public double cost() {
        return this.item.cost();
    }
}
