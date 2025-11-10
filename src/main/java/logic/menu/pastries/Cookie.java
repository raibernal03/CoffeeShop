package logic.menu.pastries;

import logic.menu.Item;

public class Cookie implements Item {
    @Override
    public String description() {
        return "Cookie";
    }

    @Override
    public double cost() {
        return 2.50;
    }
}
