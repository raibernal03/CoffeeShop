package logic.temperature;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class Hot extends Decorator {
    Beverage beverage;

    @Override
    public String description() {
        return this.beverage.description() + " " + "hot";
    }

    @Override
    public double cost() {
        return 0;
    }
}
