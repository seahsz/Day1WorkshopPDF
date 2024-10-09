// Instructions - Write a Java console program that allows a user to add, remove
//  and list the contents of a shopping cart

import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        boolean stop = false;
        Console cons = System.console();

        System.out.println("Welcome to your shopping cart");

        List<String> cart = new ArrayList<>();

        while (!stop) {
            // list; add apple, orange; delete 2, end
            String input = cons.readLine("CMD>");
            
            String[] inputs = input.replaceAll("\\p{Punct}", "").split(" ");

            switch (inputs[0].trim().toLowerCase()) {
                // list
                case "list":
                    if (cart.size() == 0)
                        System.out.println("Your cart is empty");
                    else {
                        for (int idx = 0; idx < cart.size(); idx++)
                            System.out.printf("%d. %s\n", idx + 1, cart.get(idx));
                    }
                    break;
                
                // add apple, pear
                case "add":
                    for (int idx = 1; idx < inputs.length; idx++) {
                        String toAdd = inputs[idx];
                        if (cart.contains(toAdd))
                            System.out.printf("you have %s in your cart\n", toAdd);
                        else {
                            cart.add(toAdd);
                            System.out.printf("%s added to cart\n", toAdd);
                        }
                    }
                    break;
                
                // delete 2
                case "delete":
                    if (inputs.length > 2) // because to remove by index, only advisable to so one by one to avoid
                                           // errors
                        System.out.println("can only delete 1 item at a time");
                    else {
                        int deleteIdx = Integer.parseInt(inputs[1]);
                        if (deleteIdx <= 0 || deleteIdx > cart.size())
                            System.out.println("Incorrect item index");
                        else {
                            String deletedItem = cart.get(deleteIdx - 1);
                            cart.remove(deleteIdx - 1);
                            System.out.printf("%s removed from cart\n", deletedItem);
                        }
                    }
                    break;

                // to end the program
                case "end":
                    stop = true;
                    break;
                default:
                    System.out.println("this is not a valid input");
                    break;
            }
        }
    }

}
