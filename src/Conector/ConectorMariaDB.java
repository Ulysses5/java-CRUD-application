package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConectorMariaDB {
    protected Connection conexion;
    protected Statement query;
    protected PreparedStatement sentenciaPreparada;
    protected ResultSet resultSet;
    
    public ConectorMariaDB() {
        String USER = "root";
        String PASSWORD = "";
        String DB = "Java";
        try {
            conexion = DriverManager.getConnection("jdbc:mariadb://192.168.0.105:3306/"+DB,USER,PASSWORD);
            conexion.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void ejecutarConsulta(String consulta) throws SQLException {

        query = conexion.createStatement();
        resultSet = query.executeQuery(consulta);

    }
    public void ejecutarConsultaPreparada(String consulta, ArrayList valores) throws SQLException {

        this.sentenciaPreparada = this.conexion.prepareStatement(consulta);
        rellenarSentenciaPreparada(valores);
        resultSet = sentenciaPreparada.executeQuery();

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
        private void rellenarSentenciaPreparada(ArrayList valores) throws SQLException {

        if (valores != null && valores.size() > 0) {

            int indice = 1;
            for (Object obj : valores) {

                if (obj instanceof Integer) {
                    this.sentenciaPreparada.setInt(indice, (int) obj);
                } else if (obj instanceof String) {
                    this.sentenciaPreparada.setString(indice, (String) obj);
                } else if (obj instanceof Double) {
                    this.sentenciaPreparada.setDouble(indice, (double) obj);
                }

                indice++;

            }
        }

    }

}

