import controllers.services.Checkout;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutServiceShould {

    Checkout checkout;

    @Test
    public void increment_in_one_the_length_of_productList(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");

        Assert.assertEquals(1, checkout.getProductList().size(), 0.0f );
    }

    @Test
    public void provide_the_sum_of_total_prices_given_one_product(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");

        Assert.assertEquals(3.11, checkout.getTotal(),  0.0f);
    }

   @Test
    public void increment_in_two_the_length_of_productList(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");
        checkout.scan("GR1");

        Assert.assertEquals(2, checkout.getProductList().size(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_two_products(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");
        checkout.scan("GR1");

        Assert.assertEquals(6.22, checkout.getTotal(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_two_products_with_pricing_rules(){
        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");
        checkout.scan("GR1");

        Assert.assertEquals(3.11, checkout.getTotal(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_three_products_with_pricing_rules(){
        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");
        checkout.scan("GR1");
        checkout.scan("GR1");

        Assert.assertEquals(6.22, checkout.getTotal(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_five_specific_products_with_pricing_rules(){
        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        checkout = new Checkout(pricingRules);
        checkout.scan("GR1");
        checkout.scan("SR1");
        checkout.scan("GR1");
        checkout.scan("GR1");
        checkout.scan("CF1");

        Assert.assertEquals(22.45, checkout.getTotal(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_four_specific_products_with_pricing_rules(){
        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        checkout = new Checkout(pricingRules);
        checkout.scan("SR1");
        checkout.scan("SR1");
        checkout.scan("GR1");
        checkout.scan("SR1");

        Assert.assertEquals(16.61, checkout.getTotal(),  0.0f);
    }

    @Test
    public void increment_in_one_the_length_of_productList_given_one_error_item_code(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("X");
        checkout.scan("GR1");

        Assert.assertEquals(3.11, checkout.getTotal(),  0.0f);
    }

   @Test
    public void provide_the_sum_of_total_prices_given_two_products_given_one_error_item_code(){
        String[] pricingRules = new String[]{""};
        checkout = new Checkout(pricingRules);
        checkout.scan("X");
        checkout.scan("GR1");

        Assert.assertEquals(1, checkout.getProductList().size(),  0.0f);
    }

    @Test
    public void provide_the_sum_of_total_prices_given_four_specific_products_introduced_in_lower_case_with_pricing_rules(){
        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        checkout = new Checkout(pricingRules);
        checkout.scan("sr1");
        checkout.scan("sr1");
        checkout.scan("gr1");
        checkout.scan("sr1");

        Assert.assertEquals(16.61, checkout.getTotal(),  0.0f);
    }
}