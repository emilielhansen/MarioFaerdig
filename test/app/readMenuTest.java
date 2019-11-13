/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
/*
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class readMenuTest {
    
    String filename;
    
    @Before
    public void setUp() {
        filename = "Data/PizzaMenukort.csv";
    }
    
    @Test
    public void readMenu() throws FileNotFoundException, IOException{
        // Vi forventer at den printer menukortet ud
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String menu = null;
            while ((menu = br.readLine()) != null) {
                System.out.println(menu);
            }
        } 
        
    }
    
}

