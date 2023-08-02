/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author jenmu
 */
public class DetallePlanilla {
    private int id_planilla;
        private String cedula_empleado;
        private double horas_trabajadas;
        private double sph;
        private double sb;
        private double ss;
        private double se;
        private double sn;
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

    public DetallePlanilla() {
    }

    public DetallePlanilla(int id_planilla, String cedula_empleado, double horas_trabajadas, double sph, double sb, double ss, double se, double sn) {
        this.id_planilla = id_planilla;
        this.cedula_empleado = cedula_empleado;
        this.horas_trabajadas = horas_trabajadas;
        this.sph = sph;
        this.sb = sb;
        this.ss = ss;
        this.se = se;
        this.sn = sn;
    }

    public int getId_planilla() {
        return id_planilla;
    }

    public void setId_planilla(int id_planilla) {
        this.id_planilla = id_planilla;
    }

    public String getCedula_empleado() {
        return cedula_empleado;
    }

    public void setCedula_empleado(String cedula_empleado) {
        this.cedula_empleado = cedula_empleado;
    }

    public double getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(double horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public double getSph() {
        return sph;
    }

    public void setSph(double sph) {
        this.sph = sph;
    }

    public double getSb() {
        return sb;
    }

    public void setSb(double sb) {
        this.sb = sb;
    }

    public double getSs() {
        return ss;
    }

    public void setSs(double ss) {
        this.ss = ss;
    }

    public double getSe() {
        return se;
    }

    public void setSe(double se) {
        this.se = se;
    }

    public double getSn() {
        return sn;
    }

    public void setSn(double sn) {
        this.sn = sn;
    }
    
    public void calculos(){
        this.sb = this.horas_trabajadas * this.sph;
        this.se = this.sb * 0.0125;
        this.ss = this.sb * 0.0975;
        this.sn = this.sb - this.se - this.ss;
    }
    
     public boolean Insertar(){
        try{
            con = Conexion.getConnection();
            ps = con.prepareCall("call sp_insert_detalle_planilla(?,?,?,?,?,?,?,?)" );
            ps.setInt(1, this.id_planilla);
            ps.setString(2, this.cedula_empleado);
            ps.setDouble(3, this.horas_trabajadas);
            ps.setDouble(4, this.sph);
            ps.setDouble(5, this.sb);
            ps.setDouble(6, this.ss);
            ps.setDouble(7, this.se);
            ps.setDouble(8, this.sn);
            
            rs = ps.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString("respuesta"));
                con.close();
                return true;
            }
            con.close();
            return false;
        }catch (SQLException e){
            return false;
        }
    }

    public ArrayList<DetallePlanilla> calculoPlanilla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
