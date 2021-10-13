package connection.web;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.jdi.connect.spi.Connection;

public class Anime {
	
	String nombre;
	String genero;
	Connection conex;

	Anime() {

	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {

		return this.nombre;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {

		return this.genero;
	}
	public void insertIntoDB(ConexionBbDd conexion) {

		// guardo en una variable la query que quiero q me haga en este caso es insertar
		// datos

		String sql = "INSERT INTO Anime (nombreAnime,genero)" + " VALUES(?,?) ON DUPLICATE KEY UPDATE  nombreAnime=nombreAnime, genero=genero";
				
		ArrayList<String> parametros = new ArrayList<>();
		parametros.add(this.nombre);
		parametros.add(this.genero);
		conexion.insertInDbFromQuery(sql, parametros);

	}
}
