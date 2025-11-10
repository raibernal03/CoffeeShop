package logic.temperature;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class Iced extends Decorator {
    Beverage beverage;
    Ice ice;

    public Iced(Beverage beverage, String choice) {
        this.beverage = beverage;
        try {
            this.ice = Ice.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.beverage.description() + " " + this.ice.getDescription();
    }

    @Override
    public double cost() {
        return 0;
    }
}
