/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import java.util.Base64;
import java.util.Arrays;

/**
 *
 * @author jenmu
 */
public class Login {
   private String usuario;
   private String nombre;
   private String pass;
   private String CodeUser;
   private String CodePass;
   
   Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
   public Login(){}

    public Login(String usuario, String pass, String CodeUser, String CodePass, String nombre) {
        this.usuario = usuario;
        this.pass = pass;
        this.CodeUser = CodeUser;
        this.CodePass = CodePass;
        this.nombre= nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCodeUser() {
        return CodeUser;
    }

    public void setCodeUser(String CodeUser) {
        this.CodeUser = CodeUser;
    }

    public String getCodePass() {
        return CodePass;
    }

    public void setCodePass(String CodePass) {
        this.CodePass = CodePass;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String ObtenerNombre(){
    try{
    String sql = "select nombre from tbl_usuarios where userid ='"+this.getUsuario()+"'" ;
    con = Conexion.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);
    if(rs.next()){
    this.nombre= rs.getString(0) ;
    
    }
    
    }catch(SQLException e){}
    
    return this.nombre;
    }
}
