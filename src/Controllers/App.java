
package Controllers;

import Model.Order;
import Model.OrderList;
import Model.Pizza;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import View.PizzaUI;
import View.ShowMenu;
import java.sql.SQLException;


/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
public final class App {
    // Laver en arraylist hvor pizzaerne skal tilføjes til:
    private static List<Pizza> pizzas = new ArrayList<>();
    // Laver scanner til Alfonso:
    private static Scanner input = new Scanner(System.in);
    
    // String der bliver brugt i scanneren i createOrder metoden
    private static String makeOrder;
    // String der bliver brugt til at vælge programdelene
    private static String pickOptions;
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException{
        // Metode
        createDefaultPizzas();
        OrderList orderLists = new OrderList();
        PizzaUI showMainMenu = new PizzaUI();
        PizzaUI showTheMenu = new PizzaUI();
        while (true) {
         // Her er der 3 muligheder man kan vælge imellem, ved at indtaste et tal
            showMainMenu.showMainMenu();
            pickOptions = input.next();
            
            if("1".equals(pickOptions)) {
                while (true) {
                 // Her laves der en ny ordre
                    System.out.println("Would you like to make a new order? Y/N: ");
                    makeOrder = input.next();
                        if("Y".equals(makeOrder)) {
                            Order customerOrder = createOrder();
                            System.out.println("Your order is: " + customerOrder.order + "\nThe total price is: " + customerOrder.getOrderTotal() + "\nPickup time: " + customerOrder.getOrderTime());
                            orderLists.addOrder(customerOrder);
                            System.out.println("Your current orders are: ");
                            System.out.println(orderLists.orderListCurrent);
                            
                        }
                        else if("N".equals(makeOrder)) {
                            System.out.println("Going back");
                            break;
            
                        }
                }
            }
         // Viser menuen
            
            else if("2".equals(pickOptions)) {
                showTheMenu.ShowTheMenu();
                
            }
         // Her flyttes oprettede ordre
            else if("3".equals(pickOptions)) {
                while (true) {
                    System.out.println("Your current orders are: ");
                    System.out.println(orderLists.orderListCurrent);
                    System.out.println("Would you like to move an order? Y/N: ");
                    pickOptions = input.next();
                    if("Y".equals(pickOptions)) {
                     // Flytter de nuverende ordre til gamle ordre   
                        moveBetweenLists(orderLists);
                        System.out.println("Total earnings: " + orderLists.getOrderListOldTotal());
                        
                    }
                    
                    else if("N".equals(pickOptions)) {
                        System.out.println("Going back");
                        break;
                    }
                }
            }
        }

    }
    

    public static void createDefaultPizzas() {
        pizzas.add(new Pizza(1, "Vesuvio", "1", 57));
        pizzas.add(new Pizza(2, "Amerikaner", "", 53));
        pizzas.add(new Pizza(3, "Cacciatore", "", 57));
        pizzas.add(new Pizza(4, "Carbona", "", 63));
        pizzas.add(new Pizza(5, "Dennis", "", 65));
        pizzas.add(new Pizza(6, "Bertil", "", 57));
        pizzas.add(new Pizza(7, "Silvia", "", 61));
        pizzas.add(new Pizza(8, "Victoria", "", 61));
        pizzas.add(new Pizza(9, "Toronfo", "", 61));
        pizzas.add(new Pizza(10, "Capricciosa", "", 61));
        pizzas.add(new Pizza(11, "Hawai", "", 61));
        pizzas.add(new Pizza(12, "Le Blissola", "", 61));
        pizzas.add(new Pizza(13, "Venezia", "", 61));
        pizzas.add(new Pizza(14, "Mafia", "", 61));
    }
    
    public static Order createOrder() {
        Order order = new Order();
        int menuNumber;
        
     // Vi har et loop så vi kan lave flere ordre af gangen
        while (true) {
            System.out.print("What menu number would you like to order(-1 to end order)?: ");
            menuNumber = input.nextInt();
            input.nextLine();
            if (menuNumber == -1) {
                break;
            }
         // Sammenligner pizza menuNumber med input så den rigtige pizza bliver valgt
            Pizza pizza = findPizza(menuNumber);

            if (pizza == null) {
                System.out.println("Invalid menu number, try again");
            } else {
                order.addPizza(pizza);
            } 
        }
        System.out.print("Pickup time: ");
     // Metode der gør brug af modulo til at udskrive en pæn pickup time
        order.setTimeOfPickup();
        
        return order;
    }
    
    public static OrderList moveBetweenLists(OrderList orderLists) {
        
        
        int id = 0;
        
        while (true) {
            System.out.print("Which order would you like to move(-1 to quit)?: ");
         // Laver sout på nuværende ordre
            System.out.println(orderLists.getOrderListCurrent());
            id = input.nextInt();
            input.nextLine();
            if (-1 == id) {
                break;
            }


            String message = "no order found";
            for(Order order : orderLists.orderListCurrent) {
                if(order.getId() == id) {
                 // removeOrder fjerne en ordre fra orderListCurrent og derefter 
                 // tilføjer den til orderListOld så den nu er på listen over gamle odre
                    orderLists.removeOrder(order);
                    
                    message = ("Your order has been moved");
                    
                    break;
                }
            }
            System.out.println(message);
         // Metode der tager den totale pris per ordre i listen over gamle ordre
            
            
            
        }
        
        
        return orderLists;
    }
    
    public static Order findOrder(int id, OrderList orderLists) {
     // Metode der sammenligner input med ordre ID og returnere den ordre hvis ID passer til input
        for (Order order : moveBetweenLists(orderLists).orderListCurrent) {
            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }


    public static Pizza findPizza(int menuNumber) {
     // Metode der sammenligner input med pizza menuNumber og returnere den pizza hvis menuNumber passer til input
        for (Pizza pizza : pizzas) {
            if (menuNumber == pizza.getNr()) {
                return pizza;
            }
        }
        return null;
    }
    
    
}
