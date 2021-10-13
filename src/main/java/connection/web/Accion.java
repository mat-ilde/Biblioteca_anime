package connection.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * Servlet implementation class Servletconeccion
 */
@SuppressWarnings("serial")
@WebServlet("/accion")

public class Accion extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    
	    try {
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver"); 
	    	String connectionURL = "jdbc:mysql://localhost:3306/Wikianime";

			// hago la conexión a través de una función de driver manager le paso los
			// parametros de:
			// la variable anterior, el usuario que se conecta y la contraseña
	    	Connection conexion = (Connection) DriverManager.getConnection(connectionURL,"root","hola123");
	    	//String accion=(String) request.getAttribute("aventura");
	    	//filtrado por genero de accion
			String sqlAccion =  "SELECT nombreAnime FROM Anime WHERE genero= 'accion' ";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlAccion);	
			//String generos =request.getParameter("accion");
			//String name = request.getParameter("genero");
		    while (rs.next()) {
		    	
		    	String nombre = rs.getString("nombreAnime");
		    	out.println( nombre);
		    
		    }
		   
		} catch (SQLException e) {
			
			out.println("Ha ocurrido un errror extrayendo la lista " + "Animes: " + e.toString());
			
			
			          
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  out.close();
	        
	      }
	
}
