package connection.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Animes")
public class ShowAnimeWeb extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "Mati";
		request.setAttribute("label",name);
		RequestDispatcher rd= request.getRequestDispatcher("add.jsp");
		rd.forward(request, response);
	}
}
