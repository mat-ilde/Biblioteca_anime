package connection.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Accion
 */
@WebFilter("/aventura")
public class Filtro implements Filter {

  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		HttpServletRequest req =(HttpServletRequest) request;
		
		
		String accion=(String) request.getAttribute("accion");
		String aventura=request.getParameter("aventura");
		chain.doFilter(req, response);
		
		
		/*String comedia=request.getParameter("comedia");
		String drama=request.getParameter("drama");
		String psicologico=request.getParameter("psicologico");
		String romance=request.getParameter("romance");
		String sobrenatural=request.getParameter("sobrenatural");
		String yaoi=request.getParameter("yaoi");*/
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
