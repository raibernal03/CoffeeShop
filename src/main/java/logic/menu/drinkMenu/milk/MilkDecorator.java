package logic.menu.drinkMenu.milk;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Decorator;

public class MilkDecorator extends Decorator {
    Item item;
    Milks milk;

    public MilkDecorator(Item item, String milk) {
        this.item = item;
        try {
            this.milk = Milks.valueOf(milk);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return switch(this.milk){
            case SOY, ALMOND -> this.item.description() + "\n\t+1.00 " + this.milk.getDescription() + "  1.00";
            case WHOLE, NONFAT -> this.item.description() + "\n\t+0.00 " + this.milk.getDescription();
        };
    }

    @Override
    public double cost() {
        return switch (this.milk) {
            case WHOLE, NONFAT -> this.item.cost();
            case SOY, ALMOND -> this.item.cost() + 1;
        };
    }
}
