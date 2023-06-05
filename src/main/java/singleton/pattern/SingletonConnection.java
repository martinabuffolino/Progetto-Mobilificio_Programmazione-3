package singleton.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection
{
    private static SingletonConnection instance;


    private Statement statement;
    public Connection con;

    private SingletonConnection() {}

    public static SingletonConnection getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonConnection();
            instance.con = instance.connessione();
        }
        return instance;
    }

    private Connection connessione()
    {

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobilificio","root","ciao");
                System.out.println("Connessione al database riuscita ");
                //statement = connection.createStatement();

            }
            catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        return con;
    }
}