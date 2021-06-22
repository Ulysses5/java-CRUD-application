package ModeloSanatorio;

import Conector.ConectorMariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ModeloObraSocial {
    public String ObraSocial;
    public String IDObraSocial;
    
    public ArrayList<String> getObraSociales(){
        ArrayList<String> valores = new ArrayList<>();
        try{
            ConectorMariaDB con = new ConectorMariaDB();
            con.ejecutarConsulta("SELECT `Nombre` FROM `Obra Social`;");
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                valores.add(rs.getString("Nombre"));
            }
            return valores;
    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return null;
    }
}
