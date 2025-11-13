package logic.menu.pastries;

import logic.menu.Item;

public class Concha implements Item {
    Item item;

    public Concha(Item item) {
        this.item = item;
    }

    @Override
    public String description() {
        return "Concha";
    }

    @Override
    public double cost() {
        return 3;
    }
}
