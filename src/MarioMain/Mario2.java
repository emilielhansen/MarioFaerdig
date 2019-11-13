
package MarioMain;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import Controllers.Controller;

public class Mario2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
		Controller controller = new Controller();
                controller.runProgram();
	
    }
    
}
