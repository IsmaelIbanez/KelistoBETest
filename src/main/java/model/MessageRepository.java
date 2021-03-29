package model;

import model.entities.Message;
import model.entities.Product;

public class MessageRepository {

    Message message;

    public MessageRepository(Message newMessage){
         message = newMessage;
    }

    public void getCheckoutListMessage(){

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(" ________  ___  ___  _______   ________  ___  __    ________  ___  ___  _________   \n" +
                           "|\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   ____\\|\\  \\|\\  \\ |\\   __  \\|\\  \\|\\  \\|\\___   ___\\ \n" +
                           "\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\___|\\ \\  \\/  /|\\ \\  \\|\\  \\ \\  \\\\\\  \\|___ \\  \\_| \n" +
                           " \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\  \\    \\ \\   ___  \\ \\  \\\\\\  \\ \\  \\\\\\  \\   \\ \\  \\  \n" +
                           "  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\\\ \\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\   \\ \\  \\ \n" +
                           "   \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\_______\\   \\ \\__\\\n" +
                           "    \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\|__| \\|__|\\|_______|\\|_______|    \\|__|");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("NAME                    ITEM CODE                PRICE");
        System.out.println("");
        for (Product product: message.products) {
            System.out.println( product.name+ "                    " + product.itemCode + "                " +  String.format("%.2f", product.price));
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("DISCOUNT                                       -" +  String.format("%.2f", message.discount));
        System.out.println("TOTAL                                          £" + String.format("%.2f", message.total));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                           USD  " + message.usdTotal + "$");
        System.out.println("                                           EUR  " + message.eurTotal + "€");
    }

    public void isLoading(){

        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(" " +
                "/$$        /$$$$$$   /$$$$$$  /$$$$$$$  /$$$$$$ /$$   /$$  /$$$$$$ \n" +
                "| $$       /$$__  $$ /$$__  $$| $$__  $$|_  $$_/| $$$ | $$ /$$__  $$\n" +
                "| $$      | $$  \\ $$| $$  \\ $$| $$  \\ $$  | $$  | $$$$| $$| $$  \\__/\n" +
                "| $$      | $$  | $$| $$$$$$$$| $$  | $$  | $$  | $$ $$ $$| $$ /$$$$\n" +
                "| $$      | $$  | $$| $$__  $$| $$  | $$  | $$  | $$  $$$$| $$|_  $$\n" +
                "| $$      | $$  | $$| $$  | $$| $$  | $$  | $$  | $$\\  $$$| $$  \\ $$\n" +
                "| $$$$$$$$|  $$$$$$/| $$  | $$| $$$$$$$/ /$$$$$$| $$ \\  $$|  $$$$$$/\n" +
                "|________/ \\______/ |__/  |__/|_______/ |______/|__/  \\__/ \\______/ \n" +
                "                                                                    ");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

    }

    public void welcome(){
        System.out.println("##           Welcome to Kelisto Hiring Test                      ##");
        System.out.println("##                                                               ##");
        System.out.println("## This is a store's checkout simulator                          ##");
        System.out.println("## To start, you just need to type the item code and press enter ##");
        System.out.println("## It doesn't matter if it is lower or upper cases               ##");
        System.out.println("## If you introduce a non-existent code, it doesn't appear       ##");
        System.out.println("## To finalize scan process just press enter                     ##");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("                         SCANNING                                  ");
    }
}
