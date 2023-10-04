package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static Connection myconnection ;
    private static String url ="jdbc:mysql://localhost/atelier1";
    private static String user ="root";
    private static String password ="";

    private ConnectionJDBC() throws SQLException, ClassNotFoundException {
        System.out.print("Instance jbdc ");
        Class.forName("com.mysql.cj.jdbc.Driver");
        myconnection = DriverManager.getConnection(url , user ,password );

    }

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (myconnection == null){
            new ConnectionJDBC();
        }
        return myconnection;
    }
}
