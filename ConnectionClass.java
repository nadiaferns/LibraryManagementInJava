/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.sql.*;
/**
 *
 * @author nadia
 */
public class ConnectionClass {
    public Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
        try{
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         Connection con=DriverManager.getConnection(url,uname,pass);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
