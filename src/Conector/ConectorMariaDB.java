package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConectorMariaDB {
    protected Connection conexion;
    protected Statement query;
    protected PreparedStatement sentenciaPreparada;
    protected ResultSet resultSet;
    
    public ConectorMariaDB(String USER, String PASSWORD, String DB, String IP, String PORT) {
        try {
            conexion = DriverManager.getConnection("jdbc:mariadb://"+ IP +":"+ PORT +"/"+DB,USER,PASSWORD);
            conexion.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void ejecutarConsulta(String consulta) throws SQLException {

        query = conexion.createStatement();
        resultSet = query.executeQuery(consulta);

    }


    public Statement getQuery() {
        return query;
    }

    public PreparedStatement getSentenciaPreparada() {
        return sentenciaPreparada;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
    public void cerrarConexion() {
        try {
            if (resultSet != null) {
                cerrarResult();
            }
            if (query != null) {
                cerrarSentencia();
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarResult() {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarSentencia() {
        try {
            query.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
