
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
public class OrderList {
// Laver 2 arrayLister - en for de nuværende ordre og en for de tidligere ordre:
    public List<Order> orderListCurrent;
    public List<Order> orderListOld;
    
// Konstruktor:
    public OrderList() {
        orderListCurrent = new ArrayList<>();
        orderListOld = new ArrayList<>();
    }
// Getterer:
    public List<Order> getOrderListCurrent() {
        return orderListCurrent;
    }
    public List<Order> getOrderListOld() {
        return orderListOld;
    }

// Når der skal tilføjes ordre ligges de på orderListCurrent  
    public void addOrder(Order order) {
        orderListCurrent.add(order);
    }
// Når de skal fjernes, fjernes de fra orderListCurrent og tilføjet til orderListOld  
    public void removeOrder(Order order) {
        orderListCurrent.remove(order);
        orderListOld.add(order);
    }
    
// Følgende giver omsætningen
    public double getOrderListOldTotal() {
        double sum=0;
        for(Order order: orderListOld){
            
            sum=sum + order.getOrderTotal();
        }
            
        return sum;
    }
    
    @Override
    public String toString() {
        String result="";
        for(Order order : orderListCurrent){
            result+=order.toString() + "\n";
        }
        return result;
    }
}

