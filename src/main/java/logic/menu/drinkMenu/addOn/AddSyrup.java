package logic.addOn;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class AddSyrup extends Decorator {
    Beverage beverage;
    Syrups syrups;

    public AddSyrup(Beverage beverage, String choice) {
        this.beverage = beverage;
        try {
            this.syrups = Syrups.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String description() {
        return this.beverage.description() + " " + this.syrups.getDescription();
    }

    @Override
    public double cost() {
        return this.beverage.cost() + .50;
    }
}
