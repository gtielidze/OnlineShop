
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gio
 */
public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();

    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        if (items.containsKey(product)) {
            items.get(product).increaseQuantity();
        } else {
            items.put(product, item);
        }
    }

    public int price() {
        int totalPrice = 0;
        for (String product : items.keySet()) {
            totalPrice += items.get(product).price();
        }
        return totalPrice;
    }

    public void print() {
        for (String product : items.keySet()) {
            System.out.println(items.get(product).toString());

        }
    }

}
