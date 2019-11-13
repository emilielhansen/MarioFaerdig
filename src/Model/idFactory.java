/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
//laver nyt ID til ordrene
public class idFactory {
    static int orderId = 0;
    public static int getOrderId() {
        return orderId++;
    }
}
