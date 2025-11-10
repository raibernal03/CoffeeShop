package logic.addOn;

import logic.Driks.Beverage;
import logic.Driks.Decorator;

public class ColdFoam extends Decorator {
    Beverage beverage;
    Syrups syrups;

    public ColdFoam(Beverage beverage, String choice) {
        this.beverage = beverage;
        try {
            this.syrups = Syrups.valueOf(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.beverage.description() + " " + syrups.getDescription() + " cold foam";
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 1;
    }
}
