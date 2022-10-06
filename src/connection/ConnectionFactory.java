/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/** 
 *
 * @author 04031966040
 */
public class ConnectionFactory {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/estacionamento";
    private final static String USER = "root";
    private final static String PASS = "";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na Conexão: ", e);
        }
    }
    public static void closeConnection(Connection con) {
        try{
            if(con != null) {
                con.close();
            }  
        } 
        catch (SQLException e) {
                    throw new RuntimeException("Erro ao desconectar: ", e);
         }
        
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try{
            if(stmt != null) {
                stmt.close();
            }  
        } 
        catch (SQLException e) {
                    throw new RuntimeException("Erro ao desconectar: ", e);
         }
        
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try{
            if(rs != null) {
                rs.close();
            }  
        } 
        catch (SQLException e) {
                    throw new RuntimeException("Erro ao desconectar: ", e);
         }
        
    }
}

// comentario