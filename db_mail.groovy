/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public Connection connect()
{
    Connection conn = null;
    try
    {
        conn = DriverManager.getConnection("jdbc:postgresql://postgresql:5432/deneme", "root", "root");
        System.out.println("Connected to the PostgreSQL server successfully.");
    }
    catch (SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return conn;
}
*/

import java.sql.*;

def connect()
{
    Class.forName("org.postgresql.Driver");
    Connection con=DriverManager.getConnection("jdbc:postgresql://postgresql:5432/deneme","root","root");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from accounts");
    con.close();
}

return this;
