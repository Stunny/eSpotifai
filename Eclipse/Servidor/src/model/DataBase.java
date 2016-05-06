package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import customExceptions.DatabaseNotLoadedException;

public class DataBase {
	static String userName;
	static String password;
	static String db;
	static int port;
	static String url = "jdbc:mysql://localhost";
	static Connection conn = null;
	static Statement s;
	
	public DataBase(String usr, String pass, String db, int port) {
		DataBase.userName = usr;
		DataBase.password = pass;
		DataBase.db = db;
		DataBase.port = port;
		DataBase.url += ":"+port+"/";
		DataBase.url += db;
	}
	
	public void connect() throws DatabaseNotLoadedException{
    	
        try {
            Class.forName("com.mysql.jdbc.Connection");
            conn = (Connection) DriverManager.getConnection(url, userName, password);
            if (conn != null) {
                System.out.println("Conexió a base de dades "+url+" ... Ok");
            }
        }
        catch(SQLException ex) {
            System.out.println("Problema al connecta-nos a la BBDD --> "+ url);
            throw new DatabaseNotLoadedException("Database not loaded.");
        }
        catch(ClassNotFoundException ex2) {
            System.out.println(ex2);
            throw new DatabaseNotLoadedException("Database not loaded.");
        }
        catch (Exception e) {
        	throw new DatabaseNotLoadedException("Database not loaded.");
        }

    }
    
    public void insertQuery(String query){
        try {
            s =(Statement) conn.createStatement();
            s.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Problema al Inserir --> " + ex.getSQLState());
        }
    }
    
    public void updateQuery(String query){
    	 try {
             s =(Statement) conn.createStatement();
             s.executeUpdate(query);

         } catch (SQLException ex) {
             System.out.println("Problema al Modificar --> " + ex.getSQLState());
         }
    }
    
    public void deleteQuery(String query){
    	 try {
             s =(Statement) conn.createStatement();
             s.executeUpdate(query);
             
         } catch (SQLException ex) {
             System.out.println("Problema al Eliminar --> " + ex.getSQLState());
         }
    	
    }
    
    public ResultSet selectQuery(String query){
    	ResultSet rs = null;
    	 try {
             s =(Statement) conn.createStatement();
             rs = s.executeQuery (query);
             
         } catch (SQLException ex) {
             System.out.println("Problema al Recuperar les dades --> " + ex.getSQLState());
         }
		return rs;
    }
    
    public void disconnect(){
    	try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Problema al tancar la connexió --> " + e.getSQLState());
		}
    }
}
