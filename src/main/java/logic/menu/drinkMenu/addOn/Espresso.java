package logic.menu.drinkMenu.addOn;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class Espresso extends Decorator {
    Item item;

    public Espresso(Item item) {
        this.item = item;
    }

    @Override
    public String description() {
        return this.item.description() + "\n\t+1.50 espresso shot";
    }
    @Override
    public double cost() {
        return this.item.cost() + 1.50;
    }
}
