package logic.menu.drinkMenu.drinks;

import logic.menu.Item;

public abstract class Decorator implements Item {
    public abstract String description();
    public abstract double cost();
}
