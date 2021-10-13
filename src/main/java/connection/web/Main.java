package connection.web;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		Scraper accion=new Scraper();
		Anime anime =new Anime();
		
		String url = "https://jkanime.net/genero/psicologico/";
		ConexionBbDd conexio= new ConexionBbDd();
		accion.getGeneroAccion(url);
		
		

	}

	}


