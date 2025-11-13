package logic.menu.pastries;

import logic.menu.Item;

public class Brownie implements Item {

    Item item;

    public Brownie(Item item) {
        this.item = item;
    }

    @Override
    public String description() {
        return "Brownie";
    }

    @Override
    public double cost() {
        return 2.50;
    }
}
