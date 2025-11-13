package logic.menu.pastries;

import logic.menu.Item;

public class Crossaint implements Item {
    Item item;

    public Crossaint(Item item) {
        this.item = item;
    }

    @Override
    public String description() {
        return "Crossiant";
    }

    @Override
    public double cost() {
        return 3.50;
    }
}
