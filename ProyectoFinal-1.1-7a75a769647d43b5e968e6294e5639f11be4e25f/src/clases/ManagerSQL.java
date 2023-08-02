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
public class ManagerSQL {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Error de Driver"+ e.getMessage());
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost/planilla?characterEncoding=latin1","root","jcmc4003+");
        }catch(SQLException e){
            System.out.println("Error de SQLException"+ e.getMessage());
        }
        
        
        
    }
}
