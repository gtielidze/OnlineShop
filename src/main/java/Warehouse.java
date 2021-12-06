
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gio
 */
public class Warehouse {

    private Map<String, Integer> productsWithPrice;
    private Map<String, Integer> productsInStock;

    public Warehouse() {
        this.productsWithPrice = new HashMap<>();
        this.productsInStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        productsWithPrice.put(product, price);
        productsInStock.put(product, stock);
    }

    public int price(String product) {
        if (productsWithPrice.containsKey(product)) {
            return productsWithPrice.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (productsInStock.containsKey(product)) {
            return productsInStock.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (productsInStock.containsKey(product) && productsInStock.get(product) > 0) {
            Integer reduce = productsInStock.get(product);
            reduce--;
            productsInStock.put(product, reduce);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        Set<String> products = productsInStock.keySet();
        return products;
    }
}
