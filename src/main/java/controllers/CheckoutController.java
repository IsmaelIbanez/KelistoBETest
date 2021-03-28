package controllers;
import controllers.services.Checkout;
import model.MessageRepository;
import model.entities.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;


public class CheckoutController {

    public static void main(String[] args) throws IOException {

        String[] pricingRules = new String[]{"buy-one-get-one", "strawberrySales"};
        String input = " ";
        final Checkout co = new Checkout(pricingRules);

        Message message;
        message = new Message(co.getProductList(), co.getTotal(), co.getDiscount());
        MessageRepository messagesRepository = new MessageRepository(message);

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        Locale.setDefault(new Locale("en", "US"));

        messagesRepository.welcome();

        while(!input.equals("")){
            System.out.println("Scan:");
            input = buffReader.readLine();
            co.scan(input);
        }

        messagesRepository.isLoading();

        Message finalCheckout = new Message(co.getProductList(), co.getTotal(), co.getDiscount());
        MessageRepository checkoutMessage = new MessageRepository(finalCheckout);

        checkoutMessage.getCheckoutListMessage();
    }

}


