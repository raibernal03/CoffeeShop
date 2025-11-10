package logic.Driks;

public class Latte implements Beverage, EspressoShots {
    @Override
    public String description() {
        return "";
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
