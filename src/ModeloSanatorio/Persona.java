/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloSanatorio;

import Conector.ConectorMariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String obraSoc;
    private String idObraSoc;
    
    public Persona(String dni) throws SQLException{
        this.dni = dni;
        String username = "USER";
        String password = "PASS";
        String database = "DB";
        ConectorMariaDB con = new ConectorMariaDB(username, password, database, "192.168.0.111", "3306");
        con.ejecutarConsulta("SELECT * FROM `persons-tbl` WHERE DNI="+dni+";");
        ResultSet rs = con.getResultSet();
        while(rs.next()){
            setNombre(rs.getString("Nombre"));
            setApellido(rs.getString("Apellido"));
            setTelefono(rs.getString("Telefono"));
            setDireccion(rs.getString("Direccion"));
            setSexo(rs.getString("ID Sexo"));
            setIdObraSoc(rs.getString("ID Obra Social"));
        }
        con.cerrarConexion();
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

    public void setSexo(String obraSoc) {
        this.obraSoc = obraSoc;
    }

    public String getIdObraSoc() {
        return idObraSoc;
    }

    public void setIdObraSoc(String idObraSoc) {
        this.idObraSoc = idObraSoc;
    }

}
