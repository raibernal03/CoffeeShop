package logic.menu.drinkMenu.temperature;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class Iced extends Decorator {
    Item item;
    Ice ice;

    public Iced(Item item, String choice) {
        this.item = item;
        try {
            this.ice = Ice.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.item.description() + "\n\t+0.00 " + this.ice.getDescription();
    }

    @Override
    public double cost() {
        return this.item.cost();
    }
}
