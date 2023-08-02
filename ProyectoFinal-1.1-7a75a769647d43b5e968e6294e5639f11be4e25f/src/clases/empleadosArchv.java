/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author jenmu
 */
public class empleadosArchv extends empleados {
private int horasT;
private int salarioH;

Connection con;
Statement st;
ResultSet rs;
PreparedStatement ps;
    public empleadosArchv() {
    }

    public empleadosArchv(String nombre, String apellido, String nombre2, String apellido2, String cedula, String fechaN, String direccion, String telefono) {
        super(nombre, apellido, nombre2, apellido2, cedula, fechaN, direccion, telefono);
    }

    public empleadosArchv(int horasT, int salarioH) {
        this.horasT = horasT;
        this.salarioH = salarioH;
    }

    public double getHorasT() {
        return horasT;
    }

    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }

    public double getSalarioH() {
        return salarioH;
    }

    public void setSalarioH(int salarioH) {
        this.salarioH = salarioH;
    }
    
    public double SalarioBruto() {
        double bruto = horasT * salarioH;
        return bruto;
    }

    public double SeguroSocial() {
        double Seguros = SalarioBruto() * 0.0975;
        return Seguros;
    }

    public double SeguroEducativo() {
        double SE = SalarioBruto() * 0.0125;
        return SE;
    }

    public double SalarioNeto() {
        double neto = SalarioBruto() - SeguroEducativo() - SeguroSocial();
        return neto;
    }
    
    public void insertarSalarios(){
    try{
        int resultado = 0;
    String us = super.getCedula();
    con = Conexion.getConnection();
    ps = con.prepareCall("call sp_insert_detalle_planilla where cedula_empleado ='"+us+"'");
    ps.setString(3, ""+this.getHorasT());
    ps.setString(4, ""+this.getSalarioH());
    ps.setString(5, ""+SalarioBruto());
    ps.setString(6, ""+SeguroSocial());
    ps.setString(7, ""+SeguroEducativo());
    ps.setString(8, ""+SalarioNeto());
    if(rs.next()){ 
    resultado = 1;
    if(resultado==1){
    JOptionPane.showMessageDialog(null, "Planilla insertada correctamente");
    }else{
    JOptionPane.showMessageDialog(null, "Fallo al insertar planilla");
    }
    
    }
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Fallo al insertar planilla"+e.getMessage());
    }
    
    
    }
}
