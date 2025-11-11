package logic;

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

import java.util.Scanner;

public class UserInterphase {
    static Scanner scanner = new Scanner(System.in);

    public void init(){
        System.out.println("=".repeat(100));
        System.out.println("Welcome to Olympus Caffe");
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

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    1) Add Drink
                    2) Add Pastries
                    3) view Cart
                    0) Exit""");
            System.out.print("--> ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addDrink();
                case 2 -> addPastries();
                case 3 -> viewCart();
                case 0 -> exit = true;
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

        item = customizeDrink(item);


        System.out.println(item.description());

    }

    public void addPastries() {

    }

    public void viewCart() {
    }

    //default customization
    public Item defaultCustomization(Item item) {
        System.out.println("""
                Size
                1) Small
                2) Medium
                3) Large""");
        System.out.print("-->");
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
                default -> running = false;
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





}
