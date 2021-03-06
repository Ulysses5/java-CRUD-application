package ModeloSanatorio;

import Conector.ConectorMariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
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
    private String fechaNac;
    
    public ModeloPersona(String nombre, String apellido, String dni, String telefono, String direccion, String obraSoc, String idObraSoc, String Sexo, String fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.obraSoc = obraSoc;
        this.idObraSoc = idObraSoc;
        this.Sexo = Sexo;
        this.fechaNac = fechaNac;
    }
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
                valores.add(i,busqueda+"%");
            }
            if ("".equals(busqueda)) {
                con.ejecutarConsulta("SELECT `persons-tbl`.`Nombre`,`DNI`,`Apellido`,`Telefono`,`Direccion`,`Num. Obra Social`,`Obra Social`.`Nombre` as \"Obra Social\",`ID Sexo`"
                        + " FROM `persons-tbl`,`Obra Social`"
                        + " WHERE `persons-tbl`.`ID Obra Social`=`Obra Social`.`ID Obra Social`;");
            }
            else{
            con.ejecutarConsultaPreparada(("SELECT `persons-tbl`.`Nombre`,`DNI`,`Apellido`,`Telefono`,`Direccion`,`Num. Obra Social`,`Obra Social`.`Nombre` as \"Obra Social\",`ID Sexo`"
                    + " FROM `persons-tbl`,`Obra Social`"
                    + " WHERE (DNI LIKE ?"
                    + " OR `persons-tbl`.`Nombre` LIKE ?"
                    + " OR Apellido LIKE ?)"
                    + " AND `persons-tbl`.`ID Obra Social`=`Obra Social`.`ID Obra Social`"
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
                String obraSocial = rs.getString("Obra Social");
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
    public int addPersona(){
        ArrayList<String> valores = new ArrayList<String>();
        try{
            valores.add("Paciente");
            valores.add(this.dni);
            valores.add(this.nombre);
            valores.add(this.apellido);
            valores.add(this.fechaNac);
            if (this.Sexo.equals("Femenino")) {
                valores.add("1");
            }
            else{
                valores.add("0");
            }
            valores.add(this.telefono);
            valores.add(this.direccion);
            valores.add(this.obraSoc);
            valores.add(this.idObraSoc);
            ConectorMariaDB con = new ConectorMariaDB();
            System.out.println(valores);
            con.ejecutarConsultaPreparada(("INSERT INTO"
                    + " `persons-tbl`"
                    + " (`Clasificacion`, `DNI`, `Nombre`, `Apellido`,"
                    + " `Fecha de Nacimiento`, `ID Sexo`, `Telefono`,"
                    + " `Direccion`, `ID Obra Social`, `Num. Obra Social`)"
                    + " VALUES"
                    + " (?,?,?,"
                    + "?,?,?,"
                    + "?,?,"
                    + "(SELECT `ID Obra Social` FROM `Obra Social` WHERE `Nombre`=?),?);"),valores);
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                System.out.println(rs.next());
                return(0);
            }
            con.cerrarConexion();
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return 1;
    }
    public int updatePaciente(){
        ArrayList<String> valores = new ArrayList<String>();
        try{
            valores.add(this.nombre);
            valores.add(this.apellido);
            valores.add(this.fechaNac);
            if (this.Sexo.equals("Femenino")) {
                valores.add("1");
            }
            else{
                valores.add("0");
            }
            valores.add(this.telefono);
            valores.add(this.direccion);
            valores.add(this.obraSoc);
            valores.add(this.idObraSoc);
            valores.add(this.dni);
            ConectorMariaDB con = new ConectorMariaDB();
            System.out.println(valores);
            con.ejecutarConsultaPreparada(("UPDATE `persons-tbl` "
                    + "SET `Nombre`=?,`Apellido`=?,`Fecha de Nacimiento`=?,`ID Sexo`=?,`Telefono`=?,`Direccion`=?,"
                    + "`ID Obra Social`=(SELECT `ID Obra Social` "
                    + "FROM `Obra Social` "
                    + "WHERE `Nombre`=?),`Num. Obra Social`=? "
                    + "WHERE `DNI`=?;"),valores);
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                System.out.println(rs.next());
                return(0);
            }
            con.cerrarConexion();
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return 1;
    }
    public ArrayList<String> getDatosPaciente(String DNI){
        ArrayList<String> busqueda = new ArrayList<String>();
        ArrayList<String> valores = new ArrayList<String>();
        
        busqueda.add(DNI);
        try{
            ConectorMariaDB con = new ConectorMariaDB();
            con.ejecutarConsultaPreparada(("SELECT `persons-tbl`.`Nombre`,`Apellido`,`Telefono`,`Direccion`,`Num. Obra Social`,`Obra Social`.`Nombre` as \"Obra Social\",`Fecha de Nacimiento`,`ID Sexo`"
                    + " FROM `persons-tbl`,`Obra Social`"
                    + " WHERE DNI = ?"
                    + " AND `persons-tbl`.`ID Obra Social`=`Obra Social`.`ID Obra Social`"
                    +";"),busqueda);
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String idos = rs.getString("Num. Obra Social");
                String obraSocial = rs.getString("Obra Social");
                String sexo = "No definido";
                String fechaNac = rs.getString("Fecha de Nacimiento");
                if ("0".equals(rs.getString("ID Sexo"))) {
                    sexo = "Hombre";
                }
                else if ("1".equals(rs.getString("ID Sexo"))) {
                    sexo = "Mujer";
                }
                valores.add(nombre);
                valores.add(apellido);
                valores.add(direccion);
                valores.add(telefono);
                valores.add(idos);
                valores.add(obraSocial);
                valores.add(sexo);
                valores.add(fechaNac);
                
            }
            con.cerrarConexion();
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return valores;
        }
    
    public int deletePaciente(){
        ArrayList<String> delete = new ArrayList<String>();
        try{
            delete.add(this.dni);
            ConectorMariaDB con = new ConectorMariaDB();
            System.out.println(delete);
            con.ejecutarConsultaPreparada(("DELETE FROM `persons-tbl` WHERE `DNI`=?;"),delete);
            ResultSet rs = con.getResultSet();
            while(rs.next()){
                System.out.println(rs.next());
                return(0);
            }
            con.cerrarConexion();
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return 1;
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
