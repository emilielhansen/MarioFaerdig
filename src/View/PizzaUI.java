
package View;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import MarioMain.MainPizzaList;
import Model.Pizza;

public class PizzaUI {
// Show menu:    
    public void ShowTheMenu() throws FileNotFoundException, SQLException, ClassNotFoundException {
        MainPizzaList pizzaList = new MainPizzaList();
       char Retry = 'Y';
            Scanner in = new Scanner(System.in);
             System.out.println("Show menu?: Y/N");
           while(Retry != 'N'){ 
             Retry = in.next().charAt(0);
               if (Retry == 'Y'){
                 String menu = in.nextLine();
                 viewPizzaList(pizzaList);
                 System.out.println("Show menu?: Y/N");     
               } else if (Retry == 'y'){
                 assert true;
               }
           }
    }
// Main Menu:
        public void showMainMenu(){
        System.out.println("************************************************");
        System.out.println("Options:");
        System.out.println("1. Create order");
        System.out.println("2. Show menu");
        System.out.println("3. Move order");
        //System.out.println("4. Show orders");
        System.out.println("9. Exit");
        System.out.println("************************************************");
    }    
    
// Pizza:    
    public void viewPizzaList(MainPizzaList pizzaList){
        for (Pizza m: pizzaList.getPizzaList()){
            System.out.println(m.getNr() + ". " + m.getName() + ": " + m.getIngrediens() + ". " + m.getPrice() + " kr.");
        }
    }
    public void viewPizzaById(int nr) throws ClassNotFoundException, SQLException {
        Pizza pizza = null;
        MainPizzaList mainPizzaList = new MainPizzaList();
        pizza = mainPizzaList.getPizzaFromDBById(nr);
        System.out.println("Pizza:" + pizza);
    }
}
