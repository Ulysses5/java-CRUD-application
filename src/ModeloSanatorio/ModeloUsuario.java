package ModeloSanatorio;

import Conector.ConectorMariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario {
    public String username;
    public String email;
    private String password;



    public ModeloUsuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public ModeloUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public ModeloUsuario() {
        this.username = username;
    }

    
    public int loginUser() throws SQLException{
        ConectorMariaDB con = new ConectorMariaDB();
        ArrayList<String> valores = new ArrayList<String>();
        valores.add(this.username);
        valores.add(this.password);
        con.ejecutarConsultaPreparada("SELECT * FROM `loginInfo` WHERE `username` = ? AND `password` = SHA2(?,256)", valores);
        ResultSet rs = con.getResultSet();
        if(rs.next()){
            
            return(0);
        }
        else{
            return(1);
        }
    }
    public int registerUser() throws SQLException{
        try{
            ConectorMariaDB con = new ConectorMariaDB();
            ArrayList<String> valores = new ArrayList<String>();
            valores.add(this.username);
            valores.add(this.email);
            valores.add(this.password);
            con.ejecutarConsultaPreparada("INSERT INTO `loginInfo`(`username`, `email`, `password`) SELECT ?,?,SHA2(?,256)", valores);
            return 0;
        }
        catch(SQLException e){
            System.out.println(e);
            return(1);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
