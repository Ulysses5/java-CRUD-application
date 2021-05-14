package ModeloSanatorio;

import Conector.ConectorMariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class ModeloPersona {


    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String obraSoc;
    private String idObraSoc;
    private String Sexo;
    private String busqueda;
    
    public ModeloPersona(String nombre, String apellido, String dni, String telefono, String direccion, String obraSoc, String idObraSoc, String Sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.obraSoc = obraSoc;
        this.idObraSoc = idObraSoc;
        this.Sexo = Sexo;
    }

    public ModeloPersona(String busqueda) {
        this.busqueda = busqueda;
    }
    public ObservableList<ModeloPersona> getPersonas(){
        ArrayList<String> valores = new ArrayList<String>();
        ObservableList<ModeloPersona> obs = FXCollections.observableArrayList();
        try{
            ConectorMariaDB con = new ConectorMariaDB();
            for (int i = 0; i < 3; i++) {
                valores.add(i,busqueda);
            }
            if ("".equals(busqueda)) {
                con.ejecutarConsulta("SELECT * FROM `persons-tbl`;");
            }
            else{
            con.ejecutarConsultaPreparada(("SELECT *"
                    + " FROM `persons-tbl`"
                    + " WHERE DNI = ?"
                    + " OR Nombre LIKE ?"
                    + " OR Apellido LIKE ?"
                    +";"),valores);
            }
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DNI");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String idos = rs.getString("Num. Obra Social");
                String obraSocial = rs.getString("ID Obra Social");
                String sexo = "No definido";
                if ("0".equals(rs.getString("ID Sexo"))) {
                    sexo = "Hombre";
                }
                else if ("1".equals(rs.getString("ID Sexo"))) {
                    sexo = "Mujer";
                }
                ModeloPersona p = new ModeloPersona(nombre, apellido, dni, telefono, direccion, obraSocial, idos, sexo);
                
                obs.add(p);
            }
            con.cerrarConexion();
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return obs;
        }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObraSoc() {
        return obraSoc;
    }



    public String getIdObraSoc() {
        return idObraSoc;
    }

    public void setIdObraSoc(String idObraSoc) {
        this.idObraSoc = idObraSoc;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
}