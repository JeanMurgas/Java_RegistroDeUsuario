/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jenmu
 */
public class Conexion2 {
    private static Connection con;
    
    private static boolean conectado = false;
    ////conectar 
    
    public Connection conectar(){
        
        String baseDeDatos = "java";
                String usuario = "root";
                String password = "";
                String host = "localhost";
                String puerto = "3306";
                String driver = "com.mysql.jdbc.Driver";
                
                String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/"+ baseDeDatos + "?useSSL=false";
                
                Connection conexion = null;
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection(conexionUrl ,usuario,password );
  
            } catch (Exception ex) {
                Logger.getLogger(Conexion2.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conexion;    
    }
    
    /////mostar planilla
    
    public DefaultTableModel mostrarPlanilla()
    {
        String []  nombresColumnas = {"id_plantilla","fecha", "cedula_empleado","horas_trabajadas", "sph" ,"sb" , "ss", "se","sn" };
        String [] registros = new String[9];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        //String sql = "SELECT * FROM tbl_planilla";
        //String sql = "SELECT * FROM tbl_detalle_planilla";
        //query de la plantilla
        try
        {
            Connection conexion = conectar();
            String sql = "SELECT * FROM tbl_planilla";
           
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next())
            {
                registros[0] = resultado.getString("id");
                
                registros[1] = resultado.getString("fecha");
                
                modelo.addRow(registros);       
            }
            
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,"Error al conectar (query plantilla)"); 
        }
        //query de la detalle_plantilla
        try
        {
            Connection conexion = conectar();
            String sql = "SELECT * FROM tbl_detalle_planilla";
           
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next())
            {
                registros[2] = resultado.getString("cedula_empleado");
                
                registros[3] = resultado.getString("horas_trabajadas");
                
                registros[4] = resultado.getString("sph");
                
                registros[5] = resultado.getString("sb");
                
                registros[6] = resultado.getString("ss");
                
                registros[7] = resultado.getString("se");
                
                registros[8] = resultado.getString("sn");
                
                modelo.addRow(registros);       
            }     
        }
        catch(SQLException e)
        { 
            JOptionPane.showMessageDialog(null,"Error al conectar (query detalle_plantilla "); 
        }
         return modelo;
    }
    //metodo agregarDatosPlanilla
    public void agregarDatosPlanilla(String fecha){

        
        String sql = "INSERT INTO `tbl_planilla` (`id_planilla`, `fecha`) VALUES (NULL, NULL), (NULL, '"+ fecha +"');";
        String max = "SELECT MAX(id_planilla) FROM tbl_planilla;"; //extraiga el MAX(id_planilla)
        try {
            Connection conexion = conectar();
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
            // Puede crear un procedimiento que me extraiga el MAX(id_planilla) mediante un select para obtener el ultimo id generado.
            ResultSet resultado = statement.executeQuery(max);
            JOptionPane.showMessageDialog(null,"id: " + resultado);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al agregar una planilla");
        }
    
    
    }
    
    //metodo busquedaEmpleado
    
        private String nombre1 = "sin", nombre2 = "sin",apellido1 = "sin",apellido2 = "sin";

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
        
   
        
        
     public void busquedaEmpleado(String cedula){

        
        String sqlNombre1 = "SELECT nombre1 FROM tbl_empleado WHERE cedula = '"+ cedula +"';";
        String sqlNombre2 = "SELECT nombre2 FROM tbl_empleado WHERE cedula = '"+ cedula +"';";
        String sqlApellido1 = "SELECT apellido1 FROM tbl_empleado WHERE cedula = '"+ cedula +"';";
        String sqlApellido2 = "SELECT apellido2 FROM tbl_empleado WHERE cedula = '"+ cedula +"';";
   
        
        try {
            Connection conexion = conectar();
            Statement statement = conexion.createStatement();
            
            //tomar y guardar datos      *Arreglar en caso de que no funciones*

            ResultSet resultado = statement.executeQuery(sqlNombre1);
            nombre1 = resultado.getString(nombre1);
            
            ResultSet resultado2 = statement.executeQuery(sqlNombre2);
            nombre2 = resultado2.getString(nombre2);
            
            ResultSet resultado3 = statement.executeQuery(sqlApellido1);
            apellido1 = resultado3.getString(apellido1);
            
            ResultSet resultado4 = statement.executeQuery(sqlApellido2);
            apellido2 = resultado4.getString(apellido2);
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"no se encontró el Empleado");
        }
    }
     
      public void DatosSalario (String horas, String salario, String cedula){
          
          
          String sql = "INSERT INTO `tbl_detalle_planilla` (`id_planilla`, `cedula_empleado`, `horas_trabajadas`, `sph`, `sb`, `ss`, `se`, `sn`) VALUES (NULL, '"+cedula+"', '"+horas+"', '"+salario +"', NULL, NULL, NULL, NULL);";
          
        try {
        Connection conexion = conectar();
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
            
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"");
        }
    }
}
