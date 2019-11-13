
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
public class Order {
// En arrayList, et ID og bestillingstiden    
    public List<Pizza> order;
    public int id;
    private String orderTime;

    public Order() {
        order = new ArrayList<>();
        id = idFactory.getOrderId();
    }
    
    public void setTimeOfPickup(){
        Scanner input = new Scanner(System.in);
        // fx 1915
        int Time = input.nextInt();
        input.nextLine();
        
        int hour = Time/100;
        int minutes = Time%100;
        String finalTime = hour + ":" + minutes;
        orderTime = finalTime;
    }

    public String getOrderTime() {
        return orderTime;
    }
    
    public int getId() {
        return id;
    }

    public List<Pizza> getOrder() {
        return order;
    }

    public void addPizza(Pizza pizza) {
        order.add(pizza);
    }
    //giver det totale beløb per ordre
    public double getOrderTotal() {
        double sum=0;
        for(Pizza pizza: order){
            sum=sum + pizza.price;
        }
            
        return sum;
    }

    @Override
    public String toString() {
        return "\nOrder: " + order + "\nTime of pickup: " + orderTime + "\n Id: " + id;
    }
    
}
