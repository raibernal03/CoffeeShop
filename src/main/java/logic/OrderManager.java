package logic;

import logic.menu.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Item> cart = new ArrayList<>();

    //save to cart
    public void saveCart(Item item){
        cart.add(item);
    }

    //remove from cart
    public void removeItem(Item item){
        cart.remove(item);
    }

    //save
}
