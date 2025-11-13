package logic;

import logic.fileManager.FileManager;
import logic.menu.Item;
import logic.menu.drinkMenu.addOn.AddSyrup;
import logic.menu.drinkMenu.addOn.ColdFoam;
import logic.menu.drinkMenu.addOn.Espresso;
import logic.menu.drinkMenu.drinks.Cappuccino;
import logic.menu.drinkMenu.drinks.Chai;
import logic.menu.drinkMenu.drinks.Latte;
import logic.menu.drinkMenu.drinks.Matcha;
import logic.menu.drinkMenu.milk.MilkDecorator;
import logic.menu.drinkMenu.size.SizeDecorator;
import logic.menu.drinkMenu.temperature.Hot;
import logic.menu.drinkMenu.temperature.Iced;
import logic.menu.pastries.*;

import java.util.List;
import java.util.Scanner;

public class UserInterphase {
    static Scanner scanner = new Scanner(System.in);

    public void init() {
        System.out.println("=".repeat(100));
        System.out.println("Welcome to Galileo's Caffe");
        System.out.println("""
                1) New Order
                0) exit""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> mainMenu();
            case 0 -> System.exit(0);
        }

        System.out.println("=".repeat(100));
    }

    public void mainMenu() {

        boolean running = true;
        while (running) {
            System.out.println("""
                    1) Add Drink
                    2) Add Pastries
                    3) View Cart
                    0) Exit""");
            System.out.print("--> ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addDrink();
                case 2 -> addPastries();
                case 3 -> viewCart();
                case 0 -> running = false;
            }
        }
    }

    public void addDrink() {
        Item item = null;
        System.out.println("""
                Drink Menu:
                1) Matcha
                2) Latte
                3) Cappuccino
                4) Chai Latte""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> item = new Matcha();
            case 2 -> item = new Latte();
            case 3 -> item = new Cappuccino();
            case 4 -> item = new Chai();
        }

        item = defaultCustomization(item);


        System.out.println(item.description());
        System.out.print("Add to cart? ");
        String addToCart = scanner.nextLine();
        if (addToCart.equals("yes")) {
            OrderManager.saveCart(item);
        }

    }

    public void addPastries() {
        boolean running = true;
        while (running) {
            Item pastries = null;
            System.out.println("""
                    Pastries Options:
                    1) Brownie
                    2) Concha
                    3) Cookie
                    4) Croissant
                    0) Back""");
            System.out.print("--> ");
            int choice = Integer.parseInt(scanner.nextLine().trim() );
            switch (choice) {
                case 1 -> pastries = warm(pastries = new Brownie(pastries));
                case 2 -> pastries = warm(new Concha(pastries));
                case 3 -> pastries = warm(new Cookie(pastries));
                case 4 -> pastries = warm(new Crossaint(pastries));
                case 0 -> running = false;
                default -> System.out.println("INVALID CHOICE");
            }

        }

    }
    // warm pastrie

    public Item warm(Item pastries){
        System.out.print("Would you like it warmed? ");
        String warmed = scanner.nextLine().trim();


        if (warmed.equalsIgnoreCase("yes")){
            pastries = new Warmed(pastries);
        }

        System.out.println(pastries.description());
        System.out.print("Add to cart? ");
        String addToCart = scanner.nextLine();
        if (addToCart.equalsIgnoreCase("yes")) {
            OrderManager.saveCart(pastries);
        }
        return pastries;
    }


    public void viewCart() {
        //people.stream().forEach(x -> System.out.println(x.toString()));
        var count = OrderManager.cart.stream()
                .count();


        System.out.println("=".repeat(50));
        System.out.println("Galileo's Cafe -> Cart");
        System.out.println("Total items: " + count);
        for (int i = 0; i < OrderManager.cart.size(); i++) {
            System.out.printf("""
                    (%d) %s
                    --> $%.2f\n""", i, OrderManager.cart.get(i).description(), OrderManager.cart.get(i).cost());
        }

        var total = OrderManager.cart.stream()
                .mapToDouble(Item::cost)
                .sum();

        System.out.println("Total: " + total);


        System.out.println("""
               1) Check Out
               2) Remove Item
               3) Back""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice){
            case 1:
                FileManager.checkOut(OrderManager.cart);
                OrderManager.cart = null;
                break;
            case 2:
                System.out.print("Enter item number: ");
                int num = Integer.parseInt(scanner.nextLine());
                OrderManager.removeItem(num);
                break;
            default :
                System.out.println("Invalid Choice!");
                break;
        }
        System.out.println("=".repeat(50));
    }

    //default customization
    public Item defaultCustomization(Item item) {
        System.out.println("""
                Size
                1) Small
                2) Medium
                3) Large""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        item = customizeSize(choice, item);
        System.out.println("""
                Milk Options:
                1) Whole Milk
                2) Non-Fat Milk
                3) Soy Milk + $1.00
                4) Almond Milk + $1.00""");
        System.out.print("--> ");
        choice = Integer.parseInt(scanner.nextLine());
        item = customizeMilk(choice, item);

        System.out.println("""
                Choose One:
                1) Hot
                2) Regular Ice
                3) Extra Ice
                4) Easy Ice
                5) No Ice""");
        System.out.print("--> ");
        choice = Integer.parseInt(scanner.nextLine());
        item = customizeTemp(choice, item);
        item = customizeDrink(item);

        return item;


    }

    //customize size
    public Item customizeSize(int choice, Item item) {
        return switch (choice) {
            case 2 -> item = new SizeDecorator(item, "MEDIUM");
            case 3 -> item = new SizeDecorator(item, "LARGE");
            default -> item = new SizeDecorator(item, "SMALL");
        };
    }

    //customize milk
    public Item customizeMilk(int choice, Item item) {
        return switch (choice) {
            case 2 -> item = new MilkDecorator(item, "NONFAT");
            case 3 -> item = new MilkDecorator(item, "SOY");
            case 4 -> item = new MilkDecorator(item, "ALMOND");
            default -> item = new MilkDecorator(item, "WHOLE");
        };
    }

    //Customize Drink
    public Item customizeDrink(Item item) {
        boolean running = true;
        while (running) {
            System.out.println("""
                    1) Add Syrup
                    2) Add Cold Foam
                    3) And more Espresso
                    0) Back""");
            System.out.print("--> ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> item = customizeSyrup(item);
                case 2 -> item = customizeColdFoam(item);
                case 3 -> item = new Espresso(item);
                case 0 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }

        return item;

    }

    //customizeSyrup
    public Item customizeSyrup(Item item) {
        System.out.println("""
                Add Syrup:
                1) Honey
                2) Lavender
                3) Lechera
                4) Rose
                5) Vanilla
                6) Chocolate
                7) Strawberry
                8) Hazelnut
                9) Caramel
                0) Back""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        return switch (choice) {
            case 1 -> item = new AddSyrup(item, "HONEY");
            case 2 -> item = new AddSyrup(item, "LAVENDER");
            case 3 -> item = new AddSyrup(item, "LECHERA");
            case 4 -> item = new AddSyrup(item, "ROSE");
            case 5 -> item = new AddSyrup(item, "VANILLA");
            case 6 -> item = new AddSyrup(item, "CHOCOLATE");
            case 7 -> item = new AddSyrup(item, "STRAWBERRY");
            case 8 -> item = new AddSyrup(item, "HAZELNUT");
            case 9 -> item = new AddSyrup(item, "CARAMEL");
            default -> item;
        };
    }

    //customized cold foam
    public Item customizeColdFoam(Item item) {
        System.out.println("""
                Cold Foam Flavors
                 1) Honey
                2) Lavender
                3) Lechera
                4) Rose
                5) Vanilla
                6) Chocolate
                7) Strawberry
                8) Hazelnut
                9) Caramel
                0) Back""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> item = new ColdFoam(item, "HONEY");
            case 2 -> item = new ColdFoam(item, "LAVENDER");
            case 3 -> item = new ColdFoam(item, "LECHERA");
            case 4 -> item = new ColdFoam(item, "ROSE");
            case 5 -> item = new ColdFoam(item, "VANILLA");
            case 6 -> item = new ColdFoam(item, "CHOCOLATE");
            case 7 -> item = new ColdFoam(item, "STRAWBERRY");
            case 8 -> item = new ColdFoam(item, "HAZELNUT");
            case 9 -> item = new ColdFoam(item, "CARAMEL");
            default -> item;
        };
    }

    //customize temperature
    public Item customizeTemp(int choice, Item item){
        return switch (choice) {
            case 1 -> new Hot(item);
            case 2 -> new Iced(item, "REGULAR");
            case 3 -> new Iced(item, "EXTRA");
            case 4 -> new Iced(item, "EASY");
            case 5 -> new Iced(item, "NOICE");
            default -> new Hot(item);
        };
    }


}
