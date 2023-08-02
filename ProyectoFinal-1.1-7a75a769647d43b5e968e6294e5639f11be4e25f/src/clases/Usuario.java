/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import javax.swing.JOptionPane;
import form.frmLogin;
/**
 *
 * @author jenmu
 */

public class Usuario {
    
    
    private String nombre;
    private String usuario;
    private String password;
    private String direccion;
    private String cedula;
    private String apellido;
    private String fechaIngreso;
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario (){}

    public Usuario(String nombre, String usuario, String password, String direccion, String cedula, String apellido, String fechaIngreso) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.cedula = cedula;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
     public boolean InsertarUsuario (){
    try{
    con = Conexion.getConnection();
    ps = con.prepareCall("call sp_insert_usuarios(?,?,?,?,?,?)");
    ps.setString(1, this.cedula);
    ps.setString(2, this.usuario);
    ps.setString(3, this.password);
    ps.setString(4, this.nombre);
    ps.setString(5, this.apellido);
    ps.setString(6, this.direccion);
    rs = ps.executeQuery();
    if(rs.next()){
    con.close();
    return true;
    }
    con.close();
    return false;
    }catch(SQLException e){
    return false;
    }
    }
     
     public boolean Login(){
        
     return true;
     }
}