package logic.milk;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class MilkDecorator extends Decorator {
    Beverage beverage;
    Milks milk;

    public MilkDecorator(Beverage beverage, String milk) {
        this.beverage = beverage;
        try {
            this.milk = Milks.valueOf(milk);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.beverage.description() + " " + this.milk.getDescription();
    }

    @Override
    public double cost() {
        return switch (this.milk) {
            case WHOLE, NONFAT -> this.beverage.cost();
            case SOY, ALMOND -> this.beverage.cost() + 1;
        };
    }
}
