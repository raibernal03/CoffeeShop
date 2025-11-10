package logic.Driks;

public class Cappuccino implements Beverage, EspressoShots {
    @Override
    public String description() {
        return "Cappuccino";
    }

    @Override
    public double cost() {
        return 4.25;
    }

    @Override
    public int espressoShots() {
        return 1;
    }


}
