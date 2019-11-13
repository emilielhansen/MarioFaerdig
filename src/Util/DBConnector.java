
package Util;
import java.sql.*;

public class DBConnector {
        public Connection getConnector() throws ClassNotFoundException, SQLException{
            Connection connector = null;
            String url = "jdbc:mysql://localhost:3306/orders?";
            url += "serverTimezone=UTC&allowPublicKeyRetrieval=true&";
            url += "useSSL=false";
            String user = "root";
            String password = "caching_sha2_password";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connector = DriverManager.getConnection(url,user,password);

            return connector;
        }

}
