package connection.web;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

public class ConexionBbDd {
	
	Connection conexion;

	ConexionBbDd() {

		try {

			// creo esta variable para establecer la conexión con mi base de datos local
			String connectionURL = "jdbc:mysql://localhost:3306/Wikianime?autoReconnect=true&useSSL=false";

			// hago la conexión a través de una función de driver manager le paso los
			// parametros de:
			// la variable anterior, el usuario que se conecta y la contraseña
			this.conexion = (Connection) DriverManager.getConnection(connectionURL, "root", "hola123");

		} catch (SQLException e1) {

			e1.printStackTrace();

		}
	}

	public void insertInDbFromQuery(String query, ArrayList<String> parametros) {

		try {

			// Las utilizaremos en lugar de una Statement cuando haya que ejecutar varias
			// veces una misma sentencia
			// SQL con distintos parámetros. Es una sentencia precompilada
			PreparedStatement pst = (PreparedStatement) this.conexion.prepareStatement(query);
			int indice = 1;
			for (String parametro : parametros) {
				// le asignamos el valor de ?, que corresponde al campo nombre
				pst.setString(indice, parametro);
				indice = indice + 1;
			}

			// va añadiendo las diferentes consultas de golpe
			pst.addBatch();

			// por útimo devuelve un entero con el número de filas afectadas
			pst.executeBatch();
			// cerramos la consulta
			pst.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

	}
}
