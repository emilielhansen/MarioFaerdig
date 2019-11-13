package View;

import MarioMain.MainPizzaList;
import Model.Pizza;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
public class ShowMenu {
     public static boolean importPizzaNames(String filename) throws FileNotFoundException{
                boolean retVal = false;
                String line = "";
                File file = new File(filename);
                FileReader fr = null;
                try {
                fr = new FileReader(file);
                } catch (Exception e) {
                        System.out.println("Error: " + e.toString());
                        }
                try {
                BufferedReader bw = new BufferedReader (fr);
                while ((line = bw.readLine()) != null){
                    System.out.println(line);
                }
                } catch (Exception e) { 
                    System.out.println("Error: " + e.toString());
                        
                }
   
                return retVal;
    }
    
    
public void viewPizzaList(MainPizzaList pizzaList){
        for (Pizza m: pizzaList.getPizzaList()){
          System.out.println(m.getNr() + ". " + m.getName() + ": " + m.getIngrediens() + ". " + m.getPrice() + " kr.");
        }
    }
  }
