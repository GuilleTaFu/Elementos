package testers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.ConexionServFumaca;

public class conServ {
	

    
	public static void main(String [] args) {
		
	  	String driver = "com.mysql.jdbc.Driver";
	  	String hostname = "200.80.43.56";
	  	String port = "3306";
	  	String username = "gcardill";
	  	String password = "'Tafupanl$$TW2021 ";
	    
	  	Connection conn = null;
	  	
		
    	String database = "gcardill_tfonline";
    	String url;
    	url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    	
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }

		String sSQL =   "";
		try{	
			sSQL = "SELECT * FROM cliente ";
			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
	
				while (rs.next()){
					System.out.println("OK");
				}
				
			ConexionServFumaca.cerrar();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
