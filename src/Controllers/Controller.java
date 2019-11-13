package Controllers;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import MarioMain.MainPizzaList;
import View.PizzaUI;


public class Controller {
	public void runProgram() throws SQLException, ClassNotFoundException, FileNotFoundException {
		Scanner myScanner  = new Scanner(System.in);
		int choice = 0;
		int exitValue = 9;
		/*
                    int UsrIn; 
                    UsrIn = input.nextInt();
                    int month = UsrIn;
                */
		while (choice != exitValue){
                    switch(choice) {
                        case 1:
                         // Create order
                            // TODO: 
                            // lave en metode til at lave ordre i en database
                            
                            
                            
                        case 2:
                         // Menu
                            PizzaUI showTheMenu = new PizzaUI();
                            showTheMenu.ShowTheMenu();
                            break;
                        case 3:
                         // Move order   
                            // TODO:
                            /* 
                            Lave en database således at når pizzaer bliver 
                            afhentet bliver de fjernet fra de nuværende ordre 
                            og sat ind i en database.
                            Så der kan laves statistik
                            */
                        default:
                            System.out.println("");
                            choice = 9;
                    }
                        
                     // initialiser hovedmenu
                        PizzaUI mainRunMenu = new PizzaUI();
			mainRunMenu.showMainMenu();
                        System.out.println("Pick an option");
			choice = myScanner.nextInt();
                }
        }

        
        public void createOrder(){
            
            
        }
        
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
        
}        
	

