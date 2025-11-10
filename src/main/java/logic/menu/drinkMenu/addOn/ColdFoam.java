package logic.menu.drinkMenu.addOn;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class ColdFoam extends Decorator {
    Item item;
    Syrups syrups;

    public ColdFoam(Item item, String choice) {
        this.item = item;
        try {
            this.syrups = Syrups.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.item.description() + "\n\t+1.00 " + syrups.getDescription();
    }

    @Override
    public double cost() {
        return this.item.cost() + 1;
    }
}
