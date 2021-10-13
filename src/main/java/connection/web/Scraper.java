package connection.web;

import org.jsoup.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.*;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;


@SuppressWarnings("unused")
public class Scraper {
	
	private String url;
	
	
	private ArrayList<String> listaAnimes = new ArrayList<>();    
	//constructor
	Scraper(){
		
	}
	// obtener lista de animes de acción 
	// esto es por si quiero que me devuelva una lista
	//public ArrayList<String> getGeneroAccion(String url) throws IOException 
	public void getGeneroAccion(String url) throws IOException, SQLException {
	
		this. url= url;
		Document doc = Jsoup.connect(url).get();
		
		//Elements allElements= doc.getElementsByTag("a");
		Elements allElements = doc.select ("a[href*=https://jkanime.net]");
		
		//System.out.println("Animes de acción: ");
		ConexionBbDd conex= new ConexionBbDd();
		for (Element element: allElements) {
			  
			
			//guardo en la variable genero el cast a string para poder hacer el split
			String genero=element.toString();  
			//  creo un array de string y gurado el split que hago  desde jkanime.net/ porque es uno de los patrones que se repite
			String[] primerSplit = genero.split("jkanime.net/");
			
			// guardo el resultado del split en la posición 1 del array anterior
			String nombrE = primerSplit[1]; // 004
			
			// hago split nuevamente pero esta vez teniendo en cuenta los espacios
			String[] segundoSplit=nombrE.split("=");
			
			String nombre = segundoSplit[0]; 
			
			String[] tercerSplit = nombre.split("<div class");
			String m=tercerSplit[0];
			String[] cuartoSplit = m.split("/\">");
			String animeAccion=cuartoSplit[0];
			this.listaAnimes.add(animeAccion);
			
			//HashSet contiene un conjunto de objetos, 
			//pero de una manera que le permite determinar fácil y rápidamente si un objeto ya está en el conjunto o no
			//mi explicación: es un objeto que determina facil y rápidamente si contiene otro objeto repetido o no
			HashSet hs = new HashSet();
		       
		     //Lo cargamos con los valores del array, esto hace quite los repetidos
		        hs.addAll(listaAnimes);
		       
		     //Limpiamos el array
		        listaAnimes.clear();
		       
		     //Agregamos los valores sin repetir
		        listaAnimes.addAll(hs);
			
		}
		for (int i = 0; i< listaAnimes.size(); i++) {
			
			if(listaAnimes.get(i).equals("genero/psicologico/2/\" rel")) {
				String temp= listaAnimes.get(i);
				
				
				temp=" ";
			}else {
				
				String nombreAnime=listaAnimes.get(i);
				Anime anime= new Anime();
				anime.setNombre(nombreAnime);
				anime.setGenero("psicologico");
				anime.insertIntoDB(conex);
				
				
				System.out.println(anime.getNombre());
				
				
			}
	
			
		}
		
		
		
	}
	
}
