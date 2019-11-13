
package app;

import Model.Order;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */
public class OrderTest {
    /**
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
     // Vi tester om den første oprettede ordre har id 0
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    
}
