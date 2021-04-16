package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConectorMariaDB {
    
    public void consulta(String statement) {
            Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mariadb://192.168.0.111:3306/Java","abialanez","luisa97");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(statement);
            if (rs.next()) {
                System.out.println((rs.getString("Nombre") + " " + rs.getString("Apellido")));
            }
            stat.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectorMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
