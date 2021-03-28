package model.entities;

public class Product {
    public String itemCode;
    public String name;
    public double price;

   public Product(String newItemCode, String newName, Double newPrice){
       itemCode = newItemCode;
       name = newName;
       price = Math.round(newPrice * 100.0) / 100.0;
    }

}
