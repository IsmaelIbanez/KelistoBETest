package controllers.services;

import model.ProductsRepository;
import model.entities.Product;
import java.util.ArrayList;

public class Checkout {
    String[] pricingRules;
    ArrayList<Product> productList = new ArrayList<Product>();
    double total = 0;
    double discount = 0;
    ProductsRepository productsRepository = new ProductsRepository();

    public Checkout(String[] newPricingRules){
        pricingRules = newPricingRules;
    }

    public void scan(String newProduct){
        newProduct = newProduct.toUpperCase();

        for (Product product : productsRepository.productsList) {
            if(newProduct.equals(product.itemCode)){
                productList.add(product);
            }
        }
    }

    public double getTotal() {
        calculateTotal();
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    public double getDiscount(){
        return discount;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public

    void calculateTotal(){
        applyPricingRules();

        for (Product product: productList) {
            total += product.price;
        }

        total -= discount;
    }


    void applyPricingRules(){

        for (String rule: pricingRules) {

            if (rule.equals("buy-one-get-one")) applyBuyOneGetOneFree();

            if (rule.equals("strawberrySales")) strawberrySales();

        }
    }

    void applyBuyOneGetOneFree(){
        int greenTea = 0;
        double greenTeaPrice = 0;

        for (Product product: productList) {
            if (product.itemCode.equals("GR1")) {
                greenTea++;
                greenTeaPrice = product.price;
            }
        }

        if (greenTea > 1){
            int howManyFree = greenTea/2;
            discount += (howManyFree * greenTeaPrice);
        }
    }

    void strawberrySales(){
        int strawberries = 0;

        for (Product product: productList) {
            if(product.itemCode.equals("SR1")) strawberries++;
        }

        if (strawberries >= 3){
            discount += strawberries * 0.5;
        }
    }




}
