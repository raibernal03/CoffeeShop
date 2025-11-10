package logic.menu.pastries;

import logic.menu.Item;

public class Concha implements Item {
    @Override
    public String description() {
        return "Concha";
    }

    @Override
    public double cost() {
        return 3;
    }
}
