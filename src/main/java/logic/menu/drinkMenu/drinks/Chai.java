package logic.Driks;

public class Chai implements Beverage, TeaPumps{
    @Override
    public String description() {
        return "Chai Latte";
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
