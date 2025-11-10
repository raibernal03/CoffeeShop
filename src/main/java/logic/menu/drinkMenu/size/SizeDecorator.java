package logic.size;

import logic.Driks.*;

public class SizeDecorator extends Decorator implements EspressoShots, TeaPumps{
    Beverage beverage;
    Size size;

    public SizeDecorator(Beverage beverage, String size1) {
        this.beverage = beverage;
        try {
            this.size = Size.valueOf(size1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return this.beverage.description() + " " + this.size.getSize();

    }

    @Override
    public double cost() {
        return switch (this.size) {
            case SMALL -> this.beverage.cost();
            case MEDIUM -> this.beverage.cost() + 1;
            case LARGE -> this.beverage.cost() + 2;
        };
    }


    @Override
    public int espressoShots() {
        if(this.beverage instanceof Cappuccino || this.beverage instanceof Latte){
            return switch (this.size){
                case SMALL -> 1;
                case MEDIUM -> 2;
                case LARGE -> 3;
            };
        }
        else{
            return 0;
        }
    }

    @Override
    public int pumps() {
        if(this.beverage instanceof Matcha || this.beverage instanceof Chai){
            return switch (this.size){
                case SMALL -> ((TeaPumps) this.beverage).pumps();
                case MEDIUM -> 3;
                case LARGE -> 4;
            };
        }else{
            return 0;
        }
    }
}
