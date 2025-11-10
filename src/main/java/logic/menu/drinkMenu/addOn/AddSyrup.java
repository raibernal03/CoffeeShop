package logic.menu.drinkMenu.addOn;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class AddSyrup extends Decorator {
    Item item;
    Syrups syrups;

    public AddSyrup(Item item, String choice) {
        this.item = item;
        try {
            this.syrups = Syrups.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String description() {
        return this.item.description() + "\n\t+0.50 " + this.syrups.getDescription();
    }

    @Override
    public double cost() {
        return this.item.cost() + .50;
    }
}
