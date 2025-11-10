package logic;

import logic.menu.Item;
import logic.menu.drinkMenu.drinks.Cappuccino;
import logic.menu.drinkMenu.drinks.Chai;
import logic.menu.drinkMenu.drinks.Latte;
import logic.menu.drinkMenu.drinks.Matcha;

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
    public void mainMenu(){

        boolean exit = false;
        while(!exit){
            System.out.println("""
                    1) Add Drink
                    2) Add Pastries
                    3) view Cart
                    0) Exit""");
            System.out.print("--> ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1 -> addDrink();
                case 2 -> addPastries();
                case 3 -> viewCart();
                case 0 -> exit = true;
            }
        }
    }
    public void addDrink(){
        Item item;
        System.out.println("""
                Drink Menu: 
                1) Matcha
                2) Latte
                3) Cappuccino
                4) Chai Latte""");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1 -> item = new Matcha();
            case 2 -> item = new Latte();
            case 3 -> item = new Cappuccino();
            case 4 -> item = new Chai();
        }
        System.out.println("Would you like to Cus");
    }
    public void addPastries(){

    }
    public void viewCart(){}


}
