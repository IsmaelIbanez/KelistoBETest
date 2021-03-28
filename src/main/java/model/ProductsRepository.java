package model;

import model.entities.Product;

import java.util.ArrayList;

public class ProductsRepository {
    public ArrayList<Product> productsList = new ArrayList<Product>();

    public ProductsRepository(){
        Product product = new Product("GR1", "Green tea", 3.11);
        productsList.add(product);
        product = new Product("SR1", "Strawberries", 5.00);
        productsList.add(product);
        product = new Product("CF1", "Coffee", 11.23);
        productsList.add(product);
    }

}
