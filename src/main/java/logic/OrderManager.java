package logic;

import logic.fileManager.FileManager;
import logic.menu.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    static List<Item> cart = new ArrayList<>();

    //save to cart
    public static void saveCart(Item item){
        cart.add(item);
    }

    //remove from cart
    public static void removeItem(int index){
        cart.remove(index);
    }

    //check out
    public static void checkOut(String name){
        FileManager.checkOut(cart, name);
        //cart.stream().forEach(item -> cart.remove(item));
    }
}
