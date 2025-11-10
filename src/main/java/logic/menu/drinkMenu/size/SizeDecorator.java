package logic.menu.drinkMenu.size;


import logic.menu.Item;
import logic.menu.drinkMenu.drinks.*;


public class SizeDecorator extends Decorator implements EspressoShots, TeaPumps {
    Item item;
    Size size;

    public SizeDecorator(Item item, String size1) {
        this.item = item;
        try {
            this.size = Size.valueOf(size1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return switch (this.size) {
            case SMALL -> this.item.description() + "\n\t+" + this.item.cost() + " " + this.size.getSize();
            case MEDIUM -> this.item.description() + "\n\t+1.00 " + this.size.getSize();
            case LARGE -> this.item.description() + "\n\t+2.00 " + this.size.getSize();
        };
    }

    @Override
    public double cost() {
        return switch (this.size) {
            case SMALL -> this.item.cost();
            case MEDIUM -> this.item.cost() + 1;
            case LARGE -> this.item.cost() + 2;
        };
    }


    @Override
    public int espressoShots() {
        if (this.item instanceof Cappuccino || this.item instanceof Latte) {
            return switch (this.size) {
                case SMALL -> 1;
                case MEDIUM -> 2;
                case LARGE -> 3;
            };
        } else {
            return 0;
        }
    }

    @Override
    public int pumps() {
        if (this.item instanceof Matcha || this.item instanceof Chai) {
            return switch (this.size) {
                case SMALL -> ((TeaPumps) this.item).pumps();
                case MEDIUM -> 3;
                case LARGE -> 4;
            };
        } else {
            return 0;
        }
    }
}
