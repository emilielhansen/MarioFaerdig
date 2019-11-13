/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarioMain;

import java.sql.SQLException;
import java.util.ArrayList;
import DataMappers.PizzaMapper;
import Model.Pizza;

/**
 *
 * @author miade
 */
public class MainPizzaList {
        ArrayList<Pizza> pizzas;
        PizzaMapper mapper = new PizzaMapper();
    
    public MainPizzaList() throws SQLException, ClassNotFoundException{
        pizzas = new ArrayList<>();
        fillListFromDB();
    }
    
    public ArrayList<Pizza> getPizzaList(){
        return pizzas;
    }
    
    public void fillListFromDB() throws SQLException, ClassNotFoundException{
        pizzas = mapper.pizzaList();
    }
    
    public Pizza getPizzaFromDBById(int id) throws ClassNotFoundException, SQLException{
        Pizza pizza = null;
        pizza = mapper.getPizzaFromDBById(id);
        return pizza;
    }
    
    public void fillListFromFile(){
        pizzas = null;
    }
}
