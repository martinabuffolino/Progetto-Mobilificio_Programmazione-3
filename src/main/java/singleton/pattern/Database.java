package singleton.pattern;

import java.sql.*;

/**
 * Classe Database: gestisce le operazioni da fare sul database
 */

public class Database {
    /**
     * Connessione col database ottenuta usando il Pattern Singleton
     */

    private SingletonConnection sc;

    public Database()
    {
        sc=SingletonConnection.getInstance();
    }

    /**
     * Metodo che esegue la query passata in input
     * @param sql Stringa sql
     * @return rs Risultato della query
     * @throws Exception
     */
    public ResultSet query(String sql) throws Exception
    {
        Statement stmt=sc.con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }

    /**
     * Metodo che esegue l'inserimento nel database
     * @param sql Stringa sql
     * @return praperdStmt
     * @throws Exception
     */
    public PreparedStatement insert(String sql) throws Exception
    {
        PreparedStatement preparedStmt = sc.con.prepareStatement(sql);
        return preparedStmt;
    }

    /**
     * Metodo che esegue l'update nel database
     * @param sql Stringa sql
     * @throws Exception
     */
    public void delete(String sql) throws Exception
    {
        Statement stmt = sc.con.createStatement();
        stmt.executeUpdate(sql);
    }
}
