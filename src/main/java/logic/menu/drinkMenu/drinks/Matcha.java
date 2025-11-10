package logic.Driks;

public class Matcha implements Beverage, TeaPumps{
    @Override
    public String description() {
        return "Matcha Latte";
    }

    @Override
    public double cost() {
        return 4.95;
    }

    @Override
    public int pumps() {
        return 2;
    }
}
