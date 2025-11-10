package logic.addOn;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class Espresso extends Decorator {
    Beverage beverage;

    public Espresso(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return this.beverage.description() + "espresso shot";
    }

    @Override
    public double cost() {
        return 1.50;
    }
}
