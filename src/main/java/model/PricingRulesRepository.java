package model;
import java.util.ArrayList;

public class PricingRulesRepository {
    ArrayList<String> offers = new ArrayList<String>();
    public PricingRulesRepository(){
        offers.add("buy-one-get-one");
        offers.add("strawberry-sales");
    }

    public ArrayList<String> getOffers() {
        return offers;
    }
}
