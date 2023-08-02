/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
/**
 *
 * @author jenmu
 */
public class empleados {
    private String nombre;
    private String apellido;
    private String nombre2;
    private String apellido2;
    private String cedula;
    private String fechaN;
    private String direccion;
    private String telefono;
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public empleados (){}

    public empleados(String nombre, String apellido, String nombre2, String apellido2, String cedula, String fechaN, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre2 = nombre2;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.fechaN = fechaN;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public boolean InsertarEmpleado (){
    try{
    con = Conexion.getConnection();
    ps = con.prepareCall("call sp_insert_empleado(?,?,?,?,?,?,?,?)");
    ps.setString(1, this.cedula);
    ps.setString(2, this.nombre);
    ps.setString(3, this.nombre2);
    ps.setString(4, this.apellido);
    ps.setString(5, this.apellido2);
    ps.setString(6, this.fechaN);
    ps.setString(7, this.direccion);
    ps.setString(8, this.telefono);
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
    
    
}
