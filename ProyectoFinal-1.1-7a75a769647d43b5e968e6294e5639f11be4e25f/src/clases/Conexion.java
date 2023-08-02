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
public class Conexion {
    
        public static Connection getConnection(){
        Connection con;
         try{
             try{
                 Class.forName("com.mysql.jdbc.Driver");
             }catch (ClassNotFoundException e){
                 return null;
             }
               con = DriverManager.getConnection("jdbc:mysql://localhost/planilla?characterEncoding=latin1","root","jcmc4003+" );
               return con;
         }catch(SQLException e){
             return null;
         }
    }

      

}
